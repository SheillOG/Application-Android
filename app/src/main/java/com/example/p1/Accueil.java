package com.example.p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Accueil extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);


        Button monbouton = (Button) findViewById(R.id.bouton_accueil);
        monbouton.setOnClickListener(this);

        this.findViewById(R.id.accueil_constraintL0).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CharSequence text = "Clic sur le bouton!";

        if(v.getId() == R.id.bouton_accueil){
            text = text + "... Bouton accueil";
        } else {
            text = text + "... activity";
        }
        Context context = v.getContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}