package com.ensim.a24h.Patern;

import com.ensim.a24h.MqttServices;

import java.util.ArrayList;

public class PatternFill implements IPattern {

    public PatternFill(ArrayList<String> listeBoules, int r, int v, int b) {
        this.listeBoules = listeBoules;
        this.r = r;
        this.v = v;
        this.b = b;
    }

    private ArrayList<String> listeBoules;
    private int r;
    private int v;
    private int b;

    @Override
    public void execute() {
        MqttServices mqttS = new MqttServices();
        for(String boule:listeBoules){
            mqttS.fill(boule,this.r,this.v,this.b);
        }
    }
}
