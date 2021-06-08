package Controladores;

import Modelos.Laboratorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo2
 */
public class LaboratorioData {

    private Connection connection;

    private void mensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public LaboratorioData() {
        try {
            connection = Conexion.getConexion();
        } catch (SQLException ex) {
            mensaje("Error al obtener la conexion en LaboratorioData");
        } catch (ClassNotFoundException cnf) {
            mensaje("Error al cargar los drivers.");
        }
    }

    public void guardarLaboratorio(Laboratorio laboratorio) {
        ArrayList<Laboratorio> lista = obtenerLaboratorios();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(laboratorio)) {
                mensaje("El laboratorio " + laboratorio.getNombreComercial() + " ya se encuentra guardado en la BD.");
                return;
            }
        }
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO laboratorio VALUES (NULL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, laboratorio.getDireccion());
            ps.setString(2, laboratorio.getNombreComercial());
            ps.setString(3, laboratorio.getPaisDeOrigen());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                laboratorio.setIdLaboratorio(rs.getInt(1));
                mensaje("El laboratorio " + laboratorio.getNombreComercial() + " ha sido guardado correctamente en la BD.");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("El laboratorio " + laboratorio.getNombreComercial() + " no ha podido ser guardado correctamente en la BD. Error: " + ex.getMessage());
        }
    }

    public ArrayList<Laboratorio> obtenerLaboratorios() {
        ArrayList<Laboratorio> lista = new ArrayList<>();
        Laboratorio laboratorio;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM laboratorio");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                laboratorio = new Laboratorio();
                laboratorio.setIdLaboratorio(rs.getInt("idLaboratorio"));
                laboratorio.setDireccion(rs.getString("direccion"));
                laboratorio.setNombreComercial(rs.getString("nombreComercial"));
                laboratorio.setPaisDeOrigen(rs.getString("paisDeOrigen"));
                lista.add(laboratorio);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("Error al obtener la lista de los laboratorios de la BD: " + ex.getMessage());
        }
        Collections.sort(lista);
        return lista;
    }

    public void borrarLaboratorio(int idLaboratorio) {
        Laboratorio l = buscarLaboratorio(idLaboratorio);
        if (l == null) {
            System.out.println("El laboratorio no ha podido ser borrado porque no existe en la BD.");
        } else {
            try {
                PreparedStatement ps = connection.prepareStatement("DELETE FROM laboratorio WHERE idLaboratorio = ?", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, idLaboratorio);
                if ((ps.executeUpdate() == 1)) {
                    mensaje("El laboratorio " + l.getNombreComercial() + " ha sido borrado correctamente en la BD.");
                }
                ps.close();
            } catch (SQLException ex) {
                mensaje("El laboratorio " + l.getNombreComercial() + " no ha podido ser borrado correctamente en la BD. Error: " + ex.getMessage());
            }
        }
    }

    public void actualizarLaboratorio(Laboratorio laboratorio) {
        ArrayList<Laboratorio> lista = obtenerLaboratorios();
        Laboratorio lab = laboratorio;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(lab)) {
                mensaje("El laboratorio " + laboratorio.getNombreComercial() + " no ha podido ser actualizado porque no hay cambios que reflejar en la BD.");
                return;
            }
        }
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE laboratorio SET direccion = ?, nombreComercial = ?, paisDeOrigen = ? WHERE idLaboratorio = ?", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, laboratorio.getDireccion());
                ps.setString(2, laboratorio.getNombreComercial());
                ps.setString(3, laboratorio.getPaisDeOrigen());
                ps.setInt(4, laboratorio.getIdLaboratorio());
                if (ps.executeUpdate() == 1) {
                    mensaje("El laboratorio " + laboratorio.getNombreComercial() + " ha sido actualizado correctamente en la BD.");
                }
                ps.close();
            } catch (SQLException ex) {
                mensaje("El laboratorio " + laboratorio.getNombreComercial() + " no ha podido ser actualizado correctamente en la BD. Error: " + ex.getMessage());
            }
        }

    public Laboratorio buscarLaboratorio(int idLaboratorio) {
        Laboratorio laboratorio = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM laboratorio WHERE idLaboratorio = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idLaboratorio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                laboratorio = new Laboratorio();
                laboratorio.setIdLaboratorio(rs.getInt("idLaboratorio"));
                laboratorio.setDireccion(rs.getString("direccion"));
                laboratorio.setNombreComercial(rs.getString("nombreComercial"));
                laboratorio.setPaisDeOrigen(rs.getString("paisDeOrigen"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("El laboratorio no existe en la BD. Error: " + ex.getMessage());
        }
        return laboratorio;
    }
}
