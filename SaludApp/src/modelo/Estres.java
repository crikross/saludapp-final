package modelo;
import java.sql.Timestamp;

public class Estres {
    
    private int estresId;
    private int usuarioId;
    private int nivelEstres;
    private String motivo;
    private Timestamp fechaRegistro;

    // Constructor
    public Estres(int estresId, int usuarioId, int nivelEstres, String motivo, Timestamp fechaRegistro) {
        this.estresId = estresId;
        this.usuarioId = usuarioId;
        this.nivelEstres = nivelEstres;
        this.motivo = motivo;
        this.fechaRegistro = fechaRegistro;
    }
    
     // Constructor sin parámetros
    public Estres() {
    }
    // Getters y Setters
    public int getEstresId() {
        return estresId;
    }

    public void setEstresId(int estresId) {
        this.estresId = estresId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getNivelEstres() {
        return nivelEstres;
    }

    public void setNivelEstres(int nivelEstres) {
        this.nivelEstres = nivelEstres;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
