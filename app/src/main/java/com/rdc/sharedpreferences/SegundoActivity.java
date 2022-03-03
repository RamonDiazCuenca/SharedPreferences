package com.rdc.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class SegundoActivity extends AppCompatActivity {

    private TextView tvBienvenido;
    private Button btncerrarSesion;
    private ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);


        String user = getIntent().getStringExtra("user");

        tvBienvenido = findViewById(R.id.tvbienvenidoVip);
        btncerrarSesion = findViewById(R.id.btncerrarsesion);
        container = findViewById(R.id.container);

        tvBienvenido.setText("Bienvenido " + user);

        container.setBackgroundColor(ContextCompat.getColor(this, R.color.vip));

        btncerrarSesion.setOnClickListener(view -> {

           /* SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();//borrar datos archivo o bd

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);*/

        });
    }
}