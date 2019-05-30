class Scene {
  int level;

  //https://pixabay.com/
  // free of copyrights under Creative Commons CC0
  PImage cover1=loadImage("cover1.png");
  PImage s5img=loadImage("dead.png");
  PImage s2img=loadImage("house.png");

  //end
  PImage s5img1=loadImage("glass1.png");
  PImage s5img2=loadImage("glass2.png");
  PImage s2img2=loadImage("road.png");
  message s1m=new message("The ground is shacking, no matter what kind of creature comes out, I have to fight it to get the magic stick!");
  message s3m=new message("There are so many hateful spirits, my heart tell me I should help to free them!");
  Scene(int a) {
    level=a;
  }

  void display() {
    switch(level) {
    case -1:
      {
        textAlign(CENTER, TOP);
        textSize(height/10);
        text("Redemption", width/2, height/8, width/2, height);
        textSize(height/20);
        text("click to start", width/2, height/2, width/2, height);
        image(cover1, 0, 0, width/2, height);
        break;
      }
    case 0:
      {
        background(255);
        fill(0);
        strokeWeight(1);
        line(width/12, 0, width/12, height);
        line(width*11/12, 0, width*11/12, height*3/8);
        line(width*11/12, height*7/8, width*11/12, height*5/8);
        line(width*11/12, height*3/8, width, height*3/8);
        line(width*11/12, height*5/8, width, height*5/8);

        drawcontrol();
        sword.drawitem(width/16, height*29/32);
        cloth.drawitem(width*3/16, height*29/32);
        sword.mouseover();
        cloth.mouseover();
        main.n.mouseover();
        stonemouseover();
        for (npc n : s1npcarr) {
          n.drawitem();
          n.speak();
        }
        for (npc n : s1npcarr) {
          n.mouseover();
        }
        textSize(height/32);
        textAlign(CENTER, CENTER);
        text("To control yourself as a ghost(in the middle of the screen):\nyou can use w,a,s,d, to move up,left,down,right\n'j' to attack and 'k' to interact with friendly Non-Player Character(NPC) and chest\nThere are 5 friendly NPC above you right now, try to interact.\nmouseover NPC to see the description\nHP stands for Hit Point", width/8, height*3/8, width*6/8, height/2);
        fill(0, 0, 0, scene6color);
        rect(0, 0, width, height);
        if (scene6color>-1)
          scene6color-=1;
        break;
      }
    case 1:
      {
        main_speed=5;
        background(255);
        drawcontrol();
        fill(0);
        strokeWeight(1);
        line(width/12, 0, width/12, height*3/8);
        line(width/12, height*7/8, width/12, height*5/8);
        line(width*11/12, 0, width*11/12, height*3/8);
        line(width*11/12, height*7/8, width*11/12, height*5/8);
        line(width/12, height*3/8, 0, height*3/8);
        line(width/12, height*5/8, 0, height*5/8);
        line(width*11/12, height*3/8, width, height*3/8);
        line(width*11/12, height*5/8, width, height*5/8);
        sword.drawitem(width/16, height*29/32);
        cloth.drawitem(width*3/16, height*29/32);
        sword.mouseover();
        cloth.mouseover();
        main.n.mouseover();
        stonemouseover();
        fill(255);
        strokeWeight(1);

        if (!l1) {
          if (millis()-recorder<6000) {
          } else if (millis()-recorder<8000)
            boss1.drawshack(height/8);
          else {
            boss1.drawitem();
            if ((millis()-recorder)%2000<100) {
              bosshc2=true;
              bossht2=millis();
            }
            if (bosshc2) {
              boss1.bossswing();
              boss1.swinghit();
              if (millis()-bossht2>250)
              {
                bosshc2=false;
              }
            }
          }

          if ((millis()-recorder)%4000<200)
            boss1.move();
        }

        if (boss1.hp<=0) {
          b1c=false;
          b1.stop();
          stone1.value=true;
          boss1.reset("boss", 15, 7, 500);
          if (!l1) {
            showstr="You deafeated Lord Asmodeus!\n You have earned youself a magic stick of Charity\ncontinue to the right";
            showins=true;
            showtime=millis();
          }
          l1=true;
          //delay(2000);
          //rect(width/4, height/4, width/2, width/2);
          //delay(2000);
          //background(255);
          //delay(2000);
          //recorder=millis();
        }        
        boss1.bigmouseover();
        s1m.drawBox(width/12, height/16, width-width/6, 200, 3, 0);
        //fill(100);
        //textSize(height/32);
        //textAlign(CENTER,TOP);
        //text(" There is something under the ground\n it sounds so big..........",width/8,height/2,width*3/4,width*3/8);
        fill(0, 0, 0, scene6color);
        rect(0, 0, width, height);
        if (scene6color>-1)
          scene6color-=1;
        break;
      }
    case 2:
      {

        background(0);
        drawcontrol();
        stroke(255);
        strokeWeight(1);
        image(s2img, width*3/4, height/4, height/4, height/4);

        image(s2img2, width/8, height/4, height/4, height/4);
        line(width/12, 0, width/12, height*7/8);
        line(width/12, height*7/8, width/12, height*5/8);
        line(width*11/12, 0, width*11/12, height*7/8);
        sword.drawitem(width/16, height*29/32);
        cloth.drawitem(width*3/16, height*29/32);
        sword.mouseover();
        cloth.mouseover();
        main.n.mouseover();
        stonemouseover();
        fill(255);
        stroke(0);
        textSize(height/32);
        text("There is a brothel, I couldn't control myself to walk away from that", width/8, height*5/8, width/4, height*5/8);
        //rect(width/8, height*5/8, width/4, height*3/16);
        rect(width*5/8, height*5/8, width/4, height*3/16);
        main.tx=24;
        main_speed=1;
        fill(0);
        textAlign(CENTER, CENTER);
        //text("Go brothel for double damage and defence", width/8, height*5/8, width/4, height*3/16);
        text("Fight yourself! Walk away from that brothel!!!\n spam click here!!", width*5/8, height*5/8, width/4, height*3/16);

        if (main.x>width*3/4)
        {
          ladyc=false;
          lady.stop();
          stone1.value=false;
          if (l1) {
            showstr="Stone of Charity is lost because you made a wrong choice! \nAsmodeus is out again!";
            showins=true;
            showtime=millis();
            b1c=true;
          }
          l1=false;
          currentlevel=1;
          main.x=width*23/48;
          main.y=height*15/32;
          main.tx=10;
          main.ty=7;
          main.dir=3;
          main.movestatus=false;
          main.cancontrol=true;
          main.fc=0;
          recorder=millis();
        }
        if (main.x<width/4)
        {
          ladyc=false;
          lady.stop();
          if (!l2) {
            showstr="It's a wise choice!\nYou earned yourself a magic stick of Chastity!";
            showins=true;
            showtime=millis();
            wind1c=true;
          }
          l2=true;
          stone2.value=true;
          main_speed=5;
          currentlevel=3;
          //main.x=width*23/48;
          //main.y=height*15/32;
          main.tx=10;
          main.ty=7;
          main.dir=3;
          main.movestatus=false;
          main.cancontrol=true;
          main.fc=0;
          recorder=millis();
        }
        fill(0, 0, 0, scene6color);
        rect(0, 0, width, height);
        if (scene6color>-1)
          scene6color-=1;
        break;
      }
    case 3:
      {     
        background(255);
        drawcontrol();
        fill(0);
        strokeWeight(1);
        line(width/12, 0, width/12, height*7/8);
        line(width*11/12, 0, width*11/12, height*3/8);
        line(width*11/12, height*7/8, width*11/12, height*5/8);
        line(width*11/12, height*3/8, width, height*3/8);
        line(width*11/12, height*5/8, width, height*5/8);
        sword.drawitem(width/16, height*29/32);
        cloth.drawitem(width*3/16, height*29/32);
        sword.mouseover();
        cloth.mouseover();
        main.n.mouseover();
        stonemouseover();
        ////////temp
        fill(255);
        //for (peg p : s1arr)
        //{
        //  p.drawpeg();
        //}
        strokeWeight(1);
        //for (peg p : s1arr)
        //{
        //  p.drawpeg();
        //}

        if (!l3) {
          if (millis()-recorder<6000) {
          } else if (millis()-recorder<8000)
          {
            for (npc t : ghost)
              t.drawshack(height/16);
          } else {
            for (npc t : ghost) {
              //println(t.hp);
              if (t.hp>0) {
                t.drawitem();
                t.mouseover();
              }
            }
          }
          if (millis()%1000<50)
            for (npc t : ghost) {
              int tint=(int)random(0, 2);
              if (tint==1)
                t.move();
            }
        }
        boolean checker=true;
        for (npc t : ghost)
        {
          if (t.hp>0)
            checker=false;
        }
        if (checker) {
          stone3.value=true;
          if (!l3) {
            showstr="You have free all the ghosts!\n you have earned yourself a magic stick of Kindness\n proceed to the right";
            showins=true;
            showtime=millis();
            wind1c=false;
            wind1.stop();
          }
          l3=true; 
          //delay(2000);
          //rect(width/4, height/4, width/2, width/2);
          //delay(2000);
          //background(255);
          //delay(2000);
          //recorder=millis();
        }
        s3m.drawBox(width/12, height/16, width-width/6, 200, 3, 0);
        fill(0, 0, 0, scene6color);
        rect(0, 0, width, height);
        if (scene6color>-1)
          scene6color-=1;
        break;
      }
    case 4:
      { 
        background(200-scene4counter*40);
        drawcontrol();
        stroke(255);
        strokeWeight(1);
        line(width/12, 0, width/12, height*3/8);
        line(width/12, height*7/8, width/12, height*5/8);
        line(width*11/12, 0, width*11/12, height*3/8);
        line(width*11/12, height*7/8, width*11/12, height*5/8);
        line(width/12, height*3/8, 0, height*3/8);
        line(width/12, height*5/8, 0, height*5/8);
        line(width*11/12, height*3/8, width, height*3/8);
        line(width*11/12, height*5/8, width, height*5/8);
        sword.drawitem(width/16, height*29/32);
        cloth.drawitem(width*3/16, height*29/32);
        sword.mouseover();
        cloth.mouseover();
        main.n.mouseover();
        stonemouseover();
        fill(255);
        stroke(0);
        rect(width/2-width/64, height/4, width/32, height/4);
        rect(width/2-width/4, height/8, width/2, height/4);
        fill(0);
        textAlign(CENTER, CENTER);
        textSize(height/32);
        text("Treasure on the graves, You can take whatever you want, but a man should only take one treasure", width/2-width/4, height/8, width/2, height/4);
        item1.mouseover();
        item2.mouseover();
        item3.mouseover();
        item4.mouseover();
        item1.drawitem(width*9/24, height*5/8);
        item2.drawitem(width*11/24, height*5/8);
        item3.drawitem(width*13/24, height*5/8);
        item4.drawitem(width*15/24, height*5/8);
        //println(scene4counter);
        fill(0, 0, 0, scene6color);
        rect(0, 0, width, height);
        if (scene6color>-1)
          scene6color-=1;
        break;
      }
    case 5:
      { 
        background(255);
        drawcontrol();
        stroke(0);
        strokeWeight(1);
        sword.drawitem(width/16, height*29/32);
        cloth.drawitem(width*3/16, height*29/32);
        sword.mouseover();
        cloth.mouseover();
        main.n.mouseover();
        stonemouseover();

        textAlign(CENTER, CENTER);
        tint(255, 255);
        //https://pixabay.com/
        image(s5img, width/2, height/2, width/4, height/4);

        textSize(height/30);
        text("There is a poor lost spirit over there, can you guess what he is trying to said with his last breath? (the pieces are draggable)", width/8, height/2, width*3/8, height/4);
        if (mousePressed)
        {
          if (mouseX>width/16+scene5x1&&mouseX<width/16+scene5x1+width*6/16&&mouseY>height/16&&mouseY<height*5/16)
          {
            if ( scene5x1+mouseX-pmouseX>0)
              scene5x1+=mouseX-pmouseX;
          } else if (mouseX>width*9/16-scene5x2&&mouseX<width*9/16-scene5x2+width*6/16&&mouseY>height/16&&mouseY<height*5/16)
          {
            if (scene5x2+pmouseX-mouseX>0)
              scene5x2+=pmouseX-mouseX;
          }
        }
        //powerpint
        tint(255, 100);
        image(s5img1, width/16+scene5x1, height/16, width*6/16, height/4);
        //text("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", width/16+scene5x1, height/16, width*6/16, height/4);
        image(s5img2, width*9/16-scene5x2, height/16, width*6/16, height/4);
        //text("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", width*9/16-scene5x2, height/16, width*6/16, height/4);

        //fill(0, 0, 0, scene6color);
        //rect(0, 0, width, height);
        //if (scene6color>-1)
        //  scene6color-=1;
        break;
      } 
    case 6:
      { 
        background(255);
        cp5.remove("GuessText");
        cp5.remove("guess");
        drawcontrol();
        stroke(0);
        strokeWeight(1);
        fill(0);
        line(width/12, 0, width/12, height*7/8);
        line(width*11/12, 0, width*11/12, height*3/8);
        line(width*11/12, height*7/8, width*11/12, height*4/8);
        fill(0, 153, 0);
        //rect(width*11/12, height*3/8, width/12, height/8);
        beginShape();
        vertex(width*11/12+width/24, height*3/8+height/32);
        vertex(width*11/12+1, height*3/8+height/32);
        vertex(width*11/12+1, height*3/8+height*3/32);
        vertex(width*11/12+width/24, height*3/8+height*3/32);
        vertex(width*11/12+width/24, height*3/8+height/8);
        vertex(width, height*3/8+height/16);
        vertex(width*11/12+width/24, height*3/8);
        vertex(width*11/12+width/24, height*3/8+height/32);
        endShape();
        fill(255);
        for (peg p : s1arr)
        {
          noStroke();
          if (p.canwalk())
            fill(255);
          else fill(0);
          if (main.tx<p.tx-2||main.tx>p.tx+2||main.ty<p.ty-2||main.ty>p.ty+2)
            fill(128, 128, 128);
          p.drawpeg();
        }
        strokeWeight(1);
        sword.drawitem(width/16, height*29/32);
        cloth.drawitem(width*3/16, height*29/32);
        sword.mouseover();
        cloth.mouseover();
        main.n.mouseover();
        stonemouseover();
        fill(0, 0, 0, scene6color);
        rect(0, 0, width, height);
        if (scene6color>-1)
          scene6color-=1;
        break;
      }
    case 7:
      { 
        background(255);
        drawcontrol();
        stroke(0);
        strokeWeight(1);
        fill(0);
        sword.drawitem(width/16, height*29/32);
        cloth.drawitem(width*3/16, height*29/32);
        sword.mouseover();
        cloth.mouseover();
        main.n.mouseover();
        stonemouseover();
        npcfors7.mouseover();
        boss2.bigmouseover();
        //scene7status=1;

        npcfors7.speak();
        npcfors7.drawitem();
        if (scene7status==0) {
        } else {
          for (Fireball f : Fireballs)
          {

            if (f.status) {
              f.create_fire(f.x, f.y);
              f.update_fire();
              f.draw_fire();
              f.x+=f.stepx;
              f.y+=f.stepy;
              f.stepcounter++;
              if (f.stepcounter==100)
                f.status=false;
              if (f.checkhit(boss2))
              {
                bossht=millis();
                bosshc=true;
                bosshx=boss2.x;
                bosshy=boss2.y;
              }


              main.n.x=main.x;
              main.n.y=main.y;
              if (f.checkhit(main.n))
              {     
                injurttt=0;
                injurc=true;
                injur=200;
                injurt=millis();
              }
            }
          }
          //println(recorder);
          if (!l7) {
            if (millis()-recorder<6000) {
            } else if (millis()-recorder<8000)
              boss2.drawshack(height/8);
            else {
              boss2.drawitem();
              if (millis()%3000<50)
                boss2.bossfireball();
            }

            if ((millis()-recorder)%4000<50)
              boss2.move();
          }

          if (boss2.hp<=0) {
            b2c=false;
            b2.stop();
            file1.loop();
            stone7.value=true;
            currentlevel=8;
            boss2.reset("satan", 15, 7, 1000);
            if (!l7) {
              showstr="Satan defeated! You got all the seven magic stick!";
              showins=true;
              showtime=millis();
            }
            l7=true;
            //delay(2000);
            //rect(width/4, height/4, width/2, width/2);
            //delay(2000);
            //background(255);
            //delay(2000);
            //recorder=millis();
          }
        }
        break;
      }
    case 8:
      {
        background(255);

        for (int i = 0; i < plist.size(); i++) {
          Particle p = (Particle) plist.get(i); 
          //makes p a particle equivalent to ith particle in ArrayList
          p.run();
          p.update();
          p.gravity();
        }
        if (millis()%2000<50)
        { 
          float tta=random(width);
          float ttb=random(height);
          for (int i = 0; i < MAX; i ++) {
            plist.add(new Particle(tta, ttb)); // fill ArrayList with particles

            if (plist.size() > 5*MAX) {
              plist.remove(0);
            }
          }
        } 
        fill(0);
        textSize(height/32);
        textAlign(CENTER, TOP);
        text("Your journey has end, you have made it to become a man\n The seven virtues-sin:\n Chastity-Lust\nTemperance-Gluttony\nCharity-Greed\nDiligence-Sloth\nPatience-Wrath\nKindness-Envy\nHumility-Pride", width/8, height*3/4-s8i, width*6/8, height*6/8);
        text("As a Christian theological foundation, redemption refers to the deliverance of Christians from sin. It assumes an important position in salvation because the transgressions in question form part of a great system against which human power is helpless. In Christian theology, redemption is an element of salvation that broadly means the deliverance from sin. Leon Morris says that \"Paul uses the concept of redemption primarily to speak of the saving significance of the death of Christ.\"[26] In the New Testament, the redemption word group is used to refer both to deliverance from sin and freedom from captivity.[27] In Christian theology, redemption is a metaphor for what is achieved through the Atonement;therefore, there is a metaphorical sense in which the death of Jesus pays the price of a ransom, releasing Christians from bondage to sin and death. Most evangelical theologians and Protestant denominations, however, reject Origen's argument that God paid the ransom price of redemption to Satan.\n\n\n\\n Done By Yunyuan Yu(u6092441)\n Thank you!", width/8, height*5/4-s8i, width*6/8, height*6/8);
        s8i+=.5;
        drawcontrol();
        sword.drawitem(width/16, height*29/32);
        cloth.drawitem(width*3/16, height*29/32);
        sword.mouseover();
        cloth.mouseover();
        main.n.mouseover();
        stonemouseover(); 
        break;
      }
    }
  }
}