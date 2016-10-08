package mx.pepivsky.tareasemana1webservices.pojo;

/**
 * Created by noisecontrollers on 07/08/2016.
 */
public class Mascota {


    private String id;
    private String nombreCompleto;
    private String urlFoto;
    private int likes = 0;



    public Mascota(String urlFoto, String nombreCompleto, String telefono, String email, int likes) {
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.likes = likes;
    }

    public Mascota() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
