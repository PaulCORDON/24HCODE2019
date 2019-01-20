package com.ensim.a24h.Patern;

import com.ensim.a24h.MqttServices;

import java.util.ArrayList;

public class PatternNeige implements IPattern{
    ArrayList<String> listeBoules = new ArrayList<String>();

    public PatternNeige(ArrayList<String> s){
        listeBoules = s;
    }

    @Override
    public void execute() {
        MqttServices mqttService = new MqttServices();
        for (String boule : listeBoules) {
            mqttService.set_pixel(boule, 9, 0, 97, 255);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (String boule : listeBoules) {
            mqttService.set_ring(boule, 2, 89, 152, 255);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (String boule : listeBoules) {
            mqttService.set_ring(boule, 1, 178, 207, 255);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (String boule : listeBoules) {
            mqttService.set_ring(boule, 0, 255, 255, 255);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (String boule : listeBoules) {
            mqttService.set_pixel(boule, 9, 0, 0, 0);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (String boule : listeBoules) {
            mqttService.set_ring(boule, 2, 0, 0, 0);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (String boule : listeBoules) {
            mqttService.set_ring(boule, 1, 0, 0, 0);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (String boule : listeBoules) {
            mqttService.set_ring(boule, 0, 0, 0, 0);
        }

    }
}
