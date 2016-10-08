package mx.pepivsky.tareasemana1webservices.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import mx.pepivsky.tareasemana1webservices.Fragment.IRecyclerViewFragmentView;
import mx.pepivsky.tareasemana1webservices.db.constructorMascotas;
import mx.pepivsky.tareasemana1webservices.pojo.Mascota;
import mx.pepivsky.tareasemana1webservices.restApi.EndpointsApi;
import mx.pepivsky.tareasemana1webservices.restApi.adapter.RestApiAdapter;
import mx.pepivsky.tareasemana1webservices.restApi.model.MascotaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by noisecontrollers on 11/09/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {



    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private constructorMascotas constructorMascota;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascota = new constructorMascotas(context);
        mascotas = constructorMascota.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> contactoResponseCall = endpointsApi.getRecentMedia();

        contactoResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });



    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarGridLayout();
    }


}

