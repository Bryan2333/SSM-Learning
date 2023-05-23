package com.bryan02.humen;

import com.bryan02.alex.Boyfriend;

public class Anna extends MotherSelectBoyfriend{

    private Boyfriend boyfriend;

    public Anna(Boyfriend boyfriend){
        super(boyfriend);
    }

    @Override
    public void OK() {
        boyfriend.rich();
        boyfriend.happy();
        boyfriend.starving();
        boyfriend.sad();
        boyfriend.sick();
    }
}
