package com.ensim.a24h.Patern;

import com.ensim.a24h.MqttServices;

import java.util.ArrayList;

public class PatternColumn implements IPattern{

    public PatternColumn(ArrayList<String> listeBoules, int r, int v, int b, int numCol) {
        this.listeBoules = listeBoules;
        this.r = r;
        this.v = v;
        this.b = b;
        this.numCol = numCol;
    }

    private ArrayList<String> listeBoules;
    private int r;
    private int v;
    private int b;
    private int numCol;
    @Override
    public void execute() {
        MqttServices mqttS = new MqttServices();
        for(String boule:listeBoules){
            mqttS.set_column(boule,numCol,this.r,this.v,this.b);
        }
    }
}
