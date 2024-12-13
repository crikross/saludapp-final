package modelo;
import java.sql.Timestamp;


public class Diagnostico {
    private int diagnosticoId;
    private int usuarioId;
    private String categoria;
    private String detalle;
    private float valor;
    private String recomendacion;
    private String estado;
    private Timestamp fechaRegistro;

    // Constructor
    public Diagnostico(int diagnosticoId, int usuarioId, String categoria, String detalle, float valor,
                       String recomendacion, String estado, Timestamp fechaRegistro) {
        this.diagnosticoId = diagnosticoId;
        this.usuarioId = usuarioId;
        this.categoria = categoria;
        this.detalle = detalle;
        this.valor = valor;
        this.recomendacion = recomendacion;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters
    public int getDiagnosticoId() {
        return diagnosticoId;
    }

    public void setDiagnosticoId(int diagnosticoId) {
        this.diagnosticoId = diagnosticoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
   
}
