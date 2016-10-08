package mx.pepivsky.tareasemana1webservices;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import mx.pepivsky.tareasemana1webservices.mail.SendMail;

public class mcontacto extends AppCompatActivity implements View.OnClickListener{
    TextInputEditText nombreContacto;
    TextInputEditText correoContacto;
    TextInputEditText mensajeContacto;
    Button botton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcontacto);

        nombreContacto= (TextInputEditText) findViewById(R.id.nameContacto);
        correoContacto= (TextInputEditText) findViewById(R.id.correoContacto);
        mensajeContacto= (TextInputEditText) findViewById(R.id.mensajeContacto);


        botton = (Button) findViewById(R.id.buttonMail);
        botton.setOnClickListener(this);


    }

    private void sendEmail() {

        Toast.makeText(getBaseContext(), " Tu : " + nombreContacto.getText()  + " con mail : " + correoContacto.getText()
                        + " Enviaste el mensaje: " + mensajeContacto.getText()
                , Toast.LENGTH_LONG).show();
        //Creating SendMail object
        SendMail sm = new SendMail(this, correoContacto.getText().toString().trim(),
                nombreContacto.getText().toString().trim(), mensajeContacto.getText().toString().trim());


        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }
}

