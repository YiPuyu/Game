package com.sxt;

import java.awt.*;

public class Rock extends GameObject {
    Rock() {
        this.x=(int) (Math.random()*700);
        this.y=(int)(Math.random()*550+300);
        flag=false;
        this.width=71;
        this.height=71;
        this.m=200;
        this.count=1;
        this.type=2;
        this.img= Toolkit.getDefaultToolkit().getImage("imgs/imgs/rock1.png");
    }

}
