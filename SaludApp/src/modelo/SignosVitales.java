package modelo;

import java.sql.Timestamp;

public class SignosVitales {

    private int idSignosVitales;          
    private int usuarioId;                
    private int pulsaciones;             
    private int presionArterial;          
    private Timestamp fechaRegistro;      

    // Constructor con parámetros
    public SignosVitales(int idSignosVitales, int usuarioId, int pulsaciones, int presionArterial, Timestamp fechaRegistro) {
        this.idSignosVitales = idSignosVitales;
        this.usuarioId = usuarioId;
        this.pulsaciones = pulsaciones;
        this.presionArterial = presionArterial;
        this.fechaRegistro = fechaRegistro;
    }

    // Constructor sin parámetros
    public SignosVitales() {}

    // Getter y Setter para idSignosVitales
    public int getIdSignosVitales() {
        return idSignosVitales;
    }

    public void setIdSignosVitales(int idSignosVitales) {
        this.idSignosVitales = idSignosVitales;
    }

    // Getter y Setter para usuarioId
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    // Getter y Setter para pulsaciones
    public int getPulsaciones() {
        return pulsaciones;
    }

    public void setPulsaciones(int pulsaciones) {
        if (pulsaciones > 0) {  
            this.pulsaciones = pulsaciones;
        }
    }

    // Getter y Setter para presionArterial
    public int getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(int presionArterial) {
        if (presionArterial > 0) {  
            this.presionArterial = presionArterial;
        }
    }

    // Getter y Setter para fechaRegistro
    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    // Método toString() para visualización
    @Override
    public String toString() {
        return "SignosVitales{" +
                "idSignosVitales=" + idSignosVitales +
                ", usuarioId=" + usuarioId +
                ", pulsaciones=" + pulsaciones +
                ", presionArterial=" + presionArterial +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
