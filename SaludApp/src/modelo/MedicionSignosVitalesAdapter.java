/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author cuent
 */
public class MedicionSignosVitalesAdapter implements MedicionAdapter{
    private SignosVitales signosVitales;

    public MedicionSignosVitalesAdapter(SignosVitales signosVitales) {
        this.signosVitales = signosVitales;
    }

    @Override
    public double obtenerMedicion() {
        return signosVitales.getPresionArterial();  // Adaptamos el método
    }
    
}
