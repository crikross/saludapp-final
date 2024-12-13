package modelo;
import java.sql.Timestamp;

public class ActividadFisica {
    
    private int actividadId;
    private int usuarioId;
    private int pasos;
    private float distancia;
    private float caloriasQuemadas;
    private Timestamp fechaRegistro;

    // Constructor
    public ActividadFisica(int actividadId, int usuarioId, int pasos, float distancia, float caloriasQuemadas, Timestamp fechaRegistro) {
        this.actividadId = actividadId;
        this.usuarioId = usuarioId;
        this.pasos = pasos;
        this.distancia = distancia;
        this.caloriasQuemadas = caloriasQuemadas;
        this.fechaRegistro = fechaRegistro;
    }
    // Constructor sin parámetros
    public ActividadFisica() {
    }
    // Getters y Setters
    public int getActividadId() {
        return actividadId;
    }

    public void setActividadId(int actividadId) {
        this.actividadId = actividadId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public float getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public void setCaloriasQuemadas(float caloriasQuemadas) {
        this.caloriasQuemadas = caloriasQuemadas;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
