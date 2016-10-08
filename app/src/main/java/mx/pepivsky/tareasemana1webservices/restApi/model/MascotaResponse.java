package mx.pepivsky.tareasemana1webservices.restApi.model;



import java.util.ArrayList;

import mx.pepivsky.tareasemana1webservices.pojo.Mascota;

/**
 * Created by anahisalgado on 25/05/16.
 */
public class MascotaResponse {

    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
