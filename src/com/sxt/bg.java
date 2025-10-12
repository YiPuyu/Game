package com.sxt;

import javax.swing.*;
import java.awt.*;

public class bg  {
    static int level=1;
    int goal=level*5;
    static int count=0;
    static int waterNum=3;
    static boolean waterflag=false;
    public static long startT;
    long endT;

    Image water= Toolkit.getDefaultToolkit().getImage("imgs/imgs/water.png");
    Image sky= Toolkit.getDefaultToolkit().getImage("imgs/imgs/bg.jpg");
    Image miner= Toolkit.getDefaultToolkit().getImage("imgs/imgs/peo.png");
    Image dirt= Toolkit.getDefaultToolkit().getImage("imgs/imgs/bg1.jpg");
    void paintSelf(Graphics g){
        g.drawImage(sky,0,200,null);
        g.drawImage(dirt,0,0,null);
        switch(gameWin.state){
            case 0:drawWord(g,80,"准备开始",200,400);break;
            case 1:g.drawImage(miner,310,50,null);

                g.drawImage(water,450,40,null);
                drawWord(g,20,"关卡数"+level,30,60);
                drawWord(g,20,"积分"+count,60,80);
                drawWord(g,20,"*"+waterNum,510,70);
                drawWord(g,20,"目标积分"+goal,30,110);
                endT=System.currentTimeMillis();
                long tim=20-(endT-startT)/1000;
                drawWord(g,20,"时间"+(tim>0?tim:0),520,150);
                break;
            case 2:
            case 3:drawWord(g,80,"失败",250,350);
                drawWord(g,80,"积分"+count,200,450);

                break;
            case 4:drawWord(g,80,"成功",250,350);
                drawWord(g,80,"积分"+count,200,450);

                break;
        }


    };
    public static void drawWord(Graphics g,int size,String str,int x,int y){
        g.setColor(Color.black);
        g.setFont(new Font("Times New Roman",Font.BOLD,size));
        g.drawString(str,x,y);

    }
    boolean gtime(){
        long time=(endT-startT)/1000;
        if(time>20){return true;}
        return false;

    }


    public static void main(String[] args) {
}}
