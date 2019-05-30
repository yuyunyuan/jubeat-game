class character {
  float x, y;
  float tx, ty;
  float att;
  int dir;
  boolean attc;
  float foot;
  int fc;
  boolean movestatus;
  boolean cancontrol;
  npc n;
  //dir 0 is up 3 is right
  character() {
    n=new npc(null, 1, 3, 1000, 1, new String[]{"", ""}, "You");
    x=width*23/48;
    y=height*15/32;
    tx=10;
    ty=7;
    //tx=1;
    //ty=0;
    dir=1;
    att=0;
    foot=0;
    fc=0;
    attc=false;
    movestatus=false;
    cancontrol=true;
  }
  void setmovestatus(boolean a) {
    movestatus=a;
  }
  void drawmanVerti(float x, float y, float w, float h, float foot) {
    strokeWeight(1);
    fill(255);
    ellipse(x, y-h*3/8, h/4, h/4);
    rect(x-h*5/32, y+h/16, h/7, h*7/16+foot, 100);
    rect(x+h/64, y+h/16, h/7, h*7/16-foot, 100);
    rect(x-h*3/16, y-h/4, h*3/8, h*3/8, 100);
  }
  void drawmanHori(float x, float y, float w, float h, float foot) {
    strokeWeight(1);
    fill(255);
    ellipse(x, y-h*3/8, h/4, h/4);
    rect(x-h*5/32+foot/2, y+h/16, h/7, h*7/16, 100);
    rect(x+h/64-foot/2, y+h/16, h/7, h*7/16, 100);
    rect(x-h*3/16, y-h/4, h*3/8, h*3/8, 100);
  }
  void drawit() {
    fill(255);
    stroke(0);
    //ellipse(x, y, 30, 30);
    if (x-(width*(tx*2+3)/48)>4)
      x-=main_speed;
    else if (x-(width*(tx*2+3)/48)<-4)
      x+=main_speed;
    //println("Y:"+y);
    //println(ty);
    //println(y-(height*(ty*2+1)/32));
    if (y-(height*(ty*2+1)/32)>4)
      y-=main_speed;
    else if (y-(height*(ty*2+1)/32)<-4)
      y+=main_speed;
    if (attc) {
      getthit(dir, tx, ty);
      att+=(height/32/5);
      if (att>height/32)
      {
        att=0;
        attc=false;
      }
    }
    if (dist((width*(tx*2+3)/48), height*((ty)*2+1)/32, x, y)<height/32) {
      movestatus=false;
      cancontrol=true;
    }
    if (movestatus) {
      foot+=fc*height/128/4;
      if (foot>height/128)
        fc=-1;
      if (foot<-height/128)
        fc=1;
    } else {
      fc=0;
      foot=0;
    }
    //println("X:"+tx);
    //println("Y:"+ty);
    //println(currentlevel);
    //println((width*(24*2)/48)-x);
    if ((width*(24*2+3)/48)-x<width/96&&currentlevel==0) {
      wind2c=false;
      wind2.stop();
      b1c=true;
      currentlevel=1;
      x=0;
      y=height*15/32;
      tx=10;
      dir=3;
      ty=7;
      scene6color=255;
      movestatus=true;
      cancontrol=false;
      fc=1;
      recorder=millis();
    } else if ((width*(24*2+3)/48)-x<width/96&&currentlevel==1&&l1) {
      currentlevel=2;
      x=width*23/48;
      y=height*15/32;
      ladyc=true;
      tx=10;
      dir=3;
      scene6color=255;
      ty=7;
      movestatus=true;
      cancontrol=false;
      fc=1;
      recorder=millis();
    } else if ((width*(24*2+3)/48)-x<width/96&&currentlevel==3&&l3) {
      wind1c=false;
      wind1.stop();
      file1.loop();
      scene4counter=0;
      currentlevel=4;
      x=0;
      y=height*15/32;
      tx=10;
      dir=3;
      scene6color=255;
      ty=7;
      movestatus=true;
      cancontrol=false;
      fc=1;
      recorder=millis();
    } else if ((width*(24*2+3)/48)-x<width/96&&currentlevel==4&&l4) {
      if (scene4counter>1) {
        wind1c=true;

        if (l3) {
          showstr="You are too greedy!!!The magic stick of Kindness is broken";
          showins=true;
          showtime=millis();
          stone3.value=false;
        }
        for (npc t : ghost)
          t.hp=100;
        l3=false;
        currentlevel=3; 
        main.tx=10;
        main.ty=7;
        main.dir=3;
        scene6color=255;
        main.movestatus=false;
        main.cancontrol=true;
        main.fc=0;
        recorder=millis();
      } else {

        showstr="Well done!\nMagic stick of Temperance is earned";
        showins=true;
        showtime=millis();
        //https://forum.processing.org/two/discussion/1576/controlp5-basic-example-text-input-field
        cp5.addTextfield("GuessText").setPosition(width/16, height*6/8).setSize(400, 40);
        cp5.addButton("guess").setPosition(width/16+400, height*6/8).setSize(80, 40); 
        stone4.value=true;
        currentlevel=5;
        x=0;
        y=height*15/32;
        tx=10;
        dir=3;
        ty=7;
        movestatus=true;
        scene6color=255;
        cancontrol=false;
        fc=1;
        recorder=millis();
      }
    } else if ((width*(24*2+3)/48)-x<width/96&&currentlevel==6) {
      file1.stop();
      showstr="Hard work!!\nMagic stick of Patience is earned";
      showins=true;
      showtime=millis();
      stone6.value=true;
      currentlevel=7;
      x=0;
      y=height*15/32;
      tx=10;
      dir=3;
      ty=12;
      movestatus=true;
      cancontrol=false;
      fc=1;
      scene6color=255;
      recorder=millis();
    } 
    //println((width*(24*2+3)/48)-x);
    ////println((tx-1)+ty*20);
    switch(dir) {
    case 0:
      {
        float h=height/16;
        quad(x+h/4, y-h/16-att, x+h/8, y-h/4-att, x+h/4, y-h-att, x+h*3/8, y-h/4-att);
        rect(x+h/8, y-h/8, h/8, h/8, 100);

        drawmanVerti(x, y, width/24, height/16, foot);
        strokeWeight(height/16/32);
        line(x-h/64, y+h/8-h*7/16, x-h/32, y+h/8);
        line(x-h/32, y+h/8-h*7/16, x-h/16, y+h/8);
        line(x-h/16, y+h/8-h*7/16, x-h/8, y+h/8);
        line(x+h/64, y+h/8-h*7/16, x+h/32, y+h/8);
        line(x+h/32, y+h/8-h*7/16, x+h/16, y+h/8);
        line(x+h/16, y+h/8-h*7/16, x+h/8, y+h/8);
        break;
      }
    case 1:
      {
        float h=height/16;        
        strokeWeight(height/16/32);
        line(x-h/64, y+h/8-h*7/16, x-h/32, y+h/8);
        line(x-h/32, y+h/8-h*7/16, x-h/16, y+h/8);
        line(x-h/16, y+h/8-h*7/16, x-h/8, y+h/8);
        line(x+h/64, y+h/8-h*7/16, x+h/32, y+h/8);
        line(x+h/32, y+h/8-h*7/16, x+h/16, y+h/8);
        line(x+h/16, y+h/8-h*7/16, x+h/8, y+h/8);
        strokeWeight(1);
        drawmanVerti(x, y, width/24, height/16, foot);
        point(x-h/20, y-h*3/8);
        point(x+h/20, y-h*3/8);
        line(x-h/18, y-h*3/8+h/18, x+h/18, y-h*3/8+h/18);
        quad(x-h/4, y-h/16+att, x-h/8, y+h/4+att, x-h/4, y+h+att, x-h*3/8, y+h/4+att);
        rect(x-h/4, y-h/8, h/8, h/8, 100);
        break;
      }
    case 2:
      {
        float h=height/16;        
        strokeWeight(1);
        quad(x-att, y, x-h/8-att, y+h/8, x-h-att, y, x-h/8-att, y-h/8);
        drawmanHori(x, y, width/24, height/16, foot);
        line(x+h/32, y+h/8-h*7/16, x+h/16, y+h/8);
        line(x+h/16, y+h/8-h*7/16, x+h/8, y+h/8);
        line(x+h/12, y+h/8-h*7/16, x+h/6, y+h/8);
        line(x+h/8, y+h/8-h*7/16, x+h/4, y+h/8);
        point(x-h/20, y-h*3/8);
        break;
      }
    case 3:
      {
        float h=height/16;        
        strokeWeight(1);
        drawmanHori(x, y, width/24, height/16, foot);
        line(x-h/32, y+h/8-h*7/16, x-h/16, y+h/8);
        line(x-h/16, y+h/8-h*7/16, x-h/8, y+h/8);
        line(x-h/12, y+h/8-h*7/16, x-h/6, y+h/8);
        line(x-h/8, y+h/8-h*7/16, x-h/4, y+h/8);
        point(x+h/20, y-h*3/8);
        quad(x+att, y, x+h/8+att, y+h/8, x+h+att, y, x+h/8+att, y-h/8);
        break;
      }
    }
    n.x=this.x;
    n.y=this.y;
  }
  void movec(int a) {
    float ta=tx, tb=ty;
    move(a);
    //println(((int)((tx-1)+ty*20)));
    if (!s1arr.get((int)((tx-1)+ty*20)).canwalk()&&tx!=24)
    {
      tx=ta;
      ty=tb;
    }
  }
  void move(int a) {
    boolean c=true;
    if (a==0&&ty==0)
      c=false;
    if (a==1&&ty==13)
      c=false;
    if (a==2&&tx==1)
      c=false;
    if (a==3&&tx==20)
      c=false;
    //println((int)((tx-1)+ty*20));
    if (c) {
      //0 is up 3 is right
      switch(a) {
      case 0:
        {
          if (dir==0) {
            if (y-(height*((ty)*2+1)/32)<height/64) {
              ty--;
              dir=0;
              fc=1;
              movestatus=true;
            }
          }
          dir=0;
          break;
        }
      case 1:
        {
          if (dir==1) {
            if ((height*((ty)*2+1)/32)-y<height/64) {
              ty++;
              dir=1;
              fc=1;
              movestatus=true;
            }
          }
          dir=1;
          break;
        }
      case 2:
        {
          if (dir==2) {
            if (x-(width*(tx*2+3)/48)<width/96) {
              tx--;
              dir=2;
              fc=1;
              movestatus=true;
            }
          }
          dir=2;
          break;
        }
      case 3:
        {
          if (dir==3) {
            if ((width*(tx*2+3)/48)-x<width/96) {
              tx++;
              dir=3;
              fc=1;
              movestatus=true;
            }
          }
          dir=3;
          break;
        }
      }
    }
    switch(currentlevel) {
    case 0:
      {
        if (tx==20&&ty>=6&&ty<=9&&a==3)
        {
          cancontrol=false; 
          tx=24;
        }

        break;
      }
    case 1:
      {
        if (tx==20&&ty>=6&&ty<=9&&a==3&&l1)
        {
          cancontrol=false; 
          tx=24;
        }
        break;
      }
    case 3:
      {
        if (tx==20&&ty>=6&&ty<=9&&a==3&&l3)
        {
          cancontrol=false; 
          tx=24;
        }
        break;
      }
    case 4:
      {
        if (tx==20&&ty>=6&&ty<=9&&a==3&&l4)
        {
          cancontrol=false; 
          tx=24;
        }
        break;
      }
    case 6:
      {

        if (tx==20&&ty>=6&&ty<=8&&a==3)
        {
          cancontrol=false; 
          tx=24;
        }
        break;
      }
    }
  }
  void hit() {
    if (attc==false) {
      attc=true;
    }
  }
}