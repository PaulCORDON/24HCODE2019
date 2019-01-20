package com.ensim.a24h;

import com.google.gson.JsonObject;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class MqttServices {

    public String currentTempValue;
    public String currentPressionValue;
    public String currentHumiditeValue;
    public String currentDistanceValue;
    public String currentHumiditeAbsolueValue;
    

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


    public void advertise(){
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

    public void set_pixel(String nomLaumio, int numLed, int r, int v, int b) {

        String topic        = "laumio/"+nomLaumio+"/json";
        int qos             = 2;
        // Convert numbers array into JSON string.;
        String st = "{command:'set_pixel','led':"+numLed+",rgb:["+r+", "+v+", "+b+"]}";
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null){
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

    /*Change la couleur d’un anneau.
    Les 4 octets du message sont le numéro de l’anneau
    suivi des composantes rouge, vert, bleu de la couleur (0 à 255)*/
    public void set_ring(String nomLaumio, int numAnneau, int r, int v, int b) {

        String topic        = "laumio/"+nomLaumio+"/json";
        int qos             = 2;
        // Convert numbers array into JSON string.;
        String st = "{command:'set_ring','ring':"+numAnneau+",rgb:["+r+", "+v+", "+b+"]}";
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null){
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
    public void set_column(String nomLaumio,int numCol, int r, int v, int b) {

        String topic        = "laumio/"+nomLaumio+"/json";
        int qos             = 2;
        // Convert numbers array into JSON string.;
        String st = "{command:'set_column','column':"+numCol+",rgb:["+r+", "+v+", "+b+"]}";
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null){
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
    public void color_wipe(String nomLaumio,int r, int v, int b, int duree) {

        String topic        = "laumio/"+nomLaumio+"/json";
        int qos             = 2;
        // Convert numbers array into JSON string.;
        String st = "{command:'color_wipe','duration':"+duree+",rgb:["+r+", "+v+", "+b+"]}";
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null){
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
    public void animate_rainbow(String s) {

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
    public void fill(String s, int r, int v, int b) {

        String topic        = "laumio/"+s+"/json";
        int qos             = 2;
        // Convert numbers array into JSON string.;
        String st = "{command:'fill',rgb:["+r+", "+v+", "+b+"]}";
        MqttClient sampleClient = this.connection();
        if(sampleClient!=null){
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


    // !!!!!!!!!!!Fonctions pour les capteurs!!!!!!!!!!!!!!!!!!

    //Fonction pour la telecommande
    public void subscribe_telecommande(/*nom de la touche*/) {

    }

    //Fonction pour le capteur de presence state
    public void subscribe_presence_state() {

    }

    // Fonction pour le capteur de presence status
    void subscribe_presence_status() {

    }

    //Fonction pour le capteur de distance value
    public void subscribe_distance_value() {
        MqttClient client = this.connection();
        try {
            client.subscribe("distance/value");
        } catch (MqttException e) {
            e.printStackTrace();
        }
        client.setCallback(new MqttCallback() {
            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println(new String(message.getPayload()));
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                System.out.println("fail");
            }

            @Override
            public void connectionLost(Throwable ex) {

                ex.printStackTrace();
            }
        });
    }

    //Fonction pour le capteur de distance status
    public void subscribe_distance_status() {
        MqttClient client = this.connection();
        try {
            client.subscribe("distance/status");
        } catch (MqttException e) {
            e.printStackTrace();
        }
        client.setCallback(new MqttCallback() {
            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println(new String(message.getPayload()));
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                System.out.println("fail");
            }

            @Override
            public void connectionLost(Throwable ex) {

                ex.printStackTrace();
            }
        });
    }

    //Fonction pour le capteur atmosphérique

    public void subscribe_atmosphere_temperature() {
        MqttClient client = this.connection();
        try {
            client.subscribe("atmosphere/temperature");
        } catch (MqttException e) {
            e.printStackTrace();
        }
        client.setCallback(new MqttCallback() {
            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println(new String(message.getPayload()));
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                System.out.println("fail");
            }

            @Override
            public void connectionLost(Throwable ex) {

                ex.printStackTrace();
            }
        });
    }


    public void subscribe_atmosphere_pression() {
        MqttClient client = this.connection();
        try {
            client.subscribe("atmosphere/pression");
        } catch (MqttException e) {
            e.printStackTrace();
        }
        client.setCallback(new MqttCallback() {
            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println(new String(message.getPayload()));
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                System.out.println("fail");
            }

            @Override
            public void connectionLost(Throwable ex) {

                ex.printStackTrace();
            }
        });
    }

    public void subscribe_atmosphere_humidite() {
        MqttClient client = this.connection();
        try {
            client.subscribe("atmosphere/humidite");
        } catch (MqttException e) {
            e.printStackTrace();
        }
        client.setCallback(new MqttCallback() {
            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println(new String(message.getPayload()));
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                System.out.println("fail");
            }

            @Override
            public void connectionLost(Throwable ex) {

                ex.printStackTrace();
            }
        });
    }

    public void subscribe_atmosphere_humidite_absolue() {
        MqttClient client = this.connection();
        try {
            client.subscribe("atmosphere/humidite_absolue");
        } catch (MqttException e) {
            e.printStackTrace();
        }
        client.setCallback(new MqttCallback() {
            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println(new String(message.getPayload()));
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                System.out.println("fail");
            }

            @Override
            public void connectionLost(Throwable ex) {

                ex.printStackTrace();
            }
        });

    }


    public void subscribe_status_advertise() {
    }
}

