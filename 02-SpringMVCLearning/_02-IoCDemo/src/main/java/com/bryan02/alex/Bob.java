package com.bryan02.alex;



public class Bob implements Boyfriend{

    public void sick(){
        System.out.println("bob的生病状态");
    }

    public void happy(){
        System.out.println("Bob吃到肉感觉很高兴");
    }

    public void sad(){
        System.out.println("bob很穷感到很难过");
    }

    public void starving(){
        System.out.println("我饿了，再见");
    }

    @Override
    public void rich() {

    }

}
