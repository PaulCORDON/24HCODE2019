package com.ensim.a24h;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button boutonRouge;
    private Button boutonVert;
    private Button boutonBleu;
    private Button boutonWipe;
    private CheckBox boule1,boule2,boule3,boule4,boule5,boule6,boule7,boule8,boule9;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MqttServices mqttService = new MqttServices();
        boutonRouge = (Button)findViewById(R.id.boutonRouge);
        boutonVert = (Button)findViewById(R.id.boutonVert);
        boutonBleu = (Button)findViewById(R.id.boutonBleu);
        boutonWipe = (Button)findViewById(R.id.boutonWipe);
        boule1 = (CheckBox)findViewById(R.id.checkBox);
        boule2 = (CheckBox)findViewById(R.id.checkBox10);
        boule3 = (CheckBox)findViewById(R.id.checkBox11);
        boule4 = (CheckBox)findViewById(R.id.checkBox12);
        boule5 = (CheckBox)findViewById(R.id.checkBox13);
        boule6 = (CheckBox)findViewById(R.id.checkBox14);
        boule7 = (CheckBox)findViewById(R.id.checkBox15);
        boule8 = (CheckBox)findViewById(R.id.checkBox16);
        boule9 = (CheckBox)findViewById(R.id.checkBox17);
        final ArrayList<String> listeBouleCheckees = new ArrayList<String>();




        boutonRouge.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mqttService.set_pixel("Laumio_0FBFBF",9,255,0,0);
            }
        });
        boutonVert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mqttService.set_pixel("Laumio_107DA8",9,0,255,0);
            }
        });
        boutonBleu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mqttService.set_pixel("Laumio_107DA8",9,0,0,255);
            }
        });
        boutonLed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
        boutonWipe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               mqttService.color_wipe("Laumio_88813D",255,0,0,3000);
            }
        });
        boutonRainbow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mqttService.animate_rainbow("Laumio_CD0522");
            }
        });




    }

}
