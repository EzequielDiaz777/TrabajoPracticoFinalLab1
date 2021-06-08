package Modelos;

import java.time.LocalDate;

/**
 *
 * @author Grupo2
 */
public class Persona implements Comparable<Persona> {

    private int idPersona = -1;
    private Patologia patologia;
    private int dni;
    private String nombre;
    private String apellido;
    private String email;
    private double peso;
    private double altura;
    private boolean trabajo;
    private String celular;
    private LocalDate fechaDeNacimiento;
    private String ciudad;
    private String departamento;

    public Persona(int idPersona, Patologia patologia, int dni, String nombre, String apellido, double peso, double altura, String email, boolean trabajo, String celular, LocalDate fechaDeNacimiento, String ciudad, String departamento) {
        this.idPersona = idPersona;
        this.patologia = patologia;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
        this.altura = altura;
        this.email = email;
        this.trabajo = trabajo;
        this.celular = celular;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.ciudad = ciudad;
        this.departamento = departamento;
    }

    public Persona(Patologia patologia, int dni, String nombre, String apellido, double peso, double altura, String email, boolean trabajo, String celular, LocalDate fechaDeNacimiento, String ciudad, String departamento) {
        this.patologia = patologia;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
        this.altura = altura;
        this.email = email;
        this.trabajo = trabajo;
        this.celular = celular;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.ciudad = ciudad;
        this.departamento = departamento;
    }

    public Persona() {
    }

    public int getIdPersona() {
        return idPersona;
    }

    public Patologia getPatologia() {
        return patologia;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public String getEmail() {
        return email;
    }

    public boolean isTrabajo() {
        return trabajo;
    }

    public String getCelular() {
        return celular;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setPatologia(Patologia patologia) {
        this.patologia = patologia;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTrabajo(boolean trabajo) {
        this.trabajo = trabajo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "La persona se llama: " + nombre + " " + apellido;
    }

    @Override
    public boolean equals(Object obj) {
        final Persona other = (Persona) obj;
        if (patologia == null || other.patologia == null) {
            return ((dni == other.dni) && (nombre.equalsIgnoreCase(other.nombre))
                    && (apellido.equalsIgnoreCase(other.apellido)) && (email.equalsIgnoreCase(other.email)) && (peso == other.peso)
                    && (altura == other.altura) && (trabajo == other.trabajo) && (celular.equalsIgnoreCase(other.celular))
                    && (email.equalsIgnoreCase(other.email)) && (fechaDeNacimiento.equals(other.fechaDeNacimiento))
                    && (ciudad.equalsIgnoreCase(other.ciudad)) && (departamento.equalsIgnoreCase(other.departamento)));
        } else {
            return ((patologia.equals(other.patologia)) && (dni == other.dni) && (nombre.equalsIgnoreCase(other.nombre))
                    && (apellido.equalsIgnoreCase(other.apellido)) && (email.equalsIgnoreCase(other.email)) && (peso == other.peso)
                    && (altura == other.altura) && (trabajo == other.trabajo) && (celular.equalsIgnoreCase(other.celular))
                    && (email.equalsIgnoreCase(other.email)) && (fechaDeNacimiento.equals(other.fechaDeNacimiento))
                    && (ciudad.equalsIgnoreCase(other.ciudad)) && (departamento.equalsIgnoreCase(other.departamento)));
        }
    }

    @Override
    public int compareTo(Persona persona) {
        return dni - persona.dni;
    }
}
