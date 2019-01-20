package com.ensim.a24h.Model;

public class EvenementTempSuperieurA implements IEvenement {

    public EvenementTempSuperieurA(Scenario senario, float valeurlimit) {
        this.senario = senario;
        this.valeurlimit = valeurlimit;
    }

    private Scenario senario;
    private float valeurlimit;

    void execute(){


    }
}
