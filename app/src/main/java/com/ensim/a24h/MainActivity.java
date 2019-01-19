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
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button boutonRouge;
    private Button boutonVert;
    private Button boutonBleu;
    private Button boutonLed;
    private Button boutonRainbow;
    private Button boutonAnneau;
    private Button boutonBranche;
    private Button boutonWipe;
    private TextInputEditText inputLed;

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
        boutonLed = (Button)findViewById(R.id.boutonLed);
        boutonRainbow = (Button)findViewById(R.id.boutonRainbow);
        boutonAnneau = (Button)findViewById(R.id.boutonAnneau);
        boutonBranche = (Button)findViewById(R.id.boutonBranche);
        boutonWipe = (Button)findViewById(R.id.boutonWipe);
        inputLed = (TextInputEditText)findViewById(R.id.inputLed);
        boutonRouge.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mqttService.subscribe_status_advertise();
                mqttService.advertise();
            }
        });
        boutonVert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mqttService.set_pixel(9,0,255,0);
            }
        });
        boutonBleu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mqttService.set_pixel(9,0,0,255);
            }
        });
        boutonLed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mqttService.set_pixel(9,255,0,0);
            }
        });
        boutonWipe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });
        boutonRainbow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mqttService.animate_rainbow();
            }
        });
        boutonAnneau.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });
        boutonBranche.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });



    }

}
