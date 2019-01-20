package com.ensim.a24h.Patern;

import com.ensim.a24h.MqttServices;

import java.util.ArrayList;

public class PatternRing implements IPattern {

    public PatternRing(ArrayList<String> listeBoules, int r, int v, int b, int numRing) {
        this.listeBoules = listeBoules;
        this.r = r;
        this.v = v;
        this.b = b;
        this.numRing = numRing;
    }
    private ArrayList<String> listeBoules;
    private int r;
    private int v;
    private int b;
    private int numRing;
    @Override
    public void execute() {
        MqttServices mqttS = new MqttServices();
        for(String boule:listeBoules){

            mqttS.set_ring(boule,numRing,this.r,this.v,this.b);
        }
    }
}
