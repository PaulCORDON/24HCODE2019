package com.ensim.a24h;

import android.util.Log;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.JSONException;
import org.json.JSONObject;


import java.nio.charset.StandardCharsets;

public class MPDServices  {
    MqttClient connection() {
        String broker = "ws://mpd.lan:6600";
        String clientId = "POLO";

        MemoryPersistence persistence = new MemoryPersistence();
        try {

            MqttClient sampleClient = new MqttClient(broker,clientId,persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            Log.d("connect", "connection: test connect ");

            connOpts.setCleanSession(true);


            Log.d("connect", "connection: test connect 2 ");

            sampleClient.connect();
            System.out.println("Connected ");
            Log.d("connect", "connection: test connect réussi  ");

            return sampleClient;
        } catch (MqttException e) {
            e.printStackTrace();
            return null;
        }
    }

    void play(){
        String topic        = "music/control/play";
        int qos             = 2;
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null) {
            try {
                Log.d("play", "play:  Avant try" );
                sampleClient.publish(topic,null);
                Log.d("play", "play: apres publication");
                System.out.println("Message published");
                //sampleClient.disconnect();
                System.out.println("Disconnected");
                //System.exit(0);
            } catch (MqttException me) {
                System.out.println("reason " + me.getReasonCode());
                System.out.println("msg " + me.getMessage());
                System.out.println("loc " + me.getLocalizedMessage());
                System.out.println("cause " + me.getCause());
                System.out.println("excep " + me);
                Log.d("play", "play: " + me );
                me.printStackTrace();
            }
        }
    }
    void pause(){
        String topic        = "music/control/pause";
        int qos             = 2;
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null) {
            try {

                sampleClient.publish(topic,null);
                System.out.println("Message published");
                sampleClient.disconnect();
                System.out.println("Disconnected");
                //System.exit(0);
            } catch (MqttException me) {
                System.out.println("reason " + me.getReasonCode());
                System.out.println("msg " + me.getMessage());
                System.out.println("loc " + me.getLocalizedMessage());
                System.out.println("cause " + me.getCause());
                System.out.println("excep " + me);
                me.printStackTrace();
            }
        }
    }
    void stop(){
        String topic        = "music/control/stop";
        int qos             = 2;
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null) {
            try {

                sampleClient.publish(topic,null);
                System.out.println("Message published");
                sampleClient.disconnect();
                System.out.println("Disconnected");
                //System.exit(0);
            } catch (MqttException me) {
                System.out.println("reason " + me.getReasonCode());
                System.out.println("msg " + me.getMessage());
                System.out.println("loc " + me.getLocalizedMessage());
                System.out.println("cause " + me.getCause());
                System.out.println("excep " + me);
                me.printStackTrace();
            }
        }
    }
    void setVol(){
        String topic        = "music/control/setvol";
        int qos             = 2;
        MqttClient sampleClient = this.connection();
        String st = "{command:23}";
        if(sampleClient!=null) {
            try {
                JSONObject jsonObj = null;
                try {
                    jsonObj = new JSONObject(st);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MqttMessage message = new MqttMessage();
                message.setPayload(jsonObj.toString().getBytes(StandardCharsets.UTF_8));
                System.out.println("Publishing message: "+jsonObj.toString());
                message.setQos(qos);
                sampleClient.publish(topic, message);
                sampleClient.disconnect();
                System.out.println("Disconnected");
                //System.exit(0);
            } catch (MqttException me) {
                System.out.println("reason " + me.getReasonCode());
                System.out.println("msg " + me.getMessage());
                System.out.println("loc " + me.getLocalizedMessage());
                System.out.println("cause " + me.getCause());
                System.out.println("excep " + me);
                me.printStackTrace();
            }
        }
    }

    void next(){
        String topic        = "music/control/next";
        int qos             = 2;
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null) {
            try {

                sampleClient.publish(topic,null);
                System.out.println("Message published");
                sampleClient.disconnect();
                System.out.println("Disconnected");
                //System.exit(0);
            } catch (MqttException me) {
                System.out.println("reason " + me.getReasonCode());
                System.out.println("msg " + me.getMessage());
                System.out.println("loc " + me.getLocalizedMessage());
                System.out.println("cause " + me.getCause());
                System.out.println("excep " + me);
                me.printStackTrace();
            }
        }
    }
    void previous(){
        String topic        = "music/control/previous";
        int qos             = 2;
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null) {
            try {

                sampleClient.publish(topic,null);
                System.out.println("Message published");
                sampleClient.disconnect();
                System.out.println("Disconnected");
                //System.exit(0);
            } catch (MqttException me) {
                System.out.println("reason " + me.getReasonCode());
                System.out.println("msg " + me.getMessage());
                System.out.println("loc " + me.getLocalizedMessage());
                System.out.println("cause " + me.getCause());
                System.out.println("excep " + me);
                me.printStackTrace();
            }
        }
    }
    void toggle(){
        String topic        = "music/control/toggle";
        int qos             = 2;
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null) {
            try {

                sampleClient.publish(topic,null);
                System.out.println("Message published");
                sampleClient.disconnect();
                System.out.println("Disconnected");
                //System.exit(0);
            } catch (MqttException me) {
                System.out.println("reason " + me.getReasonCode());
                System.out.println("msg " + me.getMessage());
                System.out.println("loc " + me.getLocalizedMessage());
                System.out.println("cause " + me.getCause());
                System.out.println("excep " + me);
                me.printStackTrace();
            }
        }
    }


}
