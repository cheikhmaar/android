package com.example.session;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AccueilActivity extends AppCompatActivity {

    TextView nomComplet_txt, email1_txt;
    Button logOut_btn;
    SharedPreferences sharedPreferences;

    private static final String shared_pref_name = "mypref";
    private static final String key_nom = "nom";
    private static final String key_email = "email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        nomComplet_txt = findViewById(R.id.nomComplet_txt);
        email1_txt = findViewById(R.id.email1_txt);
        logOut_btn = findViewById(R.id.logOut_btn);

        sharedPreferences = getSharedPreferences(shared_pref_name,MODE_PRIVATE);

        String nom = sharedPreferences.getString(key_nom,null);
        String email1 = sharedPreferences.getString(key_email,null);

        if (nom !=null || email1 !=null){
            nomComplet_txt.setText("Nom complet: " +nom);
            email1_txt.setText("Email ID: " +email1);
        }

        logOut_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(AccueilActivity.this,"Bye", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}