package mx.pepivsky.tareasemana1webservices.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.pepivsky.tareasemana1webservices.Adapter.MascotaAdaptador;
import mx.pepivsky.tareasemana1webservices.R;
import mx.pepivsky.tareasemana1webservices.pojo.Mascota;
import mx.pepivsky.tareasemana1webservices.presentador.IRecyclerViewFragmentPresenter;
import mx.pepivsky.tareasemana1webservices.presentador.RecyclerViewFragmentPresenter;

/**
 * Created by noisecontrollers on 24/08/2016.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{
   //private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());

        return v;
    }
/*
    public void InicializarListaMascotas(){ //Método que inicializa la  lista
        mascotas = new ArrayList<Mascota>();
        //llenado de la lista

        mascotas.add(new Mascota(R.drawable.aves_exoticas_del_amazonas_y_del_mundo,"Juancho", likes));
        mascotas.add(new Mascota(R.drawable.perro_carlino_485x300,"Firulais", likes));
        mascotas.add(new Mascota(R.drawable.descarga,"Manchas", likes));
        mascotas.add(new Mascota(R.drawable.oveja,"Dolly", likes));
        mascotas.add(new Mascota(R.drawable.images,"Ernestin", likes));

    }*/



    @Override
    public void generarLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        listaMascotas.setLayoutManager(gridLayoutManager);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);

    }
}
