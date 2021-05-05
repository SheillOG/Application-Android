package com.example.p1;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AditionActivity extends AppCompatActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adition);

        Button monbouton = (Button) findViewById(R.id.boutton_additioner);
        monbouton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.boutton_additioner){
            EditText nb1 = this.findViewById(R.id.addition_nb1);
            int nb = Integer.parseInt(String.valueOf(nb1.getText()));
            EditText nb2 = this.findViewById(R.id.addition_nb2);
            int nbb = Integer.parseInt(String.valueOf(nb2.getText()));
            int result = nb + nbb;
            TextView addition_resultat = this.findViewById(R.id.addition_resultat);
            addition_resultat.setText(String.valueOf(result));
        }
    }


//    public void onClick(View v) {
//        if(v.getId() == R.id.boutton_additioner){
//            EditText nb1 = this.findViewById(R.id.addition_nb1);
//            int nb = Integer.parseInt(String.valueOf(nb1));
//            EditText nb2 = this.findViewById(R.id.addition_nb2);
//            int nbb = Integer.parseInt(String.valueOf(nb2));
//            TextView addition_resultat = this.findViewById(R.id.addition_resultat);
//            int result = nb + nbb;
//            addition_resultat.setText(String.valueOf(result));
//        }
//    }


}
