package Controladores;

import Modelos.Patologia;
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
public class PatologiaData {

    private Connection connection;

    private void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public PatologiaData() {
        try {
            connection = Conexion.getConexion();
        } catch (SQLException ex) {
            mensaje("Error al obtener la conexion en PatologiaData. Error: " + ex.getMessage());
        } catch (ClassNotFoundException cnf) {
            mensaje("Error al cargar los drivers.");
        }
    }

    public void guardarPatologia(Patologia patologia) {
        ArrayList<Patologia> lista = obtenerPatologias();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(patologia)) {
                mensaje(patologia.getNombrePatologia() + " ya se encuentra guardada en la BD.");
                return;
            }
        }
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO patologias VALUES (NULL,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, patologia.getNombrePatologia());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                patologia.setIdPatologia(rs.getInt(1));
                mensaje("La patologia " + patologia.getNombrePatologia() + " ha sido guardada correctamente en la BD.");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("La patologia " + patologia.getNombrePatologia() + " no ha podido ser guardada correctamente en la BD. Error: " + ex.getMessage());
        }
    }

    public ArrayList<Patologia> obtenerPatologias() {
        ArrayList<Patologia> lista = new ArrayList<>();
        Patologia patologia;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM patologias");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                patologia = new Patologia();
                patologia.setIdPatologia(rs.getInt("idPatologia"));
                patologia.setNombrePatologia(rs.getString("nombrePatologia"));
                lista.add(patologia);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("Error al obtener la lista de las patologias en la BD: " + ex.getMessage());
        }
        Collections.sort(lista);
        return lista;
    }

    public void borrarPatologia(int idPatologia) {
        Patologia p = buscarPatologia(idPatologia);
        if (p == null) {
            System.out.println("La patologia no ha podido ser borrada porque no existe en la BD.");
        } else {
            try {
                PreparedStatement ps = connection.prepareStatement("DELETE FROM patologias WHERE idPatologia = ?", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, idPatologia);
                if ((ps.executeUpdate() == 1)) {
                    mensaje("La patologia " + p.getNombrePatologia() + " ha sido borrado correctamente en la BD.");
                    ps.close();
                }
            } catch (SQLException ex) {
                mensaje("La patologia " + p.getNombrePatologia() + " no ha podido ser borrado correctamente en la BD. Error: " + ex.getMessage());
            }
        }
    }

    public void actualizarNombreDeLaPatologia(Patologia patologia) {
        ArrayList<Patologia> lista = obtenerPatologias();
        Patologia p = patologia;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(p)) {
                mensaje("La patologia " + patologia.getNombrePatologia() + " no ha podido ser actualizada porque no hay cambios que reflejar en la BD.");
                return;
            }
        }
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE patologias SET nombrePatologia = ? WHERE idPatologia = ?", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, patologia.getNombrePatologia());
                ps.setInt(2, patologia.getIdPatologia());
                if (ps.executeUpdate() == 1) {
                    mensaje("La patologia " + patologia.getNombrePatologia() + " ha sido actualizado correctamente en la BD.");
                }
                ps.close();
            } catch (SQLException ex) {
                mensaje("La patologia " + patologia.getNombrePatologia() + " no ha podido ser actualizado correctamente en la BD. Error: " + ex.getMessage());
            }
    }

    public Patologia buscarPatologia(int idPatologia) {
        Patologia patologia = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM patologias WHERE idPatologia = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idPatologia);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                patologia = new Patologia();
                patologia.setIdPatologia(rs.getInt("idPatologia"));
                patologia.setNombrePatologia(rs.getString("nombrePatologia"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("La patologia no existe en la BD. Error: " + ex.getMessage());
        }
        return patologia;
    }
}
