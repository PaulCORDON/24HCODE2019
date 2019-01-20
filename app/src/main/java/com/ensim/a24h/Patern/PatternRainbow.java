package com.ensim.a24h.Patern;

import com.ensim.a24h.MqttServices;

import java.util.ArrayList;

public class PatternRainbow implements IPattern{

    public PatternRainbow(ArrayList<String> s) {
        this.s = s;
    }

    private ArrayList<String> s;

    @Override
    public void execute() {
        MqttServices mqttS = new MqttServices();
        for(String boule:s)
        mqttS.animate_rainbow(boule);
    }
}
