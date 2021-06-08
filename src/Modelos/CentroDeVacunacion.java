package Modelos;

/**
 *
 * @author Grupo2
 */
public class CentroDeVacunacion implements Comparable<CentroDeVacunacion>{

    private int idCentroDeVacunacion = -1;
    private String nombreCentroDeVacunacion;
    private String ciudad;
    private String departamento;

    public CentroDeVacunacion(int idCentroDeVacunacion, String nombreCentroDeVacunacion, String ciudad, String departamento) {
        this.idCentroDeVacunacion = idCentroDeVacunacion;
        this.nombreCentroDeVacunacion = nombreCentroDeVacunacion;
        this.ciudad = ciudad;
        this.departamento = departamento;
    }

    public CentroDeVacunacion(String nombreCentroDeVacunacion, String ciudad, String departamento) {
        this.nombreCentroDeVacunacion = nombreCentroDeVacunacion;
        this.ciudad = ciudad;
        this.departamento = departamento;
    }

    public CentroDeVacunacion() {
    }

    public int getIdCentroDeVacunacion() {
        return idCentroDeVacunacion;
    }

    public String getNombreCentroDeVacunacion() {
        return nombreCentroDeVacunacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setIdCentroDeVacunacion(int idCentroDeVacunacion) {
        this.idCentroDeVacunacion = idCentroDeVacunacion;
    }

    public void setNombreCentroDeVacunacion(String nombreCentroDeVacunacion) {
        this.nombreCentroDeVacunacion = nombreCentroDeVacunacion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "El centro de vacunación " + nombreCentroDeVacunacion + " se encuentra en: " + ciudad;
    }

    public boolean equals(Object obj) {
        final CentroDeVacunacion other = (CentroDeVacunacion) obj;
        return ((nombreCentroDeVacunacion.equalsIgnoreCase(other.nombreCentroDeVacunacion))
                && (ciudad.equalsIgnoreCase(other.ciudad))
                && (departamento.equalsIgnoreCase(other.departamento)));
    }
    
    @Override
    public int compareTo(CentroDeVacunacion centroDeVacunacion) {
        return (nombreCentroDeVacunacion.compareToIgnoreCase(centroDeVacunacion.nombreCentroDeVacunacion) 
                - (ciudad.compareToIgnoreCase(centroDeVacunacion.ciudad))
                - (departamento.compareToIgnoreCase(centroDeVacunacion.ciudad)));
    }
}
