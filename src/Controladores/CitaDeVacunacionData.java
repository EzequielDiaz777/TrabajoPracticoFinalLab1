package Controladores;

import Modelos.CitaDeVacunacion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo2
 */
public class CitaDeVacunacionData {

    private Connection connection;

    private void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public CitaDeVacunacionData() {
        try {
            connection = Conexion.getConexion();
        } catch (SQLException ex) {
            mensaje("Error al obtener la conexion en CitaDeVacunacionData. Error: " + ex.getMessage());
        } catch (ClassNotFoundException cnf) {
            mensaje("Error al cargar los drivers.");
        }
    }

    public void guardarCitaDeVacunacion(CitaDeVacunacion citaDeVacunacion) {
        ArrayList<CitaDeVacunacion> lista = obtenerCitasDeVacunaciones();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(citaDeVacunacion)) {
                mensaje("La cita para " + citaDeVacunacion.getPersona().getNombre() + " " + citaDeVacunacion.getPersona().getApellido() + ", quien sera vacunado con la dosis cuyo número de serie es " + citaDeVacunacion.getDosis().getNumDeSerie() + " en el centro de vacunacion: " + citaDeVacunacion.getCentroDeVacunacion().getNombreCentroDeVacunacion() + " programado para el dia " + citaDeVacunacion.getFecha() + " a la hora " + citaDeVacunacion.getHora() + " ya se encuentra guardada en la BD.");
                return;
            }
        }
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO citadevacunacion VALUES (NULL, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(citaDeVacunacion.getFecha()));
            ps.setTime(2, Time.valueOf(citaDeVacunacion.getHora()));
            ps.setBoolean(3, citaDeVacunacion.isEstadoDeCita());
            ps.setInt(4, citaDeVacunacion.getCentroDeVacunacion().getIdCentroDeVacunacion());
            ps.setInt(5, citaDeVacunacion.getPersona().getIdPersona());
            ps.setInt(6, citaDeVacunacion.getDosis().getIdDosis());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                citaDeVacunacion.setIdCitaDeVacunacion(rs.getInt(1));
                mensaje("La cita para " + citaDeVacunacion.getPersona().getNombre() + " " + citaDeVacunacion.getPersona().getApellido() + ", quien sera vacunado con la dosis cuyo número de serie es " + citaDeVacunacion.getDosis().getNumDeSerie() + " en el centro de vacunacion: " + citaDeVacunacion.getCentroDeVacunacion().getNombreCentroDeVacunacion() + " programado para el dia " + citaDeVacunacion.getFecha() + " a la hora " + citaDeVacunacion.getHora() + " ha sido guardada correctamente en la BD.");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("La cita para " + citaDeVacunacion.getPersona().getNombre() + " " + citaDeVacunacion.getPersona().getApellido() + ", quien sera vacunado con la dosis cuyo número de serie es " + citaDeVacunacion.getDosis().getNumDeSerie() + " en el centro de vacunacion: " + citaDeVacunacion.getCentroDeVacunacion().getNombreCentroDeVacunacion() + " programado para el dia " + citaDeVacunacion.getFecha() + " a la hora " + citaDeVacunacion.getHora() + " no ha podido ser guardada correctamente en la BD. Error: " + ex.getMessage());
        }
    }

    public ArrayList<CitaDeVacunacion> obtenerCitasDeVacunaciones() {
        ArrayList<CitaDeVacunacion> lista = new ArrayList<>();
        CitaDeVacunacion citaDeVacunacion;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM citadevacunacion");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                citaDeVacunacion = new CitaDeVacunacion();
                citaDeVacunacion.setIdCitaDeVacunacion(rs.getInt("idCitaDeVacunacion"));
                citaDeVacunacion.setFecha(LocalDate.parse(rs.getString("fecha")));
                citaDeVacunacion.setHora(LocalTime.parse(rs.getString("hora")));
                citaDeVacunacion.setEstadoDeCita(rs.getBoolean("estadoDeCita"));
                citaDeVacunacion.setCentroDeVacunacion(new CentroDeVacunacionData().buscarCentroDeVacunacion(rs.getInt("idCentroDeVacunacion")));
                citaDeVacunacion.setPersona(new PersonaData().buscarPersona(rs.getInt("idPersona")));
                citaDeVacunacion.setDosis(new DosisData().buscarDosis(rs.getInt("idDosis")));
                lista.add(citaDeVacunacion);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("Error al obtener la lista de las citas de vacunacion en la BD: " + ex.getMessage());
        }
        Collections.sort(lista);
        return lista;
    }

    public void borrarCentroDeVacunacion(int idCitaDeVacunacion) {
        CitaDeVacunacion cdv = buscarCentroDeVacunacion(idCitaDeVacunacion);
        if (cdv == null) {
            System.out.println("La cita de vacunacion no ha podido ser borrada porque no existe en la BD.");
        } else {
            try {
                PreparedStatement ps = connection.prepareStatement("DELETE FROM citadevacunacion WHERE idCitaDeVacunacion = ?", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, idCitaDeVacunacion);
                if ((ps.executeUpdate() == 1)) {
                    mensaje("La cita para " + cdv.getPersona().getNombre() + " " + cdv.getPersona().getApellido() + ", quien sera vacunado con la dosis cuyo número de serie es " + cdv.getDosis().getNumDeSerie() + " en el centro de vacunacion: " + cdv.getCentroDeVacunacion().getNombreCentroDeVacunacion() + " programado para el dia " + cdv.getFecha() + " a la hora " + cdv.getHora() + " ha sido borrada correctamente en la BD.");
                }
                ps.close();
            } catch (SQLException ex) {
                mensaje("La cita para " + cdv.getPersona().getNombre() + " " + cdv.getPersona().getApellido() + ", quien sera vacunado con la dosis cuyo número de serie es " + cdv.getDosis().getNumDeSerie() + " en el centro de vacunacion: " + cdv.getCentroDeVacunacion().getNombreCentroDeVacunacion() + " programado para el dia " + cdv.getFecha() + " a la hora " + cdv.getHora() + " no ha podido ser borrada correctamente en la BD. Error: " + ex.getMessage());
            }
        }
    }

    public void actualizarCitaDeVacunacion(CitaDeVacunacion citaDeVacunacion) {
        ArrayList<CitaDeVacunacion> lista = obtenerCitasDeVacunaciones();
        CitaDeVacunacion cdv = citaDeVacunacion;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(cdv)) {
                mensaje("La cita para " + citaDeVacunacion.getPersona().getNombre() + " " + citaDeVacunacion.getPersona().getApellido() + ", quien sera vacunado con la dosis cuyo número de serie es " + citaDeVacunacion.getDosis().getNumDeSerie() + " en el centro de vacunacion: " + citaDeVacunacion.getCentroDeVacunacion().getNombreCentroDeVacunacion() + " programado para el dia " + citaDeVacunacion.getFecha() + " a la hora " + citaDeVacunacion.getHora() + " no ha podido ser actualizada porque no hay cambios que reflejar en la BD.");
                return;
            }
        }
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE citadevacunacion SET fecha = ?, hora = ?, estadoDeCita= ?, idCentroDeVacunacion = ?, idPersona = ?, idDosis = ? WHERE idCitaDeVacunacion= ?", Statement.RETURN_GENERATED_KEYS);
                ps.setDate(1, Date.valueOf(citaDeVacunacion.getFecha()));
                ps.setTime(2, Time.valueOf(citaDeVacunacion.getHora()));
                ps.setBoolean(3, citaDeVacunacion.isEstadoDeCita());
                ps.setInt(4, citaDeVacunacion.getCentroDeVacunacion().getIdCentroDeVacunacion());
                ps.setInt(5, citaDeVacunacion.getPersona().getIdPersona());
                ps.setInt(6, citaDeVacunacion.getDosis().getIdDosis());
                ps.setInt(7, citaDeVacunacion.getIdCitaDeVacunacion());
                if (ps.executeUpdate() == 1) {
                    mensaje("La cita para " + citaDeVacunacion.getPersona().getNombre() + " " + citaDeVacunacion.getPersona().getApellido() + ", quien sera vacunado con la dosis cuyo número de serie es " + citaDeVacunacion.getDosis().getNumDeSerie() + " en el centro de vacunacion: " + citaDeVacunacion.getCentroDeVacunacion().getNombreCentroDeVacunacion() + " programado para el dia " + citaDeVacunacion.getFecha() + " a la hora " + citaDeVacunacion.getHora() + " ha sido actualizada correctamente en la BD.");
                }
                ps.close();
            } catch (SQLException ex) {
                mensaje("La cita para " + citaDeVacunacion.getPersona().getNombre() + " " + citaDeVacunacion.getPersona().getApellido() + ", quien sera vacunado con la dosis cuyo número de serie es " + citaDeVacunacion.getDosis().getNumDeSerie() + " en el centro de vacunacion: " + citaDeVacunacion.getCentroDeVacunacion().getNombreCentroDeVacunacion() + " programado para el dia " + citaDeVacunacion.getFecha() + " a la hora " + citaDeVacunacion.getHora() + " no ha sido actualizada correctamente en la BD. Error: " + ex.getMessage());
            }
    }

    public CitaDeVacunacion buscarCentroDeVacunacion(int idCitaDeVacunacion) {
        CitaDeVacunacion citaDeVacunacion = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM citadevacunacion WHERE idCitaDeVacunacion = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idCitaDeVacunacion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                citaDeVacunacion = new CitaDeVacunacion();
                citaDeVacunacion.setIdCitaDeVacunacion(rs.getInt("idCitaDeVacunacion"));
                citaDeVacunacion.setFecha(LocalDate.parse(rs.getString("fecha")));
                citaDeVacunacion.setHora(LocalTime.parse(rs.getString("hora")));
                citaDeVacunacion.setEstadoDeCita(rs.getBoolean("estadoDeCita"));
                citaDeVacunacion.setCentroDeVacunacion(new CentroDeVacunacionData().buscarCentroDeVacunacion(rs.getInt("idCentroDeVacunacion")));
                citaDeVacunacion.setPersona(new PersonaData().buscarPersona(rs.getInt("idPersona")));
                citaDeVacunacion.setDosis(new DosisData().buscarDosis(rs.getInt("idDosis")));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("La cita de vacunación no existe en la BD. Error: " + ex.getMessage());
        }
        return citaDeVacunacion;
    }
}
