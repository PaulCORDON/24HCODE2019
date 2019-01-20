package com.ensim.a24h;

import android.content.Intent;
import android.opengl.Visibility;
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
import com.ensim.a24h.Patern.PatternBrancheRotative;
import com.ensim.a24h.Patern.PatternColumn;
import com.ensim.a24h.Patern.PatternFill;
import com.ensim.a24h.Patern.PatternGoutte;
import com.ensim.a24h.Patern.PatternRainbow;
import com.ensim.a24h.Patern.PatternRing;
import com.ensim.a24h.Patern.PatternWipe;

import java.util.ArrayList;

public class ValueChoiceActivity extends AppCompatActivity {
    private String scenario;
    private EditText r;
    private EditText v;
    private EditText b;
    private EditText duree;
    private EditText nom;
    private EditText column;
    private EditText ring;
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
        ring = findViewById(R.id.ring);
        column = findViewById(R.id.column);
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

        scenario = getIntent().getStringExtra("type");
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
                if (scenario.equals("rainbow"))
                {
                    scene.add(new PatternRainbow(listeBouleCheckees));
                }
                if (scenario.equals("brancherotative"))
                {
                    PatternBrancheRotative pbranche = new PatternBrancheRotative(Integer.parseInt(r.getText().toString()), Integer.parseInt(v.getText().toString()), Integer.parseInt(b.getText().toString()), listeBouleCheckees);
                    scene.add(pbranche);
                }
                if (scenario.equals("fill"))
                {
                    PatternFill pfill = new PatternFill(listeBouleCheckees, Integer.parseInt(r.getText().toString()), Integer.parseInt(v.getText().toString()), Integer.parseInt(b.getText().toString()));
                    scene.add(pfill);
                }
                if (scenario.equals("goutte"))
                {
                    PatternGoutte pgoutte = new PatternGoutte(Integer.parseInt(r.getText().toString()), Integer.parseInt(v.getText().toString()), Integer.parseInt(b.getText().toString()));
                    scene.add(pgoutte);
                }
                if (scenario.equals("column"))
                {
                    PatternColumn pcol = new PatternColumn(listeBouleCheckees, Integer.parseInt(r.getText().toString()), Integer.parseInt(v.getText().toString()), Integer.parseInt(b.getText().toString()),Integer.parseInt(column.getText().toString()));
                    scene.add(pcol);
                }
                if (scenario.equals("ring"))
                {
                    PatternRing pring = new PatternRing(listeBouleCheckees, Integer.parseInt(r.getText().toString()), Integer.parseInt(v.getText().toString()), Integer.parseInt(b.getText().toString()),Integer.parseInt(ring.getText().toString()));
                    scene.add(pring);
                }

                i.putExtra("nom", nom.getText().toString());
                startActivity(i);
                finish();
            }
        });

        if (scenario.equals("wipe"))
        {
            ring.setVisibility(View.GONE);
            column.setVisibility(View.GONE);
            r.setVisibility(View.VISIBLE);
            v.setVisibility(View.VISIBLE);
            b.setVisibility(View.VISIBLE);
            duree.setVisibility(View.VISIBLE);
            boule1.setVisibility(View.VISIBLE);
            boule2.setVisibility(View.VISIBLE);
            boule3.setVisibility(View.VISIBLE);
            boule4.setVisibility(View.VISIBLE);
            boule5.setVisibility(View.VISIBLE);
            boule6.setVisibility(View.VISIBLE);
            boule7.setVisibility(View.VISIBLE);
            boule8.setVisibility(View.VISIBLE);
            boule9.setVisibility(View.VISIBLE);
        }

        if (scenario.equals("rainbow"))
        {

        }

        if (scenario.equals("fill"))
        {

        }

        if (scenario.equals("ring"))
        {

        }

        if (scenario.equals("column"))
        {

        }

        if (scenario.equals("brancherotative"))
        {

        }


    }
}

