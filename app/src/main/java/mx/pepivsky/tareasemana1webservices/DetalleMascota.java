package mx.pepivsky.tareasemana1webservices;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.pepivsky.tareasemana1webservices.Adapter.MascotaAdaptador;

public class DetalleMascota extends AppCompatActivity {
ImageView imgRaiting;
    ArrayList mascotas;
    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKES = "like";
    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota_foto);
        Toolbar miActionBar= (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        imgRaiting=((ImageView)findViewById(R.id.imgRaiting));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        String url   = extras.getString(KEY_EXTRA_URL);
        int likes    = extras.getInt(KEY_EXTRA_LIKES);

        tvLikesDetalle   = (TextView) findViewById(R.id.tvLikesDetalle);
        tvLikesDetalle.setText(String.valueOf(likes));

        imgFotoDetalle = (ImageView) findViewById(R.id.imgFotoDetalle);
        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.guacamayo)
                .into(imgFotoDetalle);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rvRanking);



        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        recyclerView.setAdapter(adaptador);


    }

    }
        /*mascotas = new ArrayList<Mascota>();
        //llenado de la lista

        mascotas.add(new Mascota(R.drawable.aves_exoticas_del_amazonas_y_del_mundo,"Juancho", 7));
        mascotas.add(new Mascota(R.drawable.perro_carlino_485x300,"Firulais",5));
        mascotas.add(new Mascota(R.drawable.descarga,"Manchas", 2));
        mascotas.add(new Mascota(R.drawable.oveja,"Dolly", 6));
        mascotas.add(new Mascota(R.drawable.images,"Ernestin", 1));*/






