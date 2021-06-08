package Controladores;

import Modelos.CentroDeVacunacion;
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
public class CentroDeVacunacionData {

    private Connection connection;

    private void mensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public CentroDeVacunacionData() {
        try {
            connection = Conexion.getConexion();
        } catch (SQLException ex) {
            mensaje("Error al obtener la conexion en CentroDeVacunacionData");
        } catch (ClassNotFoundException cnf) {
            mensaje("Error al cargar los drivers.");
        }
    }

    public void guardarCentroDeVacunacion(CentroDeVacunacion centroDeVacunacion) {
        ArrayList<CentroDeVacunacion> lista = obtenerCentrosDeVacunaciones();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(centroDeVacunacion)) {
                mensaje("El centro de vacunacion " + centroDeVacunacion.getNombreCentroDeVacunacion() + " ya se encuentra guardado en la BD.");
                return;
            }
        }
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO centrodevacunacion VALUES (NULL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, centroDeVacunacion.getNombreCentroDeVacunacion());
            ps.setString(2, centroDeVacunacion.getCiudad());
            ps.setString(3, centroDeVacunacion.getDepartamento());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                centroDeVacunacion.setIdCentroDeVacunacion(rs.getInt(1));
                mensaje("El centro de vacunacion " + centroDeVacunacion.getNombreCentroDeVacunacion() + " ha sido guardado correctamente en la BD.");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("El centro de vacunacion " + centroDeVacunacion.getNombreCentroDeVacunacion() + " no ha podido ser guardado correctamente en la BD. Error: " + ex.getMessage());
        }
    }

    public ArrayList<CentroDeVacunacion> obtenerCentrosDeVacunaciones() {
        ArrayList<CentroDeVacunacion> lista = new ArrayList<>();
        CentroDeVacunacion centroDeVacunacion;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM centrodevacunacion");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                centroDeVacunacion = new CentroDeVacunacion();
                centroDeVacunacion.setIdCentroDeVacunacion(rs.getInt("idCentroDeVacunacion"));
                centroDeVacunacion.setNombreCentroDeVacunacion(rs.getString("nombreCentroDeVacunacion"));
                centroDeVacunacion.setCiudad(rs.getString("ciudad"));
                centroDeVacunacion.setDepartamento(rs.getString("departamento"));
                lista.add(centroDeVacunacion);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("Error al obtener la lista de los centros de vacunacion en la BD: " + ex.getMessage());
        }
        Collections.sort(lista);
        return lista;
    }

    public void borrarCentroDeVacunacion(int idCentroDeVacunacion) {
        CentroDeVacunacion cdv = buscarCentroDeVacunacion(idCentroDeVacunacion);
        if (cdv == null) {
            System.out.println("El centro de vacunacion no ha podido ser borrada porque no existe en la BD.");
        } else {
            try {
                PreparedStatement ps = connection.prepareStatement("DELETE FROM centrodevacunacion WHERE idCentroDeVacunacion = ?", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, idCentroDeVacunacion);
                if ((ps.executeUpdate() == 1)) {
                    mensaje("El centro de vacunación " + cdv.getNombreCentroDeVacunacion() + " ha sido borrado correctamente en la BD.");
                }
                ps.close();
            } catch (SQLException ex) {
                mensaje("El centro de vacunación " + cdv.getNombreCentroDeVacunacion() + " no ha podido ser borrado correctamente en la BD. Error: " + ex.getMessage());
            }
        }
    }

    public void actualizarCentroDeVacunacion(CentroDeVacunacion centroDeVacunacion) {
        ArrayList<CentroDeVacunacion> lista = obtenerCentrosDeVacunaciones();
        CentroDeVacunacion cdv = centroDeVacunacion;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(cdv)) {
                mensaje("El centro de vacunacion " + cdv.getNombreCentroDeVacunacion() + " no ha podido ser actualizado porque no hay cambios que reflejar en la BD.");
                return;
            }
        }
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE centrodevacunacion SET nombreCentroDeVacunacion = ?, ciudad = ?, departamento = ? WHERE idCentroDeVacunacion = ?", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, centroDeVacunacion.getNombreCentroDeVacunacion());
                ps.setString(2, centroDeVacunacion.getCiudad());
                ps.setString(3, centroDeVacunacion.getDepartamento());
                ps.setInt(4, centroDeVacunacion.getIdCentroDeVacunacion());
                if (ps.executeUpdate() == 1) {
                    mensaje("El centro de vacunacion " + cdv.getNombreCentroDeVacunacion() + " ha sido actualizado correctamente en la BD.");
                }
                ps.close();
            } catch (SQLException ex) {
                mensaje("El centro de vacunacion " + cdv.getNombreCentroDeVacunacion() + " no ha podido ser actualizado correctamente en la BD. Error: " + ex.getMessage());
            }
    }

    public CentroDeVacunacion buscarCentroDeVacunacion(int idCentroDeVacunacion) {
        CentroDeVacunacion centroDeVacunacion = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM centrodevacunacion WHERE idCentroDeVacunacion = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idCentroDeVacunacion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                centroDeVacunacion = new CentroDeVacunacion();
                centroDeVacunacion.setIdCentroDeVacunacion(rs.getInt("idCentroDeVacunacion"));
                centroDeVacunacion.setNombreCentroDeVacunacion(rs.getString("nombreCentroDeVacunacion"));
                centroDeVacunacion.setCiudad(rs.getString("ciudad"));
                centroDeVacunacion.setDepartamento(rs.getString("departamento"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("El centro de vacunación no existe en la BD. Error: " + ex.getMessage());
        }
        return centroDeVacunacion;
    }
}
