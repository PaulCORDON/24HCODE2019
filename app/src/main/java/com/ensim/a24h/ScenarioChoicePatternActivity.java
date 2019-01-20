package com.ensim.a24h;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.ensim.a24h.Model.Scenario;

public class ScenarioChoicePatternActivity extends AppCompatActivity {

    private Button rainbow;
    private Button wipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario_choice_pattern);
        Scenario scenario = new Scenario();
        rainbow = findViewById(R.id.rainbow);
        wipe = findViewById(R.id.wipe);

        rainbow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScenarioChoicePatternActivity.this, ValueChoiceActivity.class);
                i.putExtra("scenario", "rainbow");
                startActivity(i);
            }
        });

        wipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScenarioChoicePatternActivity.this, ValueChoiceActivity.class);
                i.putExtra("scenario", "wipe");
                startActivity(i);
                finish();
            }
        });



    }
}
