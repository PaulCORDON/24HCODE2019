package com.ensim.a24h;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;

import com.ensim.a24h.Model.Scenario;

public class ScenarioChoicePatternActivity extends AppCompatActivity {

    private Button rainbow;
    private Button wipe;
    private Button branche;
    private Button colonne;
    private Button goutte;
    private Button ring;
    private Button fill;
    private SeekBar seekBarRouge;
    private SeekBar seekBarVert;
    private SeekBar seekBarBleu;
    private Button boutonexecuter;
    private EditText editText;
    private CheckBox boule1, boule2, boule3, boule4, boule5, boule6, boule7, boule8, boule9, boule10, boule11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario_choice_pattern);
        Scenario scenario = new Scenario();
        rainbow = findViewById(R.id.rainbow);
        wipe = findViewById(R.id.wipe);
        branche = findViewById(R.id.branche);
        colonne = findViewById(R.id.colonne);
        goutte = findViewById(R.id.goutte);
        ring = findViewById(R.id.edti);
        fill = findViewById(R.id.fill);
        editText =findViewById(R.id.editText);
        seekBarBleu = findViewById(R.id.seekBar4);
        seekBarVert =findViewById(R.id.seekBar3);
        seekBarRouge = findViewById(R.id.seekBar2);
        boutonexecuter = findViewById(R.id.executer);
        boule1 = (CheckBox) findViewById(R.id.checkBox);
        boule2 = (CheckBox) findViewById(R.id.checkBox10);
        boule3 = (CheckBox) findViewById(R.id.checkBox11);
        boule4 = (CheckBox) findViewById(R.id.checkBox12);
        boule5 = (CheckBox) findViewById(R.id.checkBox13);
        boule6 = (CheckBox) findViewById(R.id.checkBox14);
        boule7 = (CheckBox) findViewById(R.id.checkBox15);
        boule8 = (CheckBox) findViewById(R.id.checkBox16);
        boule9 = (CheckBox) findViewById(R.id.checkBox17);
        boule10 = (CheckBox) findViewById(R.id.checkBox18);
        boule11 = (CheckBox) findViewById(R.id.checkBox19);

        rainbow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScenarioChoicePatternActivity.this, ValueChoiceActivity.class);
                i.putExtra("type", "rainbow");
                startActivity(i);
            }
        });

        wipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScenarioChoicePatternActivity.this, ValueChoiceActivity.class);
                i.putExtra("type", "wipe");
                startActivity(i);
                finish();
            }
        });
        branche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScenarioChoicePatternActivity.this, ValueChoiceActivity.class);
                i.putExtra("type", "brancherotative");
                startActivity(i);
            }
        });
        colonne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScenarioChoicePatternActivity.this, ValueChoiceActivity.class);
                i.putExtra("type", "column");
                startActivity(i);
            }
        });
        goutte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScenarioChoicePatternActivity.this, ValueChoiceActivity.class);
                i.putExtra("type", "goutte");
                startActivity(i);
            }
        });
        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScenarioChoicePatternActivity.this, ValueChoiceActivity.class);
                i.putExtra("type", "ring");
                startActivity(i);
            }
        });
        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScenarioChoicePatternActivity.this, ValueChoiceActivity.class);
                i.putExtra("type", "fill");
                startActivity(i);
            }
        });



    }
}
