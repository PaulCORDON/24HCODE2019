package com.ensim.a24h;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ensim.a24h.Model.Scenario;

public class ScenarioChoicePatternActivity extends AppCompatActivity {

    private Button rainbow;
    private Button wipe;
    private Button branche;
    private Button colonne;
    private Button goutte;
    private Button ring;
    private Button fill;

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
