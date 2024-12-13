/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author cuent
 */
public class MedicionActividadFisicaAdapter implements MedicionAdapter{
    private ActividadFisicaAdap actividadFisica;

    public MedicionActividadFisicaAdapter(ActividadFisicaAdap actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    @Override
    public double obtenerMedicion() {
        return actividadFisica.obtenerKilometrosRecorridos();  // Adaptamos el método
    }
}

