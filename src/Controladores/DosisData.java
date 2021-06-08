package Controladores;

import Modelos.Dosis;
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
public class DosisData {

    private Connection connection;

    private void mensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public DosisData() {
        try {
            connection = Conexion.getConexion();
        } catch (SQLException ex) {
            mensaje("Error al obtener la conexion en DosisData");
        } catch (ClassNotFoundException cnf) {
            mensaje("Error al cargar los drivers.");
        }
    }

    public void guardarDosis(Dosis dosis) {
        ArrayList<Dosis> lista = obtenerDosis();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(dosis)) {
                mensaje("La dosis con numero de serie: " + dosis.getNumDeSerie() + " ya se encuentra guardada en la BD.");
                return;
            }
        }
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO dosis VALUES (NULL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setBoolean(1, dosis.isEstado());
            ps.setInt(2, dosis.getNumDeSerie());
            ps.setInt(3, dosis.getLaboratorio().getIdLaboratorio());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dosis.setIdDosis(rs.getInt(1));
                mensaje("La dosis con numero de serie: " + dosis.getNumDeSerie() + " ha sido guardada correctamente en la BD.");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("La dosis con numero de serie: " + dosis.getNumDeSerie() + " no ha podido ser guardada correctamente en la BD. Error: " + ex.getMessage());
        }
    }

    public ArrayList<Dosis> obtenerDosis() {
        ArrayList<Dosis> lista = new ArrayList<>();
        Dosis dosis;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM dosis");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dosis = new Dosis();
                dosis.setIdDosis(rs.getInt("idDosis"));
                dosis.setEstado(rs.getBoolean("estado"));
                dosis.setNumDeSerie(rs.getInt("numDeSerie"));
                dosis.setLaboratorio(new LaboratorioData().buscarLaboratorio(rs.getInt("idLaboratorio")));
                lista.add(dosis);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("Error al obtener la lista de las dosis en la BD: " + ex.getMessage());
        }
        Collections.sort(lista);
        return lista;
    }

    public void borrarDosis(int idDosis) {
        Dosis d = buscarDosis(idDosis);
        if (d == null) {
            System.out.println("La dosis no ha podido ser borrada porque no existe en la BD.");
        } else {
            try {
                PreparedStatement ps = connection.prepareStatement("DELETE FROM dosis WHERE idDosis = ?", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, idDosis);
                if ((ps.executeUpdate() == 1)) {
                    mensaje("La dosis con numero de serie " + d.getNumDeSerie() + " ha sido borrada correctamente en la BD.");
                }
                ps.close();
            } catch (SQLException ex) {
                mensaje("La dosis con numero de serie " + d.getNumDeSerie() + " no ha podido ser borrada correctamente en la BD. Error: " + ex.getMessage());
            }
        }
    }

    public void actualizarDosis(Dosis dosis) {
        ArrayList<Dosis> lista = obtenerDosis();
        Dosis d = dosis;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(d)) {
                mensaje("La dosis con numero de serie: " + dosis.getNumDeSerie() + " no ha podido ser actualizada porque no hay cambios que reflejar en la BD.");
                return;
            }
        }
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE dosis SET estado = ?, numDeSerie = ?, idLaboratorio = ? WHERE idDosis = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setBoolean(1, dosis.isEstado());
            ps.setInt(2, dosis.getNumDeSerie());
            if (dosis.getLaboratorio() != null) {
                ps.setInt(3, dosis.getLaboratorio().getIdLaboratorio());
            } else {
                ps.setNull(3, java.sql.Types.NULL);
            }
            ps.setInt(4, dosis.getIdDosis());
            if (ps.executeUpdate() == 1) {
                mensaje("La dosis con numero de serie: " + dosis.getNumDeSerie() + " ha sido actualizada correctamente en la BD.");
            }
            ps.close();
        } catch (SQLException ex) {
            mensaje("La dosis con numero de serie: " + dosis.getNumDeSerie() + " no ha podido ser actualizada correctamente en la BD. Error: " + ex.getMessage());
        }
    }

    public Dosis buscarDosis(int idDosis) {
        Dosis dosis = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM dosis WHERE idDosis = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idDosis);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dosis = new Dosis();
                dosis.setIdDosis(rs.getInt("idDosis"));
                dosis.setEstado(rs.getBoolean("estado"));
                dosis.setNumDeSerie(rs.getInt("numDeSerie"));
                dosis.setLaboratorio(new LaboratorioData().buscarLaboratorio(rs.getInt("idLaboratorio")));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("La dosis no existe en la BD. Error: " + ex.getMessage());
        }
        return dosis;
    }
}
