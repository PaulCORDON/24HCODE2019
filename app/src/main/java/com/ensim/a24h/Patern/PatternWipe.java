package com.ensim.a24h.Patern;

import com.ensim.a24h.MqttServices;

import java.util.ArrayList;

public class PatternWipe implements IPattern {

    public PatternWipe(ArrayList<String> listeBoules, int r, int v, int b, int duree) {
        this.listeBoules = listeBoules;
        this.r = r;
        this.v = v;
        this.b = b;
        this.duree = duree;
    }

    private ArrayList<String> listeBoules;
    private int r;
    private int v;
    private int b;
    private int duree;

    @Override
    public void execute() {
        MqttServices mqttS = new MqttServices();
        for(String boule:listeBoules){
            mqttS.color_wipe(boule,this.r,this.v,this.b,this.duree);
        }
    }
}
