package com.sxt;

import java.awt.*;

public class line {
    int x=380;
    int y=180;

    int endx=500;
    int endy=500;

    double length=100;
    double n=0;
    int dir=1;
    int state;
    gameWin frame;
    int m;
    Image hook=Toolkit.getDefaultToolkit().getImage(("imgs/imgs/hook.png"));

    line(gameWin frame){
        this.frame=frame;

    }

    void lines(Graphics g){
        endx=(int)(x+length*Math.cos(n*Math.PI));
        endy=(int)(y+length*Math.sin(n*Math.PI));
        g.setColor(Color.red);
        g.drawLine(x+1,y+2,endx,endy);
        g.drawLine(x,y,endx,endy);
        g.drawLine(x-1,y-2,endx,endy);
        g.drawImage(hook,endx-36,endy-2,null);
    }
    void logic(){
        for(GameObject o: frame.gameObjectList){
        if(endx>o.x&&endx<o.x+o.width&&endy>o.y&&endy<o.y+o.height){
            state=3;
            o.flag=true;
        }}
    }




    void paintSelf(Graphics g)  {
        logic();
        switch (state){
            case 0:if(n<0.1){
                dir=1;
            }
            else if(n>0.9){dir=-1;}
                n=n+0.005*dir;
               lines(g);
                break;
                case 1:
                    if(length<800){
                    length+=10;
                    lines(g);

        }else{state=2;} break;
                    case 2:if(length>100){length-=10;
                       lines(g);}
                    else{state=0;}break;
            case 3:
                if(length>100){length-=10;
                lines(g);
                    for(GameObject o: frame.gameObjectList){

                        if(o.flag==true){ m=o.m;
                            o.x=endx-o.getWidth()*1/2;
                            o.y=endy;

                            if(length<=100&&o.flag){
                                o.x = -150;
                                o.y = -150;
                                bg.count += o.count;
                                o.flag = false;
                                state = 0;
                            }
                            if(bg.waterflag){
                                if(o.type==1){
                                    m=1;
                                }
                                if(o.type==2){
                                    o.x = -150;
                                    o.y = -150;
                                    o.flag = false;
                                    bg.waterflag = false;
                                    state = 2;

                                }

                            }
                        }





                    }


            }
                try {
                    Thread.sleep(m);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;




    };
}}
