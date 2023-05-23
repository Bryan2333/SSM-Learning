package com.bryan02.alex;

public class Alen implements Boyfriend{

    public void sick(){
        System.out.println("bob的生病状态");
    }

    public void happy(){
        System.out.println("Bob吃到肉感觉很高兴");
    }

    @Override
    public void sad() {

    }

    public void rich(){
        System.out.println("给你钱，拿去花吧");
    }

    public void starving(){
        System.out.println("我饿了，再见");
    }

}
