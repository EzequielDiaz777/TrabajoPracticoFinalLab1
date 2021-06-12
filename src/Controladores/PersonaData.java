package Controladores;

import Modelos.Persona;
import java.sql.Connection;
import java.sql.Date;
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
public class PersonaData {

    private Connection connection;

    private void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public PersonaData() {
        try {
            connection = Conexion.getConexion();
        } catch (SQLException ex) {
            mensaje("Error al obtener la conexion en PersonaData. Error: " + ex.getMessage());
        } catch (ClassNotFoundException cnf) {
            mensaje("Error al cargar los drivers.");
        }
    }

    public void guardarPersona(Persona persona) {
        ArrayList<Persona> lista = obtenerPersonas();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(persona)) {
                mensaje(persona.getNombre() + " " + persona.getApellido() + " ya se encuentra guardada en la BD.");
                return;
            }
        }
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO persona VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            if (persona.getPatologia() != null) {
                ps.setInt(1, persona.getPatologia().getIdPatologia());
            } else {
                ps.setNull(1, java.sql.Types.NULL);
            }
            ps.setInt(2, persona.getDni());
            ps.setString(3, persona.getNombre());
            ps.setString(4, persona.getApellido());
            ps.setDouble(5, persona.getPeso());
            ps.setDouble(6, persona.getAltura());
            ps.setString(7, persona.getEmail());
            ps.setBoolean(8, persona.isTrabajo());
            ps.setString(9, persona.getCelular());
            ps.setDate(10, Date.valueOf(persona.getFechaDeNacimiento()));
            ps.setString(11, persona.getCiudad());
            ps.setString(12, persona.getDepartamento());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                persona.setIdPersona(rs.getInt(1));
                mensaje(persona.getNombre() + " " + persona.getApellido() + " ha sido guardada correctamente en la BD.");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje(persona.getNombre() + " " + persona.getApellido() + " no ha podido ser guardada correctamente en la BD. Error: " + ex.getMessage());
        }
    }

    public ArrayList<Persona> obtenerPersonas() {
        ArrayList<Persona> lista = new ArrayList<>();
        Persona persona;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM persona");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                persona = new Persona();
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setPatologia(new PatologiaData().buscarPatologia(rs.getInt("idPatologia")));
                persona.setDni(rs.getInt("dni"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setPeso(rs.getDouble("peso"));
                persona.setAltura(rs.getDouble("altura"));
                persona.setEmail(rs.getString("email"));
                persona.setTrabajo(rs.getBoolean("trabajo"));
                persona.setCelular(rs.getString("celular"));
                persona.setFechaDeNacimiento(rs.getDate("fechaDeNacimiento").toLocalDate());
                persona.setCiudad(rs.getString("ciudad"));
                persona.setDepartamento(rs.getString("departamento"));
                lista.add(persona);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("Error al obtener la lista de las personas de la BD: " + ex.getMessage());
        }
        Collections.sort(lista);
        return lista;
    }

    public void borrarPersona(int idPersona) {
        Persona p = buscarPersona(idPersona);
        if (p == null) {
            System.out.println("La persona no ha podido ser borrada porque no existe en la BD.");
        } else {
            try {
                PreparedStatement ps = connection.prepareStatement("DELETE FROM persona WHERE idPersona = ?", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, idPersona);
                if ((ps.executeUpdate() == 1)) {
                    mensaje(p.getNombre() + " " + p.getApellido() + " ha sido borrada correctamente en la BD.");
                }
                ps.close();
            } catch (SQLException ex) {
                mensaje(p.getNombre() + " " + p.getApellido() + " no ha podido ser borrada correctamente en la BD. Error: " + ex.getMessage());
            }
        }
    }

    public void actualizarPersona(Persona persona) {
        ArrayList<Persona> lista = obtenerPersonas();
        Persona p = persona;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(p)) {
                mensaje(persona.getNombre() + " " + persona.getApellido() + " no ha podido ser actualizada porque no hay cambios que reflejar en la BD.");
                return;
            }
        }
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE persona SET idPatologia = ?, dni = ?, nombre = ?, apellido = ?, peso = ?, altura = ?, email = ?, trabajo = ?, celular = ?, fechaDeNacimiento = ?, ciudad = ?, departamento = ? WHERE idPersona = ?", Statement.RETURN_GENERATED_KEYS);
            if (persona.getPatologia() != null) {
                ps.setInt(1, persona.getPatologia().getIdPatologia());
            } else {
                ps.setNull(1, java.sql.Types.NULL);
            }
            ps.setInt(2, persona.getDni());
            ps.setString(3, persona.getNombre());
            ps.setString(4, persona.getApellido());
            ps.setDouble(5, persona.getPeso());
            ps.setDouble(6, persona.getAltura());
            ps.setString(7, persona.getEmail());
            ps.setBoolean(8, persona.isTrabajo());
            ps.setString(9, persona.getCelular());
            ps.setDate(10, Date.valueOf(persona.getFechaDeNacimiento()));
            ps.setString(11, persona.getCiudad());
            ps.setString(12, persona.getDepartamento());
            ps.setInt(13, persona.getIdPersona());
            if (ps.executeUpdate() == 1) {
                mensaje(persona.getNombre() + " " + persona.getApellido() + " ha sido actualizada correctamente en la BD.");
            }
            ps.close();
        } catch (SQLException ex) {
            mensaje(persona.getNombre() + " " + persona.getApellido() + " no ha podido ser actualizada correctamente en la BD. Error: " + ex.getMessage());
        }
    }

    public Persona buscarPersona(int idPersona) {
        Persona persona = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM persona WHERE idPersona = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idPersona);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                persona = new Persona();
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setPatologia(new PatologiaData().buscarPatologia(rs.getInt("idPatologia")));
                persona.setDni(rs.getInt("dni"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setPeso(rs.getDouble("peso"));
                persona.setAltura(rs.getDouble("altura"));
                persona.setEmail(rs.getString("email"));
                persona.setTrabajo(rs.getBoolean("trabajo"));
                persona.setCelular(rs.getString("celular"));
                persona.setFechaDeNacimiento(rs.getDate("fechaDeNacimiento").toLocalDate());
                persona.setCiudad(rs.getString("ciudad"));
                persona.setDepartamento(rs.getString("departamento"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            mensaje("La persona no existe en la BD. Error: " + ex.getMessage());
        }
        return persona;
    }
}
