package com.ensim.a24h.Model;

import com.ensim.a24h.Patern.IPattern;

import java.util.ArrayList;

public class Scenario extends ArrayList<IPattern>{
    public void execute(){
        for(IPattern pattern : this){
            pattern.execute();
        }
    }
}
