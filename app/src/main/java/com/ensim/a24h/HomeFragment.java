package com.ensim.a24h;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ensim.a24h.Model.Scenario;
import com.ensim.a24h.Patern.PatternBrancheRotative;
import com.ensim.a24h.Patern.PatternFill;
import com.ensim.a24h.Patern.PatternGoutte;
import com.ensim.a24h.Patern.PatternNeige;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

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
    private Button play;
    private Button pause;
    private Button stop;
    private Button previous;
    private Button next;
    private Button boutonTemperature;
    private Button boutonPression;
    private Button boutonHumidite;
    private Button boutonDistance;
    private Button personnaliser;
    private Button boutonBleublancrouge;
    private Button boutonRandom;
    private SeekBar seekBarRouge;
    private SeekBar seekBarVert;
    private SeekBar seekBarBleu;
    private SeekBar volumeControl;
    private TextView temperature;
    private TextView humidite;
    private TextView pression;
    private TextView distance;

    private Button boutonChenille;//bouton pour faire une chenille avec toutes les boules sélectionnées
    private CheckBox boule1, boule2, boule3, boule4, boule5, boule6, boule7, boule8, boule9, boule10, boule11;

    public HomeFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_home_fragment, container, false);
        final MqttServices mqttService = new MqttServices();
        final MPDServices musicPlayer = new MPDServices();
        boutonRouge = (Button) view.findViewById(R.id.boutonRouge);
        boutonVert = (Button) view.findViewById(R.id.boutonVert);
        boutonBleu = (Button) view.findViewById(R.id.boutonBleu);
        boutonWipe = (Button) view.findViewById(R.id.boutonWipe);
        boutonRainbow = (Button) view.findViewById(R.id.boutonRainbow);
        boutonSerpent = (Button) view.findViewById(R.id.boutonSerpent);
        boutonNeige = (Button) view.findViewById(R.id.boutonNeige);
        seekBarBleu = (SeekBar) view.findViewById(R.id.seekBar4);
        seekBarVert = (SeekBar) view.findViewById(R.id.seekBar3);
        seekBarRouge = (SeekBar) view.findViewById(R.id.seekBar2);
        boutonChenille = (Button) view.findViewById(R.id.boutonChenille);
        boutonRing = (Button) view.findViewById(R.id.boutonRing);
        boutonColumn = (Button) view.findViewById(R.id.boutonColumn);
        boutonTemperature = (Button) view.findViewById(R.id.boutonTemperature);
        boutonPression = (Button) view.findViewById(R.id.boutonPresion);
        boutonHumidite = (Button) view.findViewById(R.id.boutonHumidite);
        boutonDistance = (Button) view.findViewById(R.id.boutonDistance);
        boutonBleublancrouge=(Button)view.findViewById(R.id.boutonScenar2);
        boutonRandom=(Button)view.findViewById(R.id.boutonScenar1);
        boule1 = (CheckBox) view.findViewById(R.id.checkBox);
        boule2 = (CheckBox) view.findViewById(R.id.checkBox10);
        boule3 = (CheckBox) view.findViewById(R.id.checkBox11);
        boule4 = (CheckBox) view.findViewById(R.id.checkBox12);
        boule5 = (CheckBox) view.findViewById(R.id.checkBox13);
        boule6 = (CheckBox) view.findViewById(R.id.checkBox14);
        boule7 = (CheckBox) view.findViewById(R.id.checkBox15);
        boule8 = (CheckBox) view.findViewById(R.id.checkBox16);
        boule9 = (CheckBox) view.findViewById(R.id.checkBox17);
        boule10 = (CheckBox) view.findViewById(R.id.checkBox18);
        boule11 = (CheckBox) view.findViewById(R.id.checkBox19);
        play = (Button) view.findViewById(R.id.play);
        stop = (Button) view.findViewById(R.id.stop);
        pause = (Button) view.findViewById(R.id.pause);
        previous = (Button) view.findViewById(R.id.previous);
        next = (Button) view.findViewById(R.id.next);
        personnaliser = (Button) view.findViewById(R.id.personnaliser);
        temperature = (TextView) view.findViewById(R.id.temperature);
        humidite = (TextView) view.findViewById(R.id.humidite);
        pression = (TextView) view.findViewById(R.id.pression);
        distance = (TextView) view.findViewById(R.id.distance);

        PatternGoutte goutteBleu = new PatternGoutte(0,0,255);
        PatternGoutte goutteBlanc = new PatternGoutte(255,255,255);
        PatternGoutte goutteRouge = new PatternGoutte(255,0,0);
        final Scenario bleuBlancRouge = new Scenario();
        bleuBlancRouge.add(goutteBleu);
        bleuBlancRouge.add(goutteBlanc);
        bleuBlancRouge.add(goutteRouge);

        ArrayList<String> l = new ArrayList<String>();
        l.add("Laumio_1D9486");
        l.add("Laumio_104F03");
        l.add("Laumio_10805F");
        PatternFill pfill = new PatternFill(l,255,255,0);
        PatternBrancheRotative pbranche = new PatternBrancheRotative(0,255,255,l);
        PatternNeige pneige = new PatternNeige(l);
        final Scenario random = new Scenario();
        random.add(pfill);
        random.add(pbranche);
        random.add(pneige);


        final ArrayList<String> listeBouleCheckees = new ArrayList<String>();

        boutonDistance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // disable bouton
                //while 30 sec ou obtenu valeur
                mqttService.subscribe_distance_value();
                String value = "";
                while ("".equals(value)) {
                    value = mqttService.currentDistanceValue;
                }
                Log.d("R", "coucou !!!" + value);
                distance.setText(value);
            }
        });

        boutonTemperature.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mqttService.subscribe_atmosphere_temperature();
                String value = "";
                while ("".equals(value)) {
                    value = mqttService.currentTempValue;
                }
                Log.d("R", "coucou !!!" + value);
                temperature.setText(value);
            }
        });

        boutonHumidite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // disable bouton
                //while 30 sec ou obtenu valeur
                mqttService.subscribe_atmosphere_humidite();
                String value = "";
                while ("".equals(value)) {
                    value = mqttService.currentHumiditeValue;
                }
                Log.d("R", "coucou !!!" + value);
                humidite.setText(value);
            }
        });
        boutonPression.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mqttService.subscribe_atmosphere_pression();
                String value = "";
                while ("".equals(value)) {
                    value = mqttService.currentPressionValue;
                }
                Log.d("R", "coucou !!!" + value);
                pression.setText(value);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                musicPlayer.play();
            }
        });

        personnaliser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Log.d("R", "coucou" + Integer.toString(seekBarRouge.getProgress()));
                Log.d("V", "coucou" + Integer.toString(seekBarVert.getProgress()));
                Log.d("B", "coucou" + Integer.toString(seekBarBleu.getProgress()));

                int r = seekBarRouge.getProgress();
                int g = seekBarVert.getProgress();
                int b = seekBarBleu.getProgress();
                for (String boule : listeBouleCheckees) {
                    mqttService.fill(boule, r, g, b);
                }
                r = (r << 16) & 0x00FF0000;
                g = (g << 8) & 0x0000FF00;
                b = b & 0x000000FF;
                int rgb = 0xFF000000 | r | g | b;
                Log.d("B", "coucou rgb" + rgb);
                personnaliser.setBackgroundColor(rgb);


            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                musicPlayer.stop();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                musicPlayer.pause();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                musicPlayer.previousMusic();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                musicPlayer.nextMusic();
            }
        });

        boutonRouge.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for (String boule : listeBouleCheckees) {
                    mqttService.fill(boule, 255, 0, 0);
                }

            }
        });

        boutonRing.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for (String boule : listeBouleCheckees) {
                    //bleu blanc rouge vive la france et vive la république
                    mqttService.set_ring(boule, 2, 0, 0, 255);
                    mqttService.set_ring(boule, 1, 255, 255, 255);
                    mqttService.set_ring(boule, 0, 255, 0, 0);
                }

            }
        });
        boutonColumn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for (String boule : listeBouleCheckees) {
                    //bleu blanc rouge vive la france et vive la république
                    mqttService.set_column(boule, 2, 0, 0, 255);
                    mqttService.set_column(boule, 1, 255, 255, 255);
                    mqttService.set_column(boule, 1, 255, 0, 0);
                }

            }
        });
        //pour faire un serpent avec les boules entieres
        boutonChenille.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int bouleAEteindre = 0;
                int cpteur = 0;
                for (String boule : listeBouleCheckees) {
                    mqttService.fill(boule, 0, 255, 0);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (cpteur > 2) {
                        mqttService.fill(listeBouleCheckees.get(bouleAEteindre), 0, 0, 0);
                        bouleAEteindre++;

                    }
                    cpteur++;
                }

                mqttService.fill(listeBouleCheckees.get(bouleAEteindre), 0, 0, 0);
                bouleAEteindre++;
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mqttService.fill(listeBouleCheckees.get(bouleAEteindre), 0, 0, 0);
                bouleAEteindre++;
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mqttService.fill(listeBouleCheckees.get(bouleAEteindre), 0, 0, 0);
                bouleAEteindre++;


            }
        });
        boutonVert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for (String boule : listeBouleCheckees) {
                    mqttService.fill(boule, 0, 255, 0);
                }

            }
        });
        boutonBleu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for (String boule : listeBouleCheckees) {
                    mqttService.fill(boule, 0, 0, 255);
                }

            }
        });

        boutonWipe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for (String boule : listeBouleCheckees) {
                    mqttService.color_wipe(boule, 255, 0, 0, 3000);
                }

            }
        });
        boutonRainbow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for (String boule : listeBouleCheckees) {
                    mqttService.animate_rainbow(boule);
                }

            }
        });
        boutonBleublancrouge.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bleuBlancRouge.execute();

            }
        });
        boutonRandom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                random.execute();

            }
        });
        boutonSerpent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for (String boule : listeBouleCheckees) {
                    mqttService.set_pixel(boule, 0, 255, 0, 0);
                    mqttService.set_pixel(boule, 1, 255, 23, 0);
                    mqttService.set_pixel(boule, 2, 255, 46, 0);
                    mqttService.set_pixel(boule, 9, 255, 69, 0);
                    mqttService.set_pixel(boule, 3, 255, 92, 0);
                    mqttService.set_pixel(boule, 4, 255, 115, 0);
                    mqttService.set_pixel(boule, 5, 255, 138, 0);
                    mqttService.set_pixel(boule, 6, 255, 161, 0);
                    mqttService.set_pixel(boule, 7, 255, 184, 0);
                    mqttService.set_pixel(boule, 8, 255, 207, 0);
                    mqttService.set_pixel(boule, 9, 255, 230, 0);
                    mqttService.set_pixel(boule, 10, 255, 240, 0);
                    mqttService.set_pixel(boule, 11, 255, 255, 0);
                    mqttService.set_pixel(boule, 12, 255, 255, 0);

                    mqttService.set_pixel(boule, 0, 0, 0, 0);
                    mqttService.set_pixel(boule, 1, 0, 0, 0);
                    mqttService.set_pixel(boule, 2, 0, 0, 0);
                    mqttService.set_pixel(boule, 3, 0, 0, 0);
                    mqttService.set_pixel(boule, 4, 0, 0, 0);
                    mqttService.set_pixel(boule, 5, 0, 0, 0);
                    mqttService.set_pixel(boule, 6, 0, 0, 0);
                    mqttService.set_pixel(boule, 7, 0, 0, 0);
                    mqttService.set_pixel(boule, 8, 0, 0, 0);
                    mqttService.set_pixel(boule, 9, 0, 0, 0);
                    mqttService.set_pixel(boule, 10, 0, 0, 0);
                    mqttService.set_pixel(boule, 11, 0, 0, 0);
                    mqttService.set_pixel(boule, 12, 0, 0, 0);
                }

            }
        });
        boutonNeige.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                for (String boule : listeBouleCheckees) {
                    mqttService.set_pixel(boule, 9, 0, 97, 255);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (String boule : listeBouleCheckees) {
                    mqttService.set_ring(boule, 2, 89, 152, 255);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (String boule : listeBouleCheckees) {
                    mqttService.set_ring(boule, 1, 178, 207, 255);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (String boule : listeBouleCheckees) {
                    mqttService.set_ring(boule, 0, 255, 255, 255);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (String boule : listeBouleCheckees) {
                    mqttService.set_pixel(boule, 9, 0, 0, 0);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (String boule : listeBouleCheckees) {
                    mqttService.set_ring(boule, 2, 0, 0, 0);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (String boule : listeBouleCheckees) {
                    mqttService.set_ring(boule, 1, 0, 0, 0);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (String boule : listeBouleCheckees) {
                    mqttService.set_ring(boule, 0, 0, 0, 0);
                }


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
                    mqttService.fill("Laumio_1D9486", 0, 0, 0);
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
                    mqttService.fill("Laumio_104A13", 0, 0, 0);
                }

            }
        });

       /* volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // When Progress value changed.
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                musicPlayer.setVol(progressValue);
            }

            // Notification that the user has started a touch gesture.
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i("", "Started tracking seekbar");
            }

            // Notification that the user has finished a touch gesture
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("", "Stopped tracking seekbar");
            }
        });*/

        boule3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (boule3.isChecked()) {
                    listeBouleCheckees.add("Laumio_104F03");
                }
                if (!boule3.isChecked()) {
                    listeBouleCheckees.remove("Laumio_104F03");
                    mqttService.fill("Laumio_104F03", 0, 0, 0);
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
                    mqttService.fill("Laumio_10508F", 0, 0, 0);
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
                    mqttService.fill("Laumio_0FBFBF", 0, 0, 0);
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
                    mqttService.fill("Laumio_10805F", 0, 0, 0);
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
                    mqttService.fill("Laumio_CD0522", 0, 0, 0);
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
                    mqttService.fill("Laumio_0FC168", 0, 0, 0);
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
                    mqttService.fill("Laumio_D454DB", 0, 0, 0);
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
                    mqttService.fill("Laumio_107DA8", 0, 0, 0);
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
                    mqttService.fill("Laumio_88813D", 0, 0, 0);
                }

            }
        });


        return view;
    }
}