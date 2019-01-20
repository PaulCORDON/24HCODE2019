package com.ensim.a24h.Model;

import com.ensim.a24h.Patern.IPattern;

import java.util.ArrayList;

public class Scenario extends ArrayList<IPattern>{
    void execute(){
        for(IPattern pattern : this){
            pattern.execute();
        }
    }

    public String getChoix() {
        return choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    private String choix;

    public ArrayList<IPattern> getList() {
        return list;
    }

    public void setList(ArrayList<IPattern> list) {
        this.list = list;
    }

    private ArrayList<IPattern> list;
}
