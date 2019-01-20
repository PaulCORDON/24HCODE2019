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
import com.ensim.a24h.Patern.PatternRainbow;
import com.ensim.a24h.Patern.PatternWipe;
import com.ensim.a24h.Patern.PatternFill;
import com.ensim.a24h.Patern.PatternGoutte;
import com.ensim.a24h.Patern.PatternRing;

import java.util.ArrayList;

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
        final Scenario scenario = new Scenario();
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
                scenario.add(new PatternRainbow(/*todo liste boules*/));
            }
        });

        wipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(editText.getText())){
                    scenario.add(new PatternWipe(/*todo liste boules*/,seekBarRouge.getProgress(),seekBarVert.getProgress(),seekBarBleu.getProgress(),3000));
                }
                else{
                    scenario.add(new PatternWipe(/*todo liste boules*/,seekBarRouge.getProgress(),seekBarVert.getProgress(),seekBarBleu.getProgress(),editText.getText()));
                }

            }
        });
        branche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scenario.add(new PatternWipe(seekBarRouge.getProgress(),seekBarVert.getProgress(),seekBarBleu.getProgress(),/*todo liste boules*/));
            }
        });
        colonne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int col;
                if("".equals(editText.getText()))
                {
                    col=1;
                }
                else{
                    col = Integer.parseInt(editText.getText().toString());
                }
                scenario.add(new PatternRing(l,seekBarRouge.getProgress(),seekBarVert.getProgress(),seekBarBleu.getProgress(),col));
            }
        });
        goutte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scenario.add(new PatternGoutte(seekBarRouge.getProgress(),seekBarVert.getProgress(),seekBarBleu.getProgress()));
            }
        });
        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int anneau;
                if("".equals(editText.getText()))
                {
                    anneau=1;
                }
                else{
                    anneau = Integer.parseInt(editText.getText().toString());
                }
                scenario.add(new PatternRing(l,seekBarRouge.getProgress(),seekBarVert.getProgress(),seekBarBleu.getProgress(),anneau));
            }
        });
        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scenario.add(new PatternFill(l,seekBarRouge.getProgress(),seekBarVert.getProgress(),seekBarBleu.getProgress()));
            }
        });



    }
}
