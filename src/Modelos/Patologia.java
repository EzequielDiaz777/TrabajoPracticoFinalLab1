package Modelos;

/**
 *
 * @author Grupo2
 */
public class Patologia implements Comparable<Patologia> {

    private int idPatologia = -1;
    private String nombrePatologia;

    public Patologia(int idPatologia, String nombrePatologia) {
        this.idPatologia = idPatologia;
        this.nombrePatologia = nombrePatologia;
    }

    public Patologia(String nombrePatologia) {
        this.nombrePatologia = nombrePatologia;
    }

    public Patologia() {
    }

    public int getIdPatologia() {
        return idPatologia;
    }

    public String getNombrePatologia() {
        return nombrePatologia;
    }

    public void setIdPatologia(int idPatologia) {
        this.idPatologia = idPatologia;
    }

    public void setNombrePatologia(String nombrePatologia) {
        this.nombrePatologia = nombrePatologia;
    }

    @Override
    public String toString() {
        return nombrePatologia;

    }

    @Override
    public boolean equals(Object obj) {
        final Patologia other = (Patologia) obj;
        return nombrePatologia.equalsIgnoreCase(other.nombrePatologia);
    }

    
    @Override
    public int compareTo(Patologia patologia) {
        return nombrePatologia.compareToIgnoreCase(patologia.nombrePatologia);
    }
}