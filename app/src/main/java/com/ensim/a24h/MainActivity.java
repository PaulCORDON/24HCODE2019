package com.ensim.a24h;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button boutonRouge = (Button)findViewById(R.id.boutonRouge);
    private Button boutonVert = (Button)findViewById(R.id.boutonVert);
    private Button boutonBleu = (Button)findViewById(R.id.boutonBleu);
    private Button boutonLed = (Button)findViewById(R.id.boutonLed);
    private Button boutonRainbow = (Button)findViewById(R.id.boutonRainbow);
    private Button boutonAnneau = (Button)findViewById(R.id.boutonAnneau);
    private Button boutonBranche = (Button)findViewById(R.id.boutonBranche);
    private Button boutonWipe = (Button)findViewById(R.id.boutonWipe);
    private TextInputLayout inputLed = (TextInputLayout)findViewById(R.id.inputLed);

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
        
        boutonRouge.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });
        boutonVert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });
        boutonBleu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
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
                // Code here executes on main thread after user presses button
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
