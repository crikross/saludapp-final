package modelo;

import java.sql.Timestamp;

public class Medicion {

    private int medicionId; 
    private int usuarioId;
    private int pulsaciones;
    private int pasos;
    private int nivelEstres;
    private Timestamp fechaRegistro;

    // Constructor para crear una nueva medición
    public Medicion(int usuarioId, int pulsaciones, int pasos, int nivelEstres) {
        this.usuarioId = usuarioId;
        this.pulsaciones = pulsaciones;
        this.pasos = pasos;
        this.nivelEstres = nivelEstres;
        this.fechaRegistro = new Timestamp(System.currentTimeMillis()); // Asignamos la fecha actual
    }

    public Medicion() {
       
    }

    // Getters y Setters
    public int getMedicionId() {
        return medicionId;
    }

    public void setMedicionId(int medicionId) {
        this.medicionId = medicionId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getPulsaciones() {
        return pulsaciones;
    }

    public void setPulsaciones(int pulsaciones) {
        this.pulsaciones = pulsaciones;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public int getNivelEstres() {
        return nivelEstres;
    }

    public void setNivelEstres(int nivelEstres) {
        this.nivelEstres = nivelEstres;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
