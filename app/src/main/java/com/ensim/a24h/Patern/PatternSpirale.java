package com.ensim.a24h.Patern;

import com.ensim.a24h.MqttServices;

import java.util.ArrayList;

public class PatternSpirale implements IPattern{
    ArrayList<String> listeBoules = new ArrayList<String>();

    PatternSpirale(ArrayList<String> s){
        listeBoules = s;
    }

    @Override
    public void execute() {
        MqttServices mqttService = new MqttServices();
        for(String s : listeBoules){mqttService.fill(s,0,0,0);}

        for(String s : listeBoules){mqttService.set_pixel(s,8,255, 0, 152);}
        for(String s : listeBoules){mqttService.set_pixel(s,10,255, 0, 152);}
        for(String s : listeBoules){mqttService.set_pixel(s,1,195, 0, 255);}
        for(String s : listeBoules){mqttService.set_pixel(s,4,195, 0, 255);}
        for(String s : listeBoules){mqttService.set_pixel(s,8,0, 0, 0);}
        for(String s : listeBoules){mqttService.set_pixel(s,10,0, 0, 0);}
        for(String s : listeBoules){mqttService.set_pixel(s,12,59, 0, 255);}
        for(String s : listeBoules){mqttService.set_pixel(s,6,59, 0, 255);}
        for(String s : listeBoules){mqttService.set_pixel(s,1,0, 0, 0);}
        for(String s : listeBoules){mqttService.set_pixel(s,4,0, 0, 0);}
        for(String s : listeBoules){mqttService.set_pixel(s,8,255, 0, 152);}
        for(String s : listeBoules){mqttService.set_pixel(s,10,255, 0, 152);}
        for(String s : listeBoules){mqttService.set_pixel(s,12,0, 0, 0);}
        for(String s : listeBoules){mqttService.set_pixel(s,6,0, 0, 0);}
        for(String s : listeBoules){mqttService.set_pixel(s,1,195, 0, 255);}
        for(String s : listeBoules){mqttService.set_pixel(s,4,195, 0, 255);}
        for(String s : listeBoules){mqttService.set_pixel(s,8,0, 0, 0);}
        for(String s : listeBoules){mqttService.set_pixel(s,10,0, 0, 0);}
        for(String s : listeBoules){mqttService.set_pixel(s,12,59, 0, 255);}
        for(String s : listeBoules){mqttService.set_pixel(s,6,59, 0, 255);}
        for(String s : listeBoules){mqttService.set_pixel(s,1,0, 0, 0);}
        for(String s : listeBoules){mqttService.set_pixel(s,4,0, 0, 0);}
        for(String s : listeBoules){mqttService.set_pixel(s,12,0, 0, 0);}
        for(String s : listeBoules){mqttService.set_pixel(s,6,0, 0, 0);}

    }
}
