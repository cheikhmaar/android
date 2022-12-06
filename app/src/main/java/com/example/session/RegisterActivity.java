package com.example.session;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText nom_txt, email_txt;
    Button save_btn;
    SharedPreferences sharedPreferences;

    private static final String shared_pref_name = "mypref";
    private static final String key_nom = "nom";
    private static final String key_email = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nom_txt = findViewById(R.id.nom_txt);
        email_txt = findViewById(R.id.email_txt);
        save_btn = findViewById(R.id.save_btn);

        sharedPreferences = getSharedPreferences(shared_pref_name,MODE_PRIVATE);

        String nom = sharedPreferences.getString(key_nom,null);

        if (nom!=null){
            Intent intent = new Intent(RegisterActivity.this,AccueilActivity.class);
            startActivity(intent);
            finish();
        }

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(key_nom,nom_txt.getText().toString());
                editor.putString(key_email,email_txt.getText().toString());
                editor.apply();

                Intent intent = new Intent(RegisterActivity.this,AccueilActivity.class);
                startActivity(intent);

                Toast.makeText(RegisterActivity.this,"login success", Toast.LENGTH_LONG).show();


            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}