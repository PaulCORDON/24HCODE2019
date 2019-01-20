package com.ensim.a24h;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.ensim.a24h.Model.Scenario;
import com.ensim.a24h.Patern.PatternRainbow;
import com.ensim.a24h.Patern.PatternWipe;

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
