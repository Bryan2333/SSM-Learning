package com.bryan02.alex;

public class Rose {

    //private final Boyfriend boyfriend;
    private Boyfriend boyfriend;

    public Rose(Boyfriend boyfriend){
        this.boyfriend = boyfriend;
    }

    public void controlboyfriend(){

        boyfriend.sick();
        boyfriend.happy();

    }

    public void persuadeboyfriend(){

        boyfriend.rich();
        boyfriend.sad();
        boyfriend.starving();

    }





}
