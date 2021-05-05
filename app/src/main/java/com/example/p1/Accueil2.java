package com.example.p1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Accueil2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil2);

        ListView listView = (ListView)findViewById(R.id.list_view_categorie);

        UserAccount tom = new UserAccount("Spotify","5€");
        UserAccount jerry = new UserAccount("Netflix","2.5€");
        UserAccount donald = new UserAccount("Deezer","7€", false);

        UserAccount[] users = new UserAccount[]{tom,jerry, donald};


        // android.R.layout.simple_list_item_1 is a constant predefined layout of Android.
        // used to create a ListView with simple ListItem (Only one TextView).

        ArrayAdapter<UserAccount> arrayAdapter
                = new ArrayAdapter<UserAccount>(this, android.R.layout.simple_list_item_1 , users);

/*        listView.setAdapter(arrayAdapter);*/




    }


    @Override
    public void onClick(View v) {
        Intent iAPropos = new Intent(this, APropos.class);
        Intent iCategorie = new Intent(this, Categorie.class);
        Intent iUser = new Intent(this, User.class);
        Bundle monBundle = new Bundle();
        switch (v.getId()) {
            case (R.id.accueil_boutton_apropos):
                // affiche l'activité a propos
                startActivity(iAPropos);
                break;

            case (R.id.btn_api_):
                monBundle.putString("titre", "titre du message");
                monBundle.putString("message", "ceci est un message");
                iAPropos.putExtras(monBundle);
                startActivity(iAPropos);
                break;

            case (R.id.accueil_boutton_categorie):
                startActivity(iCategorie);
                break;

            case (R.id.accueil_boutton_user):
                startActivity(iUser);
                break;
            default:
        }
    }

    @Override
    protected void onActivityResult(int requestedCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestedCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK){

            int duration = Toast.LENGTH_SHORT;
            Toast toast;

            if(data == null){
                toast = Toast.makeText(Accueil2.this, "Les données recu ne sont pas exploitable", duration);
            } else {
                String message = data.getExtras().getString("message") + data.getExtras().getString("message2");
                toast = Toast.makeText(Accueil2.this, message, duration);
            }
            toast.show();
        }
    }


        }

