package com.ensim.a24h;

import com.google.gson.JsonObject;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.nio.charset.StandardCharsets;
import java.time.Instant;

public class MqttServices {

    MqttClient connection() {
        String broker = "tcp://mpd.lan:1883";
        String clientId = "POLO";
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            return sampleClient;
        } catch (MqttException e) {
            e.printStackTrace();
            return null;
        }
    }


    void advertise(){
        String topic        = "laumio/all/advertise";
        int qos             = 2;
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null) {
            try {
                MqttMessage message = new MqttMessage();
                String msg = "laumio/status/discover";
                message.setPayload(msg.getBytes());
                message.setQos(qos);
                sampleClient.publish(topic, message);
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

    void set_pixel(String nomLaumio, int numLed, int r, int v, int b) {
        String topic        = "laumio/"+nomLaumio+"/json";
        int qos             = 2;
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null){
            try {
                MqttMessage message = new MqttMessage();
                JsonObject event = new JsonObject();
                event.addProperty("command", "set_pixel");
                event.addProperty("led", numLed);
                String s ="["+r+","+v+","+b+"]";
                event.addProperty("rgb", s);
                message.setPayload(event.toString().getBytes(StandardCharsets.UTF_8));
                System.out.println("Publishing message: "+event.toString().getBytes(StandardCharsets.UTF_8));
                message.setQos(qos);
                sampleClient.publish(topic, message);
                System.out.println("Message published");
                sampleClient.disconnect();
                System.out.println("Disconnected");
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

    /*Change la couleur d’un anneau.
    Les 4 octets du message sont le numéro de l’anneau
    suivi des composantes rouge, vert, bleu de la couleur (0 à 255)*/
    void set_ring(String nomLaumio, int numAnneau, int r, int v, int b) {
        String topic        = "laumio/"+nomLaumio+"/json";
        int qos             = 2;
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null){
            try {
                MqttMessage message = new MqttMessage();
                JsonObject event = new JsonObject();
                event.addProperty("command", "set_ring");
                event.addProperty("ring", "numAnneau");
                String s ="["+r+","+v+","+b+"]";
                event.addProperty("rgb", s);
                message.setPayload(event.toString().getBytes(StandardCharsets.UTF_8));
                System.out.println("Publishing message: "+event.toString().getBytes(StandardCharsets.UTF_8));
                message.setQos(qos);
                sampleClient.publish(topic, message);
                System.out.println("Message published");
                sampleClient.disconnect();
                System.out.println("Disconnected");
            } catch(MqttException me) {
                System.out.println("reason "+me.getReasonCode());
                System.out.println("msg "+me.getMessage());
                System.out.println("loc "+me.getLocalizedMessage());
                System.out.println("cause "+me.getCause());
                System.out.println("excep "+me);
                me.printStackTrace();
            }
        }
    }

    /*Change la couleur d’une colonne.
    Les 4 octets du message sont le numéro de la colonne
    suivi des composantes rouge, vert, bleu de la couleur (0 à 255)*/
    void set_column(String nomLaumio,int numCol, int r, int v, int b) {
        String topic        = "laumio/"+nomLaumio+"json";
        int qos             = 2;
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null){
            try {
                MqttMessage message = new MqttMessage();
                JsonObject event = new JsonObject();
                event.addProperty("command", "set_column");
                event.addProperty("column", "numCol");
                String s ="["+r+","+v+","+b+"]";
                event.addProperty("rgb", s);
                message.setPayload(event.toString().getBytes(StandardCharsets.UTF_8));
                System.out.println("Publishing message: "+event.toString().getBytes(StandardCharsets.UTF_8));
                message.setQos(qos);
                sampleClient.publish(topic, message);
                System.out.println("Message published");
                sampleClient.disconnect();
                System.out.println("Disconnected");
                //System.exit(0);
            } catch(MqttException me) {
                System.out.println("reason "+me.getReasonCode());
                System.out.println("msg "+me.getMessage());
                System.out.println("loc "+me.getLocalizedMessage());
                System.out.println("cause "+me.getCause());
                System.out.println("excep "+me);
                me.printStackTrace();
            }
        }
    }

    /*Démarre l’animation de remplissage progressif avec une couleur et une durée.
    Les 4 octets du message sont les composantes rouge, vert, bleu de la couleur (0 à 255)
    suivies de la durée.*/
    void color_wipe(String nomLaumio,int r, int v, int b, int duree) {
        String topic        = "laumio/"+nomLaumio+"/json";
        int qos             = 2;
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null){
            try {
                MqttMessage message = new MqttMessage();
                JsonObject event = new JsonObject();
                event.addProperty("command", "color_wipe");
                event.addProperty("duration", duree);
                String s ="["+r+","+v+","+b+"]";
                event.addProperty("rgb", s);
                message.setPayload(event.toString().getBytes(StandardCharsets.UTF_8));
                System.out.println("Publishing message: "+event.toString().getBytes(StandardCharsets.UTF_8));
                System.out.println("Published Message: " + event.toString());
                message.setQos(qos);
                sampleClient.publish(topic, message);
                System.out.println("Message published");
                sampleClient.disconnect();
                System.out.println("Disconnected");
                //System.exit(0);
            } catch(MqttException me) {
                System.out.println("reason "+me.getReasonCode());
                System.out.println("msg "+me.getMessage());
                System.out.println("loc "+me.getLocalizedMessage());
                System.out.println("cause "+me.getCause());
                System.out.println("excep "+me);
                me.printStackTrace();
            }
        }
    }

    // Démarre l’animation arc-en - ciel.
    // Le contenu du message est ignoré.
    void animate_rainbow(String s) {

        String topic        = "laumio/"+s+"/json";
        int qos             = 2;

        JsonObject event = new JsonObject();
        event.addProperty("command", "animate_rainbow");

        System.out.println("Published Message: " + event.toString());
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null){
            try {
                MqttMessage message = new MqttMessage();
                message.setPayload(event.toString().getBytes(StandardCharsets.UTF_8));
                System.out.println("Publishing message: "+event.toString().getBytes(StandardCharsets.UTF_8));
                message.setQos(qos);
                sampleClient.publish(topic, message);
                System.out.println("Message published");
                sampleClient.disconnect();
                System.out.println("Disconnected");
                //System.exit(0);
            } catch(MqttException me) {
                System.out.println("reason "+me.getReasonCode());
                System.out.println("msg "+me.getMessage());
                System.out.println("loc "+me.getLocalizedMessage());
                System.out.println("cause "+me.getCause());
                System.out.println("excep "+me);
                me.printStackTrace();
            }
        }
    }

    // Change la couleur de toutes les leds.
    // Les 3 octets du message sont les composantes rouge, vert, bleu de la couleur (0 à 255)
    void fill(String s, int r, int v, int b) {

        String topic        = "laumio/"+s+"/json";
        int qos             = 2;

        JsonObject event = new JsonObject();
        event.addProperty("command", "fill");
        String rvb ="["+r+","+v+","+b+"]";
        event.addProperty("rgb", rvb);
        event.addProperty("command", "fill");
        System.out.println("Published Message: " + event.toString());
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null){
            try {
                MqttMessage message = new MqttMessage();
                message.setPayload(event.toString().getBytes(StandardCharsets.UTF_8));
                System.out.println("Publishing message: "+event.toString().getBytes(StandardCharsets.UTF_8));
                message.setQos(qos);
                sampleClient.publish(topic, message);
                System.out.println("Message published");
                sampleClient.disconnect();
                System.out.println("Disconnected");
                //System.exit(0);
            } catch(MqttException me) {
                System.out.println("reason "+me.getReasonCode());
                System.out.println("msg "+me.getMessage());
                System.out.println("loc "+me.getLocalizedMessage());
                System.out.println("cause "+me.getCause());
                System.out.println("excep "+me);
                me.printStackTrace();
            }
        }
    }

    // Renvoie un message sur le topic laumio/status/advertise contenant son nom.
    void discover() {

    }


    // !!!!!!!!!!!Fonctions pour les capteurs!!!!!!!!!!!!!!!!!!

    //Fonction pour la telecommande
    void subscribe_telecommande(/*nom de la touche*/) {

    }

    //Fonction pour le capteur de presence state
    void subscribe_presence_state() {

    }

    // Fonction pour le capteur de presence status
    void subscribe_presence_status() {

    }

    //Fonction pour le capteur de distance value
    void subscribe_distance_value() {

    }

    //Fonction pour le capteur de distance status
    void subscribe_distance_status() {

    }

    //Fonction pour le capteur atmosphérique

    void subscribe_atmosphere_temperature() {

    }


    void subscribe_atmosphere_pression() {

    }

    void subscribe_atmosphere_humidite() {

    }

    void subscribe_atmosphere_humidite_absolue() {
        String topic = "atmosphere/humidite_absolue";


    }

    void subscribe_status_advertise() {
        String topic = "laumio/status/discover";
        MqttClient sampleClient = this.connection();
        if (sampleClient != null) {

            try {
                sampleClient.subscribeWithResponse(topic);
                System.out.println(sampleClient.subscribeWithResponse(topic));
            } catch (MqttException e) {
                e.printStackTrace();
            }


        }
    }
}