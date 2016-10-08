package mx.pepivsky.tareasemana1webservices.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.pepivsky.tareasemana1webservices.DetalleMascota;
import mx.pepivsky.tareasemana1webservices.R;
import mx.pepivsky.tareasemana1webservices.pojo.Mascota;


/**
 * Created by noisecontrollers on 07/08/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
//Método constructor
ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList <Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;


    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota,parent,false);
        return new MascotaViewHolder(v);
    }
//Asocia cada elmento de la lista con cada View
    @Override
    public void onBindViewHolder(final MascotaViewHolder MascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
       /* MascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
        MascotaViewHolder.tvNombre.setText(mascota.getNombre());*/
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.guacamayo)
                .into(MascotaViewHolder.imgMascota);
        MascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));

        MascotaViewHolder.imgMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(activity, mascota.getNombre(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity,DetalleMascota.class);
                intent.putExtra("url",mascota.getUrlFoto());
                intent.putExtra("like",mascota.getLikes());
                activity.startActivity(intent);
            }
        });


      /*  MascotaViewHolder.bntLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Diste Like a "+mascota.getNombre(),Toast.LENGTH_SHORT).show();

                constructorMascotas constructorMascota = new constructorMascotas(activity);
                constructorMascota.darLikeMascota(mascota);
                MascotaViewHolder.tvLikes.setText(constructorMascota.obtenerLikesMascota(mascota) + " " + activity.getString(R.string.likes));
            }
        });*/


    }

    @Override
    public int getItemCount() { //Cantidad de elemntos que contiene la lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        //private TextView tvNombre;
        //private ImageView bntLike;
        private TextView tvLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgMascota = (ImageView)itemView.findViewById(R.id.imgMascota);
            //tvNombre = (TextView)itemView.findViewById(R.id.tvNombre);
            //bntLike = (ImageView)itemView.findViewById(R.id.huesoLike);
            tvLikes = (TextView)itemView.findViewById(R.id.tvLikes);

        }
    }
}
