package Modelos;

/**
 *
 * @author Grupo2
 */
public class Laboratorio implements Comparable<Laboratorio> {

    private int idLaboratorio = -1;
    private String direccion;
    private String nombreComercial;
    private String paisDeOrigen;

    public Laboratorio(int idLaboratorio, String direccion, String nombreComercial, String paisDeOrigen) {
        this.idLaboratorio = idLaboratorio;
        this.direccion = direccion;
        this.nombreComercial = nombreComercial;
        this.paisDeOrigen = paisDeOrigen;
    }

    public Laboratorio(String direccion, String nombreComercial, String paisDeOrigen) {
        this.direccion = direccion;
        this.nombreComercial = nombreComercial;
        this.paisDeOrigen = paisDeOrigen;
    }

    public Laboratorio() {
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public String getPaisDeOrigen() {
        return paisDeOrigen;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public void setPaisDeOrigen(String paisDeOrigen) {
        this.paisDeOrigen = paisDeOrigen;
    }

    @Override
    public String toString() {
        return "Laboratorio " + nombreComercial;
    }

    @Override
    public boolean equals(Object obj) {
        final Laboratorio other = (Laboratorio) obj;
        return ((direccion.equalsIgnoreCase(other.direccion))
                && (nombreComercial.equalsIgnoreCase(other.nombreComercial))
                && (paisDeOrigen.equalsIgnoreCase(other.paisDeOrigen)));
    }

    @Override
    public int compareTo(Laboratorio laboratorio) {
        return ((nombreComercial.compareToIgnoreCase(laboratorio.nombreComercial))
                - (direccion.compareToIgnoreCase(laboratorio.direccion))
                - (paisDeOrigen.compareToIgnoreCase(laboratorio.paisDeOrigen)));
        //return nombreComercial.compareTo(laboratorio.nombreComercial) + direccion.compareTo(laboratorio.direccion) + paisDeOrigen.compareTo(laboratorio.paisDeOrigen);
    }
}
