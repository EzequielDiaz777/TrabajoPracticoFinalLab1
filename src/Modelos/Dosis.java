package Modelos;

/**
 *
 * @author Grupo2
 */
public class Dosis implements Comparable<Dosis> {

    private int idDosis = -1;
    private boolean estado;
    private int numDeSerie;
    private Laboratorio laboratorio;

    public Dosis(int idDosis, boolean estado, int numDeSerie, Laboratorio laboratorio) {
        this.idDosis = idDosis;
        this.estado = estado;
        this.numDeSerie = numDeSerie;
        this.laboratorio = laboratorio;
    }

    public Dosis(boolean estado, int numDeSerie, Laboratorio laboratorio) {
        this.estado = estado;
        this.numDeSerie = numDeSerie;
        this.laboratorio = laboratorio;
    }

    public Dosis() {
    }

    public int getIdDosis() {
        return idDosis;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getNumDeSerie() {
        return numDeSerie;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setIdDosis(int idDosis) {
        this.idDosis = idDosis;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setNumDeSerie(int numDeSerie) {
        this.numDeSerie = numDeSerie;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    @Override
    public String toString() {
        return "El número de serie de la dosis es: " + numDeSerie;
    }

    @Override
    public boolean equals(Object obj) {
        final Dosis other = (Dosis) obj;
        return ((estado == other.estado)
                && (numDeSerie == other.numDeSerie)
                && (laboratorio.equals(other.laboratorio)));
    }

    @Override
    public int compareTo(Dosis dosis) {
        return numDeSerie - dosis.numDeSerie;
    }
}
