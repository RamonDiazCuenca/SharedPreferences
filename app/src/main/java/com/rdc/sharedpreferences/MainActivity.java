package com.rdc.sharedpreferences;

import static com.rdc.sharedpreferences.R.color.black;
import static com.rdc.sharedpreferences.R.color.purple_500;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etuser, etpass;
    private CheckBox cbvip;
    private Button btnsave, btnshow;
    private TextView tvshowdata;
    private ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarViews();
        comprobarVip();


        btnsave.setOnClickListener(view -> {

                // Creamos el fichero xml preferencias ('una base de datos'), nombre del archivo y nivel de visualización
                SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

                // Leer la información de los campos de texto
                String user = etuser.getText().toString();
                String pass = etpass.getText().toString();

                //Asignamos al archivo los datos que introducimos, editandolo
                SharedPreferences.Editor editor = preferences.edit();
                //Estructura del archivo, clave-valor
                editor.putString("usuario",user);
                editor.putString("password",pass);
                editor.putBoolean("vip", cbvip.isChecked());

                Toast.makeText(this, "Usuario guardado", Toast.LENGTH_SHORT).show();

                editor.apply();

                etuser.setText("");
                etpass.setText("");


        });
    }

    private void comprobarVip() {

        //Abrir el archivo, para identificarlo y permite abrirlo para trabajar con el
        SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        //En mi bd devuelveme el valor que tenga esta llave ej:("usuario"), y si nunca has guardado que te devuelvo, poner un valor por defecto, en este caso es lo indicado en el segundo parámetro
        String user = preferences.getString("usuario","No hay información");
        String pass = preferences.getString("password","No hay información");
        Boolean vip = preferences.getBoolean("vip", false);

        tvshowdata.setText("Usuario: " + user + " Password: " + pass + "Vip: " + vip);

        if (vip){

            Intent intent = new Intent(this, SegundoActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);

        }

    }

    private void cargarViews() {

        etuser = findViewById(R.id.etuser);
        etpass = findViewById(R.id.etpass);
        cbvip = findViewById(R.id.cbvip);
        btnsave = findViewById(R.id.btnguardar);
        btnshow = findViewById(R.id.btnmostrar);
        tvshowdata = findViewById(R.id.tvdatosguardados);
        container = findViewById(R.id.container);
    }
}