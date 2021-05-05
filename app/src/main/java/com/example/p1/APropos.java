package com.example.p1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class APropos extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_propos);

        Button btnApi1 = (Button) findViewById(R.id.btn_api_);

        btnApi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(APropos.this);

                String url = "http://10.0.10.130:8092/boutique/public/apiall";
/*                String cat = "http://10.0.10.130:8092/boutique/public/apiallcategorie";*/

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ListView lst;
                        lst = (ListView) findViewById(R.id.list_view_categorie);
                        //parcours des Produits retournées

                        ArrayList<String>lesProduits = new ArrayList<String>();
                        JSONArray jsonArray = null;
                        try {
                            jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject item = jsonArray.getJSONObject(i);
                                String libelle = item.getString("libelle");
                                String tarif = item.getString("tarif");
                                String stock = item.getString("stock");

                                lesProduits.add("compte: " + libelle);
                                lesProduits.add("tarif:" + tarif + "€");
                                lesProduits.add("stock:" + stock);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //Remplissage de la listview
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(APropos.this,android.R.layout.simple_list_item_1, lesProduits);
                        lst.setAdapter(arrayAdapter);

                        // Si on veut obtenir une action lorsque l'on clique sur un élément de la listview
                        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                TextView tv = (TextView) view;
                                Toast.makeText(APropos.this, tv.getText() + "" + position, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        TextView textApi1 = (TextView) findViewById(R.id.textInfoClient2);
                        textApi1.setText("Erreur," + error.getMessage());
                    }

                });

                queue.add(stringRequest);
            }
        });




        /*// On recupere le Bundle transmis
        Bundle bundleResultat = this.getIntent().getExtras();
        if(bundleResultat == null){

        } else {
            // il ne reste plus qu'à recuperer les donnees
            String resultat = "";
            resultat += bundleResultat.getString("Titre") + "///";
            resultat += bundleResultat.getString("message");
            System.out.println(resultat);

            TextView leTexte = (TextView) findViewById(R.id.textInfoClient);
            leTexte.setText(resultat);*/

        }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.apropos_button_retouraccueil){
            finish();

        }
    }
}