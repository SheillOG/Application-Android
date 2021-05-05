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

public class User  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Button btnApi1 = (Button) findViewById(R.id.afficher_user);


        btnApi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(User.this);

                String url = "http://10.0.10.130:8092/boutique/public/apialluser";
                /*                String cat = "http://10.0.10.130:8092/boutique/public/apiallcategorie";*/

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                ListView lst;
                                lst = (ListView) findViewById(R.id.list_view_user);
                                //parcours des Produits retournées

                                ArrayList<String> lesProduits = new ArrayList<String>();
                                JSONArray jsonArray = null;
                                try {
                                    jsonArray = new JSONArray(response);
                                    for (int i = 0; i < jsonArray.length(); i++){
                                        JSONObject item = jsonArray.getJSONObject(i);
                                        String email = item.getString("email");

                                        lesProduits.add("email: " + email);
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                //Remplissage de la listview
                                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(User.this,android.R.layout.simple_list_item_1, lesProduits);
                                lst.setAdapter(arrayAdapter);

                                // Si on veut obtenir une action lorsque l'on clique sur un élément de la listview
                                lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        TextView tv = (TextView) view;
                                        Toast.makeText(User.this, tv.getText() + "" + position, Toast.LENGTH_LONG).show();
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
    }

/*    public void onClick(View v) {
        if (v.getId() == R.id.button_retour_accueil) {
            finish();
        }*/


    }


//}
