package mx.pepivsky.tareasemana1webservices.Fragment;

import java.util.ArrayList;

import mx.pepivsky.tareasemana1webservices.Adapter.MascotaAdaptador;
import mx.pepivsky.tareasemana1webservices.pojo.Mascota;

/**
 * Created by noisecontrollers on 11/09/2016.
 */
public interface IRecyclerViewFragmentView {

    public void generarLayoutVertical();

    public void generarGridLayout();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
