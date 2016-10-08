package mx.pepivsky.tareasemana1webservices.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.pepivsky.tareasemana1webservices.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
   /* private ArrayList<Mascota> mascotaperfil;
    private RecyclerView listaMascotasperfil;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotasperfil = (RecyclerView)v.findViewById(R.id.rvPerfil);
        GridLayoutManager llm =new GridLayoutManager(getContext(),3);
        listaMascotasperfil.setLayoutManager(llm);
        InicializarListaMascotas();
        inicializarAdpatador();
        return v;
    }

    public void InicializarListaMascotas(){ //Método que inicializa la  lista
        mascotaperfil = new ArrayList<Mascota>();
        //llenado de la lista

        mascotaperfil.add(new Mascota(R.drawable.guacamayo,"Juancho", 2));
        mascotaperfil.add(new Mascota(R.drawable.guacamayo_rojo,"Juancho", 5));
        mascotaperfil.add(new Mascota(R.drawable.guacamayo2,"Juancho", 2));

    }

    public void inicializarAdpatador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotaperfil,getActivity());
        listaMascotasperfil.setAdapter(adaptador);
    }*/
   public PerfilFragment() {
       // Required empty public constructor
   }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }
}
