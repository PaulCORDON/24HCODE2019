package com.ensim.a24h;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;

import com.ensim.a24h.Model.Scenario;
import com.ensim.a24h.Patern.PatternBrancheRotative;
import com.ensim.a24h.Patern.PatternColumn;
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
        editText = findViewById(R.id.editText);
        seekBarBleu = findViewById(R.id.seekBar4);
        seekBarVert = findViewById(R.id.seekBar3);
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
        final ArrayList<String> listeBouleCheckees = new ArrayList<String>();
        rainbow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scenario.add(new PatternRainbow(listeBouleCheckees));
            }
        });

        boutonexecuter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scenario.execute();
                scenario.removeAll(scenario);
            }
        });

        wipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(editText.getText().toString())) {
                    scenario.add(new PatternWipe(listeBouleCheckees, seekBarRouge.getProgress(), seekBarVert.getProgress(), seekBarBleu.getProgress(), 3000));
                } else {
                    scenario.add(new PatternWipe(listeBouleCheckees, seekBarRouge.getProgress(), seekBarVert.getProgress(), seekBarBleu.getProgress(), Integer.parseInt(editText.getText().toString())));
                }

            }
        });
        branche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scenario.add(new PatternBrancheRotative(seekBarRouge.getProgress(), seekBarVert.getProgress(), seekBarBleu.getProgress(), listeBouleCheckees));
            }
        });
        colonne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int col;
                if ("".equals(editText.getText().toString())) {
                    col = 1;
                } else {
                    col = Integer.parseInt(editText.getText().toString());
                }
                scenario.add(new PatternColumn(listeBouleCheckees, seekBarRouge.getProgress(), seekBarVert.getProgress(), seekBarBleu.getProgress(), col));
            }
        });
        goutte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scenario.add(new PatternGoutte(seekBarRouge.getProgress(), seekBarVert.getProgress(), seekBarBleu.getProgress()));
            }
        });
        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int anneau;
                if ("".equals(editText.getText().toString())) {
                    anneau = 1;
                } else {
                    anneau = Integer.parseInt(editText.getText().toString());
                }
                scenario.add(new PatternRing(listeBouleCheckees, seekBarRouge.getProgress(), seekBarVert.getProgress(), seekBarBleu.getProgress(), anneau));
            }
        });
        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scenario.add(new PatternFill(listeBouleCheckees, seekBarRouge.getProgress(), seekBarVert.getProgress(), seekBarBleu.getProgress()));
            }
        });

        boule1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (boule1.isChecked()) {
                    listeBouleCheckees.add("Laumio_1D9486");
                }
                if (!boule1.isChecked()) {
                    listeBouleCheckees.remove("Laumio_1D9486");
                }

            }
        });
        boule2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (boule2.isChecked()) {
                    listeBouleCheckees.add("Laumio_104A13");
                }
                if (!boule2.isChecked()) {
                    listeBouleCheckees.remove("Laumio_104A13");
                }

            }
        });


        boule3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (boule3.isChecked()) {
                    listeBouleCheckees.add("Laumio_104F03");
                }
                if (!boule3.isChecked()) {
                    listeBouleCheckees.remove("Laumio_104F03");
                }

            }
        });
        boule4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (boule4.isChecked()) {
                    listeBouleCheckees.add("Laumio_10508F");
                }
                if (!boule4.isChecked()) {
                    listeBouleCheckees.remove("Laumio_10508F");
                }

            }
        });
        boule5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (boule5.isChecked()) {
                    listeBouleCheckees.add("Laumio_0FBFBF");
                }
                if (!boule5.isChecked()) {
                    listeBouleCheckees.remove("Laumio_0FBFBF");
                }

            }
        });
        boule6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (boule6.isChecked()) {
                    listeBouleCheckees.add("Laumio_10805F");
                }
                if (!boule6.isChecked()) {
                    listeBouleCheckees.remove("Laumio_10805F");
                }

            }
        });
        boule7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (boule7.isChecked()) {
                    listeBouleCheckees.add("Laumio_CD0522");
                }
                if (!boule7.isChecked()) {
                    listeBouleCheckees.remove("Laumio_CD0522");
                }

            }
        });
        boule8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (boule8.isChecked()) {
                    listeBouleCheckees.add("Laumio_0FC168");
                }
                if (!boule8.isChecked()) {
                    listeBouleCheckees.remove("Laumio_0FC168");
                }

            }
        });
        boule9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (boule9.isChecked()) {
                    listeBouleCheckees.add("Laumio_D454DB");
                }
                if (!boule9.isChecked()) {
                    listeBouleCheckees.remove("Laumio_D454DB");
                }

            }
        });

        boule10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (boule10.isChecked()) {
                    listeBouleCheckees.add("Laumio_107DA8");
                }
                if (!boule10.isChecked()) {
                    listeBouleCheckees.remove("Laumio_107DA8");
                }

            }
        });

        boule11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (boule11.isChecked()) {
                    listeBouleCheckees.add("Laumio_88813D");
                }
                if (!boule11.isChecked()) {
                    listeBouleCheckees.remove("Laumio_88813D");
                }

            }
        });


    }
}
