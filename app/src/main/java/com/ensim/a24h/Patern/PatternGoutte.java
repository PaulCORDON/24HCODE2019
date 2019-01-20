package com.ensim.a24h.Patern;

import com.ensim.a24h.MqttServices;

public class PatternGoutte implements IPattern{
    int r;
    int v;
    int b;

    public PatternGoutte(int r,int v,int b){
        this.r=r;
        this.v=v;
        this.b=b;
    }

    @Override
    public void execute(){
        MqttServices mqttService = new MqttServices();
        mqttService.fill("Laumio_10508F",r,v,b);
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mqttService.fill("Laumio_10508F",0,0,0);

        mqttService.fill("Laumio_104A13",r,v,b);
        mqttService.fill("Laumio_0FBFBF",r,v,b);
        mqttService.fill("Laumio_CD0522",r,v,b);
        mqttService.fill("Laumio_0FC168",r,v,b);
        mqttService.fill("Laumio_10805F",r,v,b);
        mqttService.fill("Laumio_104F03",r,v,b);
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mqttService.fill("Laumio_104A13",0,0,0);
        mqttService.fill("Laumio_0FBFBF",0,0,0);
        mqttService.fill("Laumio_CD0522",0,0,0);
        mqttService.fill("Laumio_0FC168",0,0,0);
        mqttService.fill("Laumio_10805F",0,0,0);
        mqttService.fill("Laumio_104F03",0,0,0);

        mqttService.fill("Laumio_1D9486",r,v,b);
        mqttService.fill("Laumio_D454DB",r,v,b);
        mqttService.fill("Laumio_107DA8",r,v,b);
        mqttService.fill("Laumio_88813D",r,v,b);
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mqttService.fill("Laumio_1D9486",0,0,0);
        mqttService.fill("Laumio_D454DB",0,0,0);
        mqttService.fill("Laumio_107DA8",0,0,0);
        mqttService.fill("Laumio_88813D",0,0,0);

    }
}
