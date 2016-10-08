package mx.pepivsky.tareasemana1webservices.restApi.adapter;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mx.pepivsky.tareasemana1webservices.restApi.ConstantesRestApi;
import mx.pepivsky.tareasemana1webservices.restApi.EndpointsApi;
import mx.pepivsky.tareasemana1webservices.restApi.deserializador.MascotaDeserializador;
import mx.pepivsky.tareasemana1webservices.restApi.model.MascotaResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anahisalgado on 25/05/16.
 */
public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());
        return gsonBuilder.create();
    }
}
