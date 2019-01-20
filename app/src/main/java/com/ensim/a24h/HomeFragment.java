package com.ensim.a24h;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

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
    private CheckBox boule1, boule2, boule3, boule4, boule5, boule6, boule7, boule8, boule9;

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
        boutonRouge = (Button) view.findViewById(R.id.boutonRouge);
        boutonVert = (Button) view.findViewById(R.id.boutonVert);
        boutonBleu = (Button) view.findViewById(R.id.boutonBleu);
        boutonWipe = (Button) view.findViewById(R.id.boutonWipe);
        boutonRainbow = (Button) view.findViewById(R.id.boutonRainbow);
        boutonSerpent = (Button) view.findViewById(R.id.boutonSerpent);
        //boutonNeige = (Button) view.findViewById(R.id.boutonNeige);
        boule1 = (CheckBox) view.findViewById(R.id.checkBox);
        boule2 = (CheckBox) view.findViewById(R.id.checkBox10);
        boule3 = (CheckBox) view.findViewById(R.id.checkBox11);
        boule4 = (CheckBox) view.findViewById(R.id.checkBox12);
        boule5 = (CheckBox) view.findViewById(R.id.checkBox13);
        boule6 = (CheckBox) view.findViewById(R.id.checkBox14);
        boule7 = (CheckBox) view.findViewById(R.id.checkBox15);
        boule8 = (CheckBox) view.findViewById(R.id.checkBox16);
        boule9 = (CheckBox) view.findViewById(R.id.checkBox17);
        final ArrayList<String> listeBouleCheckees = new ArrayList<String>();


        boutonRouge.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for (String boule : listeBouleCheckees) {
                    mqttService.fill(boule, 255, 0, 0);
                }

            }
        });

        /*boutonRing.setOnClickListener(new View.OnClickListener() {
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
        });*/
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
        /*boutonNeige.setOnClickListener(new View.OnClickListener() {
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
        });*/

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

        return view;
    }
}