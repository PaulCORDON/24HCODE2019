package com.ensim.a24h.Patern;

import com.ensim.a24h.MqttServices;

import java.util.ArrayList;

public class PatternBrancheRotative implements IPattern{
    int r;
    int v;
    int b;
    private ArrayList<String> listeBoules;

    public PatternBrancheRotative(int r, int v, int b, ArrayList<String> s){
        this.r=r;
        this.v=v;
        this.b=b;
        listeBoules=s;
    }


    @Override
    public void execute(){
        MqttServices mqttService = new MqttServices();
        for (String boule : listeBoules) {mqttService.set_column(boule,0,r,v,b);}
        for (String boule : listeBoules) {
            mqttService.set_column(boule,0,0,0,0);
            mqttService.set_column(boule,1,r,v,b);}
        for (String boule : listeBoules) {
            mqttService.set_column(boule,1,0,0,0);
            mqttService.set_column(boule,2,r,v,b);}
        for (String boule : listeBoules) {
            mqttService.set_column(boule,2,0,0,0);
            mqttService.set_column(boule,3,r,v,b);}

        for (String boule : listeBoules) {
            mqttService.set_column(boule,3,0,0,0);
            mqttService.set_column(boule,0,r,v,b);}
        for (String boule : listeBoules) {
            mqttService.set_column(boule,0,0,0,0);
            mqttService.set_column(boule,1,r,v,b);}
        for (String boule : listeBoules) {
            mqttService.set_column(boule,1,0,0,0);
            mqttService.set_column(boule,2,r,v,b);}
        for (String boule : listeBoules) {
            mqttService.set_column(boule,2,0,0,0);
            mqttService.set_column(boule,3,r,v,b);}

        for (String boule : listeBoules) {
            mqttService.set_column(boule,3,0,0,0);
            mqttService.set_column(boule,0,r,v,b);}
        for (String boule : listeBoules) {
            mqttService.set_column(boule,0,0,0,0);
            mqttService.set_column(boule,1,r,v,b);}
        for (String boule : listeBoules) {
            mqttService.set_column(boule,1,0,0,0);
            mqttService.set_column(boule,2,r,v,b);}
        for (String boule : listeBoules) {
            mqttService.set_column(boule,2,0,0,0);
            mqttService.set_column(boule,3,r,v,b);}

        for (String boule : listeBoules) {mqttService.set_column(boule,3,0,0,0);}

    }
}
