package com.sxt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class gameWin extends JFrame {
    List<GameObject> gameObjectList =new ArrayList<GameObject>();
   bg bg1 = new bg();
   line line = new line(this);
   static int state;

    {
        for(int i=0;i<10;i++){
            double random=Math.random();
            Gold gold = new Gold();
            boolean flag=true;
            if(random<0.3){gold=new GoldPlus();}
            else if(random>0.3&&random<0.7){gold=new GoldMini();}
            else{gold=new Gold();}
            for(GameObject o: gameObjectList){
                if(gold.getRec().intersects(o.getRec())){
                    flag=false;

                }

            }if(flag==true){
                gameObjectList.add(gold);
            }else{flag=true;i--;}
        }
        for(int i=0;i<5;i++){
           boolean isplace=true;
           Rock rock=new Rock();
           for(GameObject o: gameObjectList){
               if(o.getRec().intersects(rock.getRec())){
                   isplace=false;
               }
           }if(isplace){
               gameObjectList.add(rock);
            }else {isplace=true;i--;}

        }
    }
   Image offScreenImage;
    public void paint(Graphics g) {
        offScreenImage=this.createImage(768,1000);
        Graphics gImage=offScreenImage.getGraphics();

        bg1.paintSelf(gImage);
        if(state==1){
            for(GameObject o: gameObjectList){
                o.paintSelf(gImage);
            }
            line.paintSelf(gImage);


        }g.drawImage(offScreenImage,0,0,null);




    }
    public void nextLevel() {
        if (bg1.gtime() && state == 1) {
            if (bg1.count >= bg1.goal) {
                if (bg.level == 3) {
                    state = 4;
                } else {
                    bg.level++;
                }
                dispose();
               // 重置分数
                gameWin wee = new gameWin();
                bg.startT = System.currentTimeMillis();
                wee.launch();
            } else {
                state = 3;
            }
        }
    }




    void launch(){
        this.setVisible(true);
        this.setSize(768,1000);
        this.setLocationRelativeTo(null);
        this.setTitle("GoldMiner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(state)
                {case 0:
                    if(e.getClickCount()==3){state=1;
                    bg1.startT=  System.currentTimeMillis();
                        MusicUtil.playSound("sound/黄金矿工/下一个关.wav");

                    }break;
                    case 1:if (e.getButton() == 1&&line.state==0) {
                        line.state=1;
                    }
                        if(e.getButton()==3&&line.state==3){
                            bg.waterflag=true;
                            bg.waterNum--;

                        }break;
                    case 2:
                    case 3:
                    case 4:

                }

            }
        });
        while(true){
            repaint();
           nextLevel();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }


    }






    public static void main(String[] args) {
        gameWin game = new gameWin();
        game.launch();
    }
}
