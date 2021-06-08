package Modelos;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Grupo2
 */
public class CitaDeVacunacion implements Comparable<CitaDeVacunacion> {

    private int idCitaDeVacunacion = -1;
    private LocalDate fecha;
    private LocalTime hora;
    private boolean estadoDeCita;
    private CentroDeVacunacion centroDeVacunacion;
    private Persona persona;
    private Dosis dosis;

    public CitaDeVacunacion(int idCitaDeVacunacion, LocalDate fecha, LocalTime hora, boolean estadoDeCita, CentroDeVacunacion centroDeVacunacion, Persona persona, Dosis dosis) {
        this.idCitaDeVacunacion = idCitaDeVacunacion;
        this.fecha = fecha;
        this.hora = hora;
        this.estadoDeCita = estadoDeCita;
        this.centroDeVacunacion = centroDeVacunacion;
        this.persona = persona;
        this.dosis = dosis;
    }

    public CitaDeVacunacion(LocalDate fecha, LocalTime hora, boolean estadoDeCita, CentroDeVacunacion centroDeVacunacion, Persona persona, Dosis dosis) {
        this.fecha = fecha;
        this.hora = hora;
        this.estadoDeCita = estadoDeCita;
        this.centroDeVacunacion = centroDeVacunacion;
        this.persona = persona;
        this.dosis = dosis;
    }

    public CitaDeVacunacion() {
    }

    public int getIdCitaDeVacunacion() {
        return idCitaDeVacunacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public boolean isEstadoDeCita() {
        return estadoDeCita;
    }

    public CentroDeVacunacion getCentroDeVacunacion() {
        return centroDeVacunacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public Dosis getDosis() {
        return dosis;
    }

    public void setIdCitaDeVacunacion(int idCitaDeVacunacion) {
        this.idCitaDeVacunacion = idCitaDeVacunacion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setEstadoDeCita(boolean estadoDeCita) {
        this.estadoDeCita = estadoDeCita;
    }

    public void setCentroDeVacunacion(CentroDeVacunacion centroDeVacunacion) {
        this.centroDeVacunacion = centroDeVacunacion;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setDosis(Dosis dosis) {
        this.dosis = dosis;
    }

    @Override
    public String toString() {
        return persona.getNombre() + " " + persona.getApellido() + ", quien sera vacunado con la dosis numero " + dosis.getNumDeSerie() + " en el centro de vacunacion " + centroDeVacunacion.getNombreCentroDeVacunacion() + " programado para el dia: " + fecha + " a la hora: " + hora;
    }

    @Override
    public boolean equals(Object obj) {
        final CitaDeVacunacion other = (CitaDeVacunacion) obj;
        return ((fecha.isEqual(other.fecha))
                && (hora.equals(other.hora))
                && (estadoDeCita == other.estadoDeCita)
                && (centroDeVacunacion.equals(other.centroDeVacunacion))
                && (persona.equals(other.persona))
                && (dosis.equals(other.dosis)));
    }

    @Override
    public int compareTo(CitaDeVacunacion citaDeVacunacion) {
        return ((fecha.compareTo(citaDeVacunacion.fecha))
                - (hora.compareTo(citaDeVacunacion.hora))
                - (centroDeVacunacion.compareTo(citaDeVacunacion.centroDeVacunacion))
                - (persona.compareTo(citaDeVacunacion.persona))
                - (dosis.compareTo(citaDeVacunacion.dosis)));
    }
}
