package com.ensim.a24h.Patern;

import com.ensim.a24h.MqttServices;

import java.util.ArrayList;

public class PatternRainbow implements IPattern{

    public PatternRainbow(ArrayList<String> listeBoules) {
        this.listeBoules = listeBoules;
    }

    private ArrayList<String> listeBoules;

    @Override
    public void execute() {
        MqttServices mqttS = new MqttServices();
        for(String boule:listeBoules){
            mqttS.animate_rainbow(boule);
        }

    }
}
