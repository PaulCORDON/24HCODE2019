package com.ensim.a24h;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.ensim.a24h.Model.Scenario;
import com.ensim.a24h.Patern.PatternWipe;

import java.util.ArrayList;

public class ValueChoiceActivity extends AppCompatActivity {
    private String scenario;
    private EditText r;
    private EditText v;
    private EditText b;
    private EditText duree;
    private EditText nom;
    private Button ok;
    private TextView mTextMessage;
    private Button boutonRouge;
    private Button boutonVert;
    private Button boutonBleu;
    private Button boutonWipe;
    private Button boutonRainbow;
    private Button boutonSerpent;
    private Button boutonNeige;
    private Button boutonRing;
    private Button boutonColumn;
    private SeekBar seekBarRouge;
    private SeekBar seekBarVert;
    private SeekBar seekBarBleu;
    private Button boutonChenille;//bouton pour faire une chenille avec toutes les boules sélectionnées
    private CheckBox boule1, boule2, boule3, boule4, boule5, boule6, boule7, boule8, boule9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_choice);
        r = findViewById(R.id.wipeEditRouge);
        v = findViewById(R.id.wipeEditVert);
        b = findViewById(R.id.wipeEditBleu);
        nom = findViewById(R.id.nom);
        duree = findViewById(R.id.duree);
        ok = findViewById(R.id.ok);
        boutonRouge = (Button) findViewById(R.id.boutonRouge);
        boutonVert = (Button) findViewById(R.id.boutonVert);
        boutonBleu = (Button) findViewById(R.id.boutonBleu);
        boutonWipe = (Button) findViewById(R.id.boutonWipe);
        boutonRainbow = (Button) findViewById(R.id.boutonRainbow);
        boutonSerpent = (Button) findViewById(R.id.boutonSerpent);
        boutonNeige = (Button) findViewById(R.id.boutonNeige);
        seekBarBleu = (SeekBar) findViewById(R.id.seekBar4);
        seekBarVert = (SeekBar) findViewById(R.id.seekBar3);
        seekBarRouge = (SeekBar) findViewById(R.id.seekBar2);
        boule1 = (CheckBox) findViewById(R.id.checkBox);
        boule2 = (CheckBox) findViewById(R.id.checkBox10);
        boule3 = (CheckBox) findViewById(R.id.checkBox11);
        boule4 = (CheckBox) findViewById(R.id.checkBox12);
        boule5 = (CheckBox) findViewById(R.id.checkBox13);
        boule6 = (CheckBox) findViewById(R.id.checkBox14);
        boule7 = (CheckBox) findViewById(R.id.checkBox15);
        boule8 = (CheckBox) findViewById(R.id.checkBox16);
        boule9 = (CheckBox) findViewById(R.id.checkBox17);
        final ArrayList<String> listeBouleCheckees = new ArrayList<String>();

        r.setText("5");
        v.setText("5");
        b.setText("5");
        duree.setText("5");

        scenario = getIntent().getStringExtra("scenario");
        Log.d("Recupération", scenario);
        final Scenario scene = new Scenario();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ValueChoiceActivity.this, MainActivity.class);
                if (scenario.equals("wipe"))
                {
                    PatternWipe pwipe = new PatternWipe(listeBouleCheckees, Integer.parseInt(r.getText().toString()), Integer.parseInt(v.getText().toString()), Integer.parseInt(b.getText().toString()), Integer.parseInt(duree.getText().toString()));
                    scene.add(pwipe);
                }
                i.putExtra("nom", nom.getText().toString());
                startActivity(i);
                finish();
            }
        });

        if (scenario.equals("wipe"))
        {

        }


    }
}

