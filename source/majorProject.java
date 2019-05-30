import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 
import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class majorProject extends PApplet {

//Done by Yunyuan Yu(u6092441)
// Please help to take a screen shot :)
//displayname: Fishy
//use and modified code from https://processing.org/discourse/beta/num_1260921434.html to create fireball class
//use and modified code from https://www.openprocessing.org/sketch/28053# to create particle class
//image without comment are made by myself


Scene Sf0, Sf1, Sf2, Sf3, Sf4, Sf5, Sf6, Sf7, Sf8, Cover;

SoundFile file1, wind1, wind2, b1, kick, b2, lady, item, magic;
float wind1t, wind2t, b1t, b2t, ladyt;
boolean wind1c, wind2c, b1c, b2c, ladyc;
int difficultmut;
character main;
int currentlevel;
int gamestatus;
float main_speed;
int[] hitArr=new int[2];
ArrayList<peg> s1arr=new ArrayList<peg>();
ArrayList<npc> ghost=new ArrayList<npc>();
ArrayList<npc> s1npcarr=new ArrayList<npc>();
ArrayList<Fireball> Fireballs=new ArrayList<Fireball>();
int scene4counter;
item sword, cloth, item1, item2, item3, item4;
stone stone1, stone2, stone3, stone4, stone5, stone6, stone7;
npc boss1, boss2, npcfors7;
float recorder;
boolean l1, l2, l3, l4, l5, l6, l7;
boolean showins;
String showstr;
float showtime;
boolean injurc;
float injurt;
float injurttt;
boolean bosshc2;
float bossht2;
boolean bosshc;
float bossht;
float bosshs;
float bosshx, bosshy;
float injur;
float scene5x1, scene5x2;
float scene6color;
boolean boomc;
PImage boom;
float boomx, boomy, boomt;

int scene7status;
String[] aa;
float fbcd;
float s8i;
ControlP5 cp5;

ArrayList plist = new ArrayList();
int MAX = 100;

public void setup() {
  
  //size(800, 600);
  //Ghost's Lullaby by Robbero (c) copyright 2016 Licensed under a Creative Commons Attribution Noncommercial license. http://dig.ccmixter.org/files/Robbero/54904 
  file1 = new SoundFile(this, "Robbero_-_Ghost_s_Lullaby.mp3");
  //http://soundbible.com/ licensed under attribution 3.0
  wind1=new SoundFile(this, "Tornado.mp3");
  wind2=new SoundFile(this, "wind.mp3");
  b1=new SoundFile(this, "boss1.mp3");
  b2=new SoundFile(this, "boss2.mp3");
  lady=new SoundFile(this, "lady.mp3");
  kick=new SoundFile(this, "kick.mp3");
  item=new SoundFile(this, "item.mp3");
  magic=new SoundFile(this, "magic.mp3");
  difficultmut=1;
  //end
  file1.loop();
  gamestatus=0;
  currentlevel=-1;
  main_speed=5;
  main=new character();
  Cover=new Scene(-1);
  Sf0=new Scene(0);
  Sf1=new Scene(1);
  Sf2=new Scene(2);
  Sf3=new Scene(3);
  Sf4=new Scene(4);
  Sf5=new Scene(5);   
  Sf6=new Scene(6);   
  Sf7=new Scene(7);   
  Sf8=new Scene(8);   
  Cover=new Scene(-1);
  cp5 = new ControlP5(this);
  stone1=new stone("stone1", "Magic Stick of Temperance\nThe opposite of Gluttony", width/2-width*3/16, height*28/32+1, false);
  stone2=new stone("stone2", "Magic stick of Chastity\nThe opposite of Lust", width/2-width*1/16, height*28/32+1, false);
  stone3=new stone("stone3", "Magic stick of Kindness\nThe opposite of Envy", width/2+width*1/16, height*28/32+1, false);
  stone4=new stone("stone4", "Magic stick of Charity\nThe opposite of Greed", width/2+width*3/16, height*28/32+1, false);
  stone5=new stone("stone5", "Magic stick of Diligence\nThe opposite of Sloth", width/2-width*3/16, height*30/32, false);
  stone6=new stone("stone6", "Magic stick of Patience\nThe opposite of Wrath", width/2-width*1/16, height*30/32, false);
  stone7=new stone("stone7", "Magic stick of Humility\nThe opposite of Pride", width/2+width*1/16, height*30/32, false);
  boss1=new npc("boss", 15, 7, 500*difficultmut, 0, new String[]{}, "Lord Asmodeus");
  boss2=new npc("satan", 10, 2, 2000*difficultmut, 0, new String[]{}, "Satan");
  npcfors7=new npc("npc1", 1, 3, 0, 1, new String[]{"You already have 6 magic stick but the last one will be tough ........................................", "Now you can use the mouse to fire the fireball........................................ ", "but keep in mind the boss will also use fireball........................................ ", "try to dodge!........................................ "}, "The Last Whipser");
  s1npcarr.add(new npc("npc2", 1, 3, 0, 1, new String[]{"You are cursed..... you falled into the hell............................................", "#@%)(*!)(#*)@_)(........................................", 
    "there is no way to go........................................", "There are seven deadly sins in the hell........................................", "that's why you become a ghost........................................", "No one can help you........................................"}, "STATUE Luxuria "));
  s1npcarr.add(new npc("npc3", 4, 3, 0, 1, new String[]{"Lust, Gluttony, Greed, Sloth, Wrath, Envy, Pride........................................", "I can smell all those sin from you........................................", 
    "You have committed many sins........................................", "Now its time to pay.......................................... "}, "STATUE Gula "));
  s1npcarr.add(new npc("npc4", 7, 3, 0, 1, new String[]{"You think the ghost are all evil?............................................", "The truth is the source of the evil is you........................................", 
    "You need to get 7 magic stick to return the the ground........................................", "Or you will end up dying here like us forever..........................................."}, "STATUE Avaritia "));
  s1npcarr.add(new npc("npc5", 10, 3, 0, 1, new String[]{"The seven deadly sins are also contrary to the seven virtues........................................", 
    "Chastity: To be honest with oneself, one's family, one's friends, to all of humanity, and to all of God's creations.........................................", 
    "Temperance: proper moderation between self-interest, versus public-interest, and against the rights and needs of others........................................", 
    "Charity: Love, in the sense of an unlimited loving kindness towards all others........................................", 
    "Diligence : capability of not giving up", "Patience : Showing forgiveness and being merciful to criminals and sinners........................................", 
    "Kindness: Unselfish love and voluntary kindness without bias or spite........................................", "Humility :The courage of the heart necessary to undertake tasks which are difficult........................................"}, "STATUE Acedia "));
  s1npcarr.add(new npc("npc1", 13, 3, 0, 1, new String[]{"To start the journey you need to go the path on the right.........................................", "But I promise you will never make it........................................ "}, "STATUE Ira "));
  scene4counter=0;
  for (int i=0; i<6; i++) {
    npc t=new npc("ghost", (int)random(1, 20), (int)random(0, 13), 100, 2, null, "Asmodeus");
    ghost.add(t);
  }
  l1=false;
  l2=false;
  l3=false;
  l4=true;
  l5=false;
  l6=false;
  l7=false;
  aa=loadStrings("maze.txt");
  recorder=0;
  showins=false;
  showstr="";
  showtime=0;
  scene5x1=0;
  scene5x1=0;
  bosshc2=false;
  bossht2=0;
  bosshc=false;
  bossht=0;
  bosshs=0;
  injurc=false;
  injurt=0;
  injurttt=0;
  injur=0;
  scene6color=255;
  fbcd=0;
  bosshx=0;
  bosshy=0;
  wind1t=0;
  wind2t=0;
  b1t=0;
  b2t=0;
  ladyt=0;
  wind1c=false;
  wind2c=false;
  b1c=false;
  b2c=false;
  ladyc=false;
  //https://pixabay.com/en/explosion-pow-detonation-bomb-boom-153710/
  boom=loadImage("boom.png");
  boomc=false;
  boomt=0;
  boomx=0;
  boomy=0;
  s8i=0;
  scene7status=0;
  s1arr.clear();
  for (int q=0; q<14; q++)
    for (int i=1; i<=20; i++)
    {
      boolean tt;
      //println(aa[q].substring(i-1, i));
      if (aa[q].substring(i-1, i).equals("1"))
        tt=false;
      else tt=true;
      peg temp=new peg(i, q, 0, tt);
      s1arr.add(temp);
    }
  item1=new item("chest", width*9/24, height*5/8, "Damage increased:", 2, 8, 10);
  item2=new item("chest", width*11/24, height*5/8, "Damage increased:", 3, 10, 10);
  item3=new item("chest", width*13/24, height*5/8, "Damage increased:", 4, 12, 10);
  item4=new item("chest", width*15/24, height*5/8, "Damage increased:", 5, 14, 10);
  sword=new item("sword", width/16, height*29/32, "Damage:", 20, -1, -1);
  cloth=new item("cloth", width*3/16, height*29/32, "Defence:", 5, -1, -1);
}
public void mouseClicked() {
  if (currentlevel==-1) {
    currentlevel=0;
    file1.stop();
    wind2c=true;
    wind2.play();
  } else {
    if (mouseX>width*6/8&&mouseX<width*6/8+width*3/16&&mouseY>height*29/32&&mouseY<height*31/32)
      restart();
    //}
    //rect(width/8, height*5/8, width/4, height*3/16);
    //rect(width*5/8, height*5/8, width/4, height*3/16);
    if (currentlevel==2)
    {
      //if (mouseX>width/8&&mouseX<width/8+width/4&&mouseY>height*5/8&&mouseY<height*5/8+height*3/16)
      //{
      //} else
      if (mouseX>width*5/8&&mouseX<width*5/8+width/4&&mouseY>height*5/8&&mouseY<height*5/8+height*3/16)
      {
        main.x-=width/20;
      }
    } else if (currentlevel==7&&scene7status==1)
    {
      if (millis()-fbcd>1000) {
        magic.play();
        Fireball f=new Fireball(main.x, main.y, mouseX, mouseY, main.n);
        Fireballs.add(f);
        fbcd=millis();
      }
    } else {
      kick.play();
      fill(255, 0, 0);
      main.hit();
      if (hitArr[0]!=0) {

        boomc=true;
        boomt=millis();

        switch(main.dir) {
        case 0:
          {
            boomx=(main.tx+1)*width/24;
            boomy=(main.ty-1)*height/16;
            break;
          }
        case 1:
          {
            boomx=(main.tx+1)*width/24;
            boomy=(main.ty+1)*height/16;
            break;
          }
        case 2:
          {
            boomx=(main.tx)*width/24;
            boomy=(main.ty)*height/16;
            break;
          }
        case 3:
          {
            boomx=(main.tx+2)*width/24;
            boomy=(main.ty)*height/16;
            break;
          }
        }
        //ellipse((hitArr[0]+1)*width/24+ width/48, (hitArr[1])*height/16+height/32, width/24, height/16);
        switch(currentlevel) {
        case 1:
          {

            if (hitArr[0]>=boss1.tx&&hitArr[0]<boss1.tx+3&&hitArr[1]>=boss1.ty&&hitArr[1]<boss1.ty+3&&boss1.hp>0)
            {
              boss1.hp-=sword.value;
              //println(boss1.hp);
            }
            break;
          }
        case 3:
          {
            for (npc t : ghost) {
              if (hitArr[0]==t.tx&&hitArr[1]==t.ty&&t.hp>0)
              {
                t.hp-=sword.value;
              }
            }
            break;
          }
        case 7:
          {

            if (hitArr[0]>=boss2.tx&&hitArr[0]<boss2.tx+3&&hitArr[1]>=boss2.ty&&hitArr[1]<boss2.ty+3&&boss2.hp>0)
            {
              boss2.hp-=sword.value;
              //println(boss2.hp);
            }
            break;
          }
        }
      }
    }
  }
}
public void draw() {
  if (wind2c&&millis()-wind2t>wind2.duration()*1000)
  {
    wind2.play();
    wind2t=millis();
  }
  if (b1c&&millis()-b1t>b1.duration()*1000+2000)
  {
    b1.play();
    b1t=millis();
  }
  if (wind1c&&millis()-wind1t>wind1.duration()*1000/2)
  {
    wind1.play();
    wind1t=millis();
  }
  if (b2c&&millis()-b2t>b2.duration()*1000)
  {
    b2.play();
    b2t=millis();
  }
  if (ladyc&&millis()-ladyt>lady.duration()*1000)
  {
    lady.play();
    ladyt=millis();
  }


  if (main.n.hp<0)
  {

    restart();
    difficultmut/=2;
    showstr="You are defeated\nbut you got the chance to restart the journey";
    showins=true;
    showtime=millis();
  }

  switch(currentlevel) {
  case -1:
    {
      Cover.display();
      break;
    }
  case 0:
    {
      Sf0.display();
      break;
    }
  case 1:
    {
      Sf1.display();
      break;
    }
  case 2:
    {
      Sf2.display();
      break;
    }
  case 3:
    {
      Sf3.display();
      break;
    }
  case 4:
    {
      Sf4.display();
      break;
    }
  case 5:
    {
      Sf5.display();
      break;
    }
  case 6:
    {
      Sf6.display();
      break;
    }
  case 7:
    {
      Sf7.display();
      break;
    }
  case 8:
    {
      Sf8.display();
      break;
    }
  }
  if (currentlevel!=-1)
    main.drawit();
  if (showins) {  
    if (millis()-showtime>3000)
      showins=false;
    fill(255);
    stroke(0);
    strokeWeight(1);
    textAlign(CENTER, TOP);
    rect(width/4, height/4, width/2, height/2, 50);
    textSize(height/20);
    fill(0);
    text(showstr, width/4, height/4, width/2, height/2);
  }
  //println(main.n.hp);
  if (main.n.hp<500)
  { 
    fill(255, random(10, 40), random(10, 40));
    noStroke();
    rect(0, 0, width, height/32);
    rect(0, height-height/32, width, height/32);
    rect(0, 0, width/48, height);
    rect(width-width/48, 0, width/48, height);
  }
  if (millis()%500<50&&main.n.hp<1000)
    main.n.hp+=1;
  if (injurc) { 
    if (millis()-injurt>500)
      injurc=false;
    fill(255, injur, injur, 100-injurttt);
    noStroke();
    rect(0, 0, width, height/32+injurttt);
    rect(0, height-height/32-injurttt, width, height/32+injurttt);
    rect(0, 0, width/48+injurttt, height);
    rect(width-width/48-injurttt, 0, width/48+injurttt, height);

    injurttt+=1;
    //println(injurttt);
  }
  if (bosshc) { 
    if (millis()-bossht>300) {
      bosshc=false;
    }
    image(boom, bosshx, bosshy, height/16, height/16);
  }
  if (boomc) { 
    if (millis()-boomt>300) {
      boomc=false;
    }
    image(boom, boomx, boomy, height/16, height/16);
  }
}
public void keyPressed() {
  //if (key==' ') {
  //  //println("A");
  //  bosshc=true;
  //  bossht=millis();
  //  bosshx=width/2;
  //  bosshy=height/2;

  //}
 if(key == 'q'){
    println("taking screenshot...");
    save("screenshot.png");
  }
  if (main.cancontrol) {

    if (currentlevel==6) {
      if (key=='w') {
        main.movec(0);
      } else if (key=='a') {
        main.movec(2);
      } else if (key=='s') {
        main.movec(1);
      } else if (key=='d') {
        main.movec(3);
      } else {
        main.setmovestatus(false);
      }
    } else {
      if (key=='w') {
        main.move(0);
      } else if (key=='a') {
        main.move(2);
      } else if (key=='s') {
        main.move(1);
      } else if (key=='d') {
        main.move(3);
      } else {
        main.setmovestatus(false);
      }
    }
    if (key=='j'&&currentlevel!=-1) {

      kick.play();
      fill(255, 0, 0);
      main.hit();
      if (hitArr[0]!=0) {

        boomc=true;
        boomt=millis();

        switch(main.dir) {
        case 0:
          {
            boomx=(main.tx+1)*width/24;
            boomy=(main.ty-1)*height/16;
            break;
          }
        case 1:
          {
            boomx=(main.tx+1)*width/24;
            boomy=(main.ty+1)*height/16;
            break;
          }
        case 2:
          {
            boomx=(main.tx)*width/24;
            boomy=(main.ty)*height/16;
            break;
          }
        case 3:
          {
            boomx=(main.tx+2)*width/24;
            boomy=(main.ty)*height/16;
            break;
          }
        }
        //ellipse((hitArr[0]+1)*width/24+ width/48, (hitArr[1])*height/16+height/32, width/24, height/16);
        switch(currentlevel) {
        case 1:
          {

            if (hitArr[0]>=boss1.tx&&hitArr[0]<boss1.tx+3&&hitArr[1]>=boss1.ty&&hitArr[1]<boss1.ty+3&&boss1.hp>0)
            {
              boss1.hp-=sword.value;
            }
            break;
          }
        case 3:
          {
            for (npc t : ghost) {
              if (hitArr[0]==t.tx&&hitArr[1]==t.ty&&t.hp>0)
              {
                t.hp-=sword.value;
              }
            }
            break;
          }
        case 7:
          {

            if (hitArr[0]>=boss2.tx&&hitArr[0]<boss2.tx+3&&hitArr[1]>=boss2.ty&&hitArr[1]<boss2.ty+3&&boss2.hp>0)
            {
              boss2.hp-=sword.value;
              //println(boss2.hp);
            }
            break;
          }
        }
      }
    }
    if (key=='k'&&currentlevel!=-1) {
      getthit(main.dir, main.tx, main.ty);
      fill(0, 255, 0);
      //println(hitArr[0]);
      //println(hitArr[1]);
      if (hitArr[0]!=0) {
        //ellipse((hitArr[0]+1)*width/24+ width/48, (hitArr[1])*height/16+height/32, width/24, height/16);
        switch(currentlevel) {
        case 0:
          {
            for (npc n : s1npcarr) {
              if (hitArr[0]==n.tx&&hitArr[1]==n.ty)
              {
                n.startspeak();
              }
            }
            break;
          }
        case 4:
          {
            item1.getitem(hitArr[0], hitArr[1]);
            item2.getitem(hitArr[0], hitArr[1]);
            item3.getitem(hitArr[0], hitArr[1]);
            item4.getitem(hitArr[0], hitArr[1]);
            break;
          }
        case 7:
          {
            if (hitArr[0]==npcfors7.tx&&hitArr[1]==npcfors7.ty) {

              npcfors7.startspeak();
              if (npcfors7.word+1==npcfors7.talk.length)
              { 
                scene7status=1;
                recorder=millis();
              }
            }
          }
        }
      }
    }
  }
}

public void drawcontrol() {
  strokeWeight(1);
  stroke(0);
  fill(255, 229, 204);
  rect(0, height*7/8, width, height/8);
  if (mouseX>width*6/8&&mouseX<width*6/8+width*3/16&&mouseY>height*29/32&&mouseY<height*31/32)
    stroke(255, 0, 0);
  rect(width*6/8, height*29/32, width*3/16, height/16);
  stroke(0);
  fill(0);
  textAlign(CENTER, TOP);
  textSize(height/20);
  text("RESTART", width*6/8, height*29/32, width*3/16, height/16);
  drawstone();
}

public void drawstone() {
  stone1.drawitem();
  stone2.drawitem();
  stone3.drawitem();
  stone4.drawitem();
  stone5.drawitem();
  stone6.drawitem();
  stone7.drawitem();
}
public void stonemouseover() {
  stone1.mouseover();
  stone2.mouseover();
  stone3.mouseover();
  stone4.mouseover();
  stone5.mouseover();
  stone6.mouseover();
  stone7.mouseover();
}
public void restart()
{ 
  file1.stop(); 
  wind1.stop(); 
  wind2.stop(); 
  b1.stop(); 
  b2.stop(); 
  lady.stop(); 
  if (currentlevel==8)
  {
    difficultmut*=2;
  }
  file1.loop();
  gamestatus=0;
  currentlevel=0;
  main_speed=5;
  //main=new character();
  Cover=new Scene(-1);
  Sf0=new Scene(0);
  Sf1=new Scene(1);
  Sf2=new Scene(2);
  Sf3=new Scene(3);
  Sf4=new Scene(4);
  Sf5=new Scene(5);   
  Sf6=new Scene(6);   
  Sf7=new Scene(7);   
  Sf8=new Scene(8);   
  Cover=new Scene(-1);
  cp5 = new ControlP5(this);
  stone1=new stone("stone1", "Magic Stick of Temperance\nThe opposite of Gluttony", width/2-width*3/16, height*28/32+1, false);
  stone2=new stone("stone2", "Magic stick of Chastity\nThe opposite of Lust", width/2-width*1/16, height*28/32+1, false);
  stone3=new stone("stone3", "Magic stick of Kindness\nThe opposite of Envy", width/2+width*1/16, height*28/32+1, false);
  stone4=new stone("stone4", "Magic stick of Charity\nThe opposite of Greed", width/2+width*3/16, height*28/32+1, false);
  stone5=new stone("stone5", "Magic stick of Diligence\nThe opposite of Sloth", width/2-width*3/16, height*30/32, false);
  stone6=new stone("stone6", "Magic stick of Patience\nThe opposite of Wrath", width/2-width*1/16, height*30/32, false);
  stone7=new stone("stone7", "Magic stick of Humility\nThe opposite of Pride", width/2+width*1/16, height*30/32, false);
  boss1=new npc("boss", 15, 7, 500*difficultmut, 0, new String[]{}, "Lord Asmodeus");
  boss2=new npc("satan", 10, 2, 2000*difficultmut, 0, new String[]{}, "Satan");
  npcfors7=new npc("npc1", 1, 3, 0, 1, new String[]{"You already have 6 magic stick but the last one will be tough ........................................", "Now you can use the mouse to fire the fireball........................................ ", "but keep in mind the boss will also use fireball........................................ ", "try to dodge!........................................ "}, "The Last Whipser");
  s1npcarr.add(new npc("npc2", 1, 3, 0, 1, new String[]{"You are cursed..... you falled into the hell............................................", "#@%)(*!)(#*)@_)(........................................", 
    "there is no way to go........................................", "There are seven deadly sins in the hell........................................", "that's why you become a ghost........................................", "No one can help you........................................"}, "STATUE Luxuria "));
  s1npcarr.add(new npc("npc3", 4, 3, 0, 1, new String[]{"Lust, Gluttony, Greed, Sloth, Wrath, Envy, Pride........................................", "I can smell all those sin from you........................................", 
    "You have committed many sins........................................", "Now its time to pay.......................................... "}, "STATUE Gula "));
  s1npcarr.add(new npc("npc4", 7, 3, 0, 1, new String[]{"You think the ghost are all evil?............................................", "The truth is the source of the evil is you........................................", 
    "You need to get 7 magic stick to return the the ground........................................", "Or you will end up dying here like us forever..........................................."}, "STATUE Avaritia "));
  s1npcarr.add(new npc("npc5", 10, 3, 0, 1, new String[]{"The seven deadly sins are also contrary to the seven virtues........................................", 
    "Chastity: To be honest with oneself, one's family, one's friends, to all of humanity, and to all of God's creations.........................................", 
    "Temperance: proper moderation between self-interest, versus public-interest, and against the rights and needs of others........................................", 
    "Charity: Love, in the sense of an unlimited loving kindness towards all others........................................", 
    "Diligence : capability of not giving up", "Patience : Showing forgiveness and being merciful to criminals and sinners........................................", 
    "Kindness: Unselfish love and voluntary kindness without bias or spite........................................", "Humility :The courage of the heart necessary to undertake tasks which are difficult........................................"}, "STATUE Acedia "));
  s1npcarr.add(new npc("npc1", 13, 3, 0, 1, new String[]{"To start the journey you need to go the path on the right.........................................", "But I promise you will never make it........................................ "}, "STATUE Ira "));
  scene4counter=0;
  ghost.clear();
  for (int i=0; i<6; i++) {
    npc t=new npc("ghost", (int)random(1, 20), (int)random(0, 13), 100, 2, null, "Asmodeus");
    ghost.add(t);
  }
  l1=false;
  l2=false;
  l3=false;
  l4=true;
  l5=false;
  l6=false;
  l7=false;
  aa=loadStrings("maze.txt");
  recorder=0;
  showins=false;
  showstr="";
  showtime=0;
  scene5x1=0;
  scene5x1=0;
  bosshc2=false;
  bossht2=0;
  bosshc=false;
  bossht=0;
  bosshs=0;
  injurc=false;
  injurt=0;
  injurttt=0;
  injur=0;
  scene6color=255;
  fbcd=0;
  bosshx=0;
  bosshy=0;
  wind1t=0;
  wind2t=0;
  b1t=0;
  b2t=0;
  ladyt=0;
  wind1c=false;
  wind2c=false;
  b1c=false;
  b2c=false;
  ladyc=false;
  //https://pixabay.com/en/explosion-pow-detonation-bomb-boom-153710/
  boom=loadImage("boom.png");
  boomc=false;
  boomt=0;
  boomx=0;
  boomy=0;
  s8i=0;
  scene7status=0;
  s1arr.clear();
  for (int q=0; q<14; q++)
    for (int i=1; i<=20; i++)
    {
      boolean tt;
      //println(aa[q].substring(i-1, i));
      if (aa[q].substring(i-1, i).equals("1"))
        tt=false;
      else tt=true;
      peg temp=new peg(i, q, 0, tt);
      s1arr.add(temp);
    }
  item1=new item("chest", width*9/24, height*5/8, "Damage increased:", 2, 8, 10);
  item2=new item("chest", width*11/24, height*5/8, "Damage increased:", 3, 10, 10);
  item3=new item("chest", width*13/24, height*5/8, "Damage increased:", 4, 12, 10);
  item4=new item("chest", width*15/24, height*5/8, "Damage increased:", 5, 14, 10);
  //sword=new item("sword", width/16, height*29/32, "Damage:", 20, -1, -1);
  //cloth=new item("cloth", width*3/16, height*29/32, "Defence:", 5, -1, -1);
}
public void getthit(int c, float a, float b) {
  switch(c) {
  case 0:
    {
      hitArr[0]=(int)a;
      hitArr[1]=(int)b-1;
      break;
    }
  case 1:
    {
      hitArr[0]=(int)a;
      hitArr[1]=(int)b+1;
      break;
    }
  case 2:
    {
      hitArr[0]=(int)a-1;
      hitArr[1]=(int)b;
      break;
    }
  case 3:
    {
      hitArr[0]=(int)a+1;
      hitArr[1]=(int)b;
      break;
    }
  }
}
public void guess() {
  String temp = cp5.get(Textfield.class, "GuessText").getText();
  //println(temp.toLowerCase());
  //||temp.equals("a")
  if (temp.toLowerCase().equals("ghost don't kill, people does")||temp.toLowerCase().equals("ghost don't kill, people does")) {
    currentlevel=6;
    stone5.value=true;
    main.y=height*15/32;
    main. x=0;  
    main.tx=1;
    main. dir=3;
    main.ty=7;
    main.movestatus=true;
    main.cancontrol=false;
    main.fc=1;
    recorder=millis();
    showstr="Nice guess, hope the spirit will finds its home\nMagic stick of Diligence is earned\n And there is a maze in front of you";
    showins=true;
    showtime=millis();
  } else {
    showstr="That's no right!";
    showins=true;
    showtime=millis();
  }
}

//below code are modified from https://processing.org/discourse/beta/num_1260921434.html

class Fireball {

  float[][] fire = new float [100000][15];
  float currentflamef, nextflamef;
  int currentflame, nextflame;
  float x, y;
  boolean status;
  float stepx, stepy;
  int stepcounter;
  float colorr, colorg,colorb;
  float len;
  npc from;
  Fireball(float a, float b,float c) {
    currentflame=0;
    x=a;
    y=b;
    stepx=(main.x-this.x)/100;
    stepy=(main.y-this.y)/100;
    status=true;
    stepcounter=0;
    colorr=random(200, 255);//red
    colorg=random(50, 150);//green
    colorb=0;
    len=c;
  }
  Fireball(float a, float b, npc c) {
    currentflame=0;
    x=a;
    y=b;
    stepx=(main.x-this.x)/100;
    stepy=(main.y-this.y)/100;
    status=true;
    stepcounter=0;
    from=c;
    colorr=random(200, 255);//red
    colorg=random(50, 150);//green
    colorb=0;
  }
  Fireball(float a, float b, npc c, npc d) {
    currentflame=0;
    x=a;
    y=b;
    stepx=(c.x-this.x)/100;
    stepy=(c.y-this.y)/100;
    status=true;
    stepcounter=0;
    from=d;
    colorr=random(200, 255);//red
    colorg=random(50, 150);//green
    colorb=0;
  }
  Fireball(float a, float b, float c, float d, npc e) {
    currentflame=0;
    x=a;
    y=b;
    stepx=(c-this.x)/100;
    stepy=(d-this.y)/100;
    status=true;
    stepcounter=0;
    from=e;
    colorr=random(200, 255);//red
    colorg=random(50, 150);//green
    colorb=0;
  }

  public boolean checkhit(npc n) {
    //println(from.name);
    //println(n.name);
    if (!n.name.equals(from.name)&&status) {    
      //println(this.x+"_"+n.x);
      if (dist(this.x, this.y, n.x, n.y)<height/8) {
        status=false;
        n.hp-=100*difficultmut;
        println(n.name+":"+n.hp);
        return true;
      }
    }
    return false;
  }

  public void update_fire() {
    for (int flame=0; flame<100000; flame++) {
      if (fire[flame][0]==1) {

        if (get(PApplet.parseInt(fire[flame][1]), PApplet.parseInt(fire[flame][2]))>200) {
          fire[flame][0]=0;
        }
        fire[flame][1]=fire[flame][1]+fire[flame][5]*cos(fire[flame][3]);
        fire[flame][2]=fire[flame][2]+fire[flame][5]*sin(fire[flame][3]);
      }
      fire[flame][7]+=1;
      if (fire[flame][7]>fire[flame][6]) {
        fire[flame][0]=0;
      }
    }
  }
  public void draw_fire() {
    for (int flame=0; flame<currentflame; flame++) {
      if (fire[flame][0]==1) {
        noStroke();
        fill(colorr,colorg, colorb, 40);
        pushMatrix();
        translate(fire[flame][1], fire[flame][2]);
        rotate(fire[flame][8]);
        rect(0, 0, fire[flame][4], fire[flame][4]);
        popMatrix();
      }
    }
  }
  public void create_fire(float a, float b) {
    nextflame=currentflame+10;
    for (int flame=currentflame; flame<nextflame; flame++) {
      fire[flame][0]=1;
      fire[flame][1]=a;
      fire[flame][2]=b;
      fire[flame][3]=random(0, PI*2);//angle
      fire[flame][4]=random(5, 15);//size
      fire[flame][5]=random(.5f, 1);//speed
      fire[flame][6]=random(5, 20)/fire[flame][5];//maxlife
      fire[flame][7]=0;//currentlife
      fire[flame][8]=random(0, TWO_PI);
      fire[flame][9]=random(200, 255);//red
      fire[flame][10]=random(50, 150);//green
    }
    currentflame=nextflame;
  }
}
class item {
  PImage img;
  message desc;
  String des;
  float x, y;
  float tx, ty;
  float value;
  boolean status;
  item(String name, float a, float b, String c, float d, float e, float f) {
    img = loadImage(name+".png");
    desc=new message(c+d);
    des=c;
    x=a;
    y=b;
    value=d;
    status=true;
    tx=e;
    ty=f;
  }
  public void drawitem(float a, float b) {
    tint(255,255);
    if (status)
      image(img, a, b, height/16, height/16);
  }
  public void mouseover() {
    //println(mouseX);
    //ellipse(mouseX,mouseY,100,100);
    if (mouseX>x&&mouseX<x+height/16&&mouseY>y&&mouseY<y+height/16) {
      //println("A");
      //println(des+value);
      desc.drawBox(mouseX, mouseY, width-200, 200, 1, 0);
    } else {
      desc=new message(des+value);
    }
  }
  public void getitem(int a, int b) {
    if (a==tx&&b==ty) {
      item.play();
      sword.value+=this.value;
      status=false;
      scene4counter++;
    }
  }
}
//Copyright Jonathan Fraser 2011
//Free to use for non-commercial purposes
//https://www.openprocessing.org/sketch/28053#
//modified by Yunyuan
class Particle {
  float r = 2;
  PVector pos,speed,grav; 
  ArrayList tail;
  float splash = 5;
  int margin = 2;
  int taillength = 25;

  Particle(float tempx, float tempy) {
    float startx = tempx + random(-splash,splash);
    float starty = tempy + random(-splash,splash);
    startx = constrain(startx,0,width);
    starty = constrain(starty,0,height*7/8);
    float xspeed = random(-3,3);
    float yspeed = random(-3,3);

    pos = new PVector(startx,starty);
    speed = new PVector(xspeed,yspeed);
    grav = new PVector(0,0.02f);
    
    tail = new ArrayList();
  }

  public void run() {
    pos.add(speed);

    tail.add(new PVector(pos.x,pos.y,0));
    if(tail.size() > taillength) {
      tail.remove(0);
    }

    float damping = random(-0.5f,-0.6f);
    if(pos.x > width - margin || pos.x < margin) {
      speed.x *= damping;
    }
    if(pos.y > height*7/8 -margin) {
      speed.y *= damping;
    }
  }

  public void gravity() {
    speed.add(grav);
  }

  public void update() {
    for (int i = 0; i < tail.size(); i++) {
      PVector tempv = (PVector)tail.get(i);
      noStroke();
      fill(6*i + 50);
      ellipse(tempv.x,tempv.y,r,r);
    }
  }
}
class peg {
  float x, y, tx, ty;
  int type;
  boolean canwalk;
  peg(float a, float b, int c,boolean d) {
    tx=a;
    ty=b;
    x=width/12+(a-1)*width/24;
    y=b*height/16;
    type=c;
    canwalk=d;
  }
  public void drawpeg() {

    rect(x, y, width/24+1, height/16+1);
  }
  public boolean canwalk(){
    return canwalk;
  }
}
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

  public void display() {
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
        s8i+=.5f;
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
class stone {
  PImage img;
  message desc;
  String des;
  float x, y;
  boolean value;
  stone(String name, String d, float a, float b, boolean c) {
    img = loadImage(name+".png");
    desc=new message(d);
    des=d;
    x=a;
    y=b;
    value=c;
  }
  public void drawitem() {
    if (value){
      image(img, x,y, height/16, height/16);
    }
  }
  public void mouseover() {
    if (mouseX>x&&mouseX<x+height/16&&mouseY>y&&mouseY<y+height/16&&value) {
      desc.drawBox(mouseX, mouseY, width-200, 200, 1,0);
    } else {
      desc=new message(des);
    }
  }
}
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
  public void setmovestatus(boolean a) {
    movestatus=a;
  }
  public void drawmanVerti(float x, float y, float w, float h, float foot) {
    strokeWeight(1);
    fill(255);
    ellipse(x, y-h*3/8, h/4, h/4);
    rect(x-h*5/32, y+h/16, h/7, h*7/16+foot, 100);
    rect(x+h/64, y+h/16, h/7, h*7/16-foot, 100);
    rect(x-h*3/16, y-h/4, h*3/8, h*3/8, 100);
  }
  public void drawmanHori(float x, float y, float w, float h, float foot) {
    strokeWeight(1);
    fill(255);
    ellipse(x, y-h*3/8, h/4, h/4);
    rect(x-h*5/32+foot/2, y+h/16, h/7, h*7/16, 100);
    rect(x+h/64-foot/2, y+h/16, h/7, h*7/16, 100);
    rect(x-h*3/16, y-h/4, h*3/8, h*3/8, 100);
  }
  public void drawit() {
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
  public void movec(int a) {
    float ta=tx, tb=ty;
    move(a);
    //println(((int)((tx-1)+ty*20)));
    if (!s1arr.get((int)((tx-1)+ty*20)).canwalk()&&tx!=24)
    {
      tx=ta;
      ty=tb;
    }
  }
  public void move(int a) {
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
  public void hit() {
    if (attc==false) {
      attc=true;
    }
  }
}

//originally from benStory example
//modified
class message {
  String boxText;
  int charCounter;
  int displayCounter;

  message(String boxText) {
    charCounter = 0;
    displayCounter = 0;
    this.boxText = boxText;
  }
  public void drawBox(float x, float y, float width, float height, int wordRate,float c) {
    // if you want a "background box", put the drawing code here
    // set text colour and size
    //fill(255);
    //rect(x,y,width,height);
    textAlign(LEFT,TOP);
    fill(0);
        stroke(c);
    // draw the text (one char at a time)
    //println(boxText.substring(0, charCounter));
    textSize(height/8);
    text(boxText.substring(0, charCounter), x, y-width/30, width, height);
    if (displayCounter % wordRate == 0 && charCounter < boxText.length()) {
      charCounter++;
    }
    displayCounter++;
  }

  public boolean isDone() {
    return charCounter >= boxText.length();
  }
}
class npc {
  PImage img;
  float x, y, tx, ty;
  int hp;
  String[] talk;
  int type;
  String name;
  message desc;
  boolean ss;
  int word;
  message temp; 
  //0 is boss 1 is npc 2 is ghost
  npc(String na, float a, float b, int c, int d, String[] e, String f) {
    if (na!=null)
      img = loadImage(na+".png");
    x=width*(a*2+3)/48;
    y=height*(b*2+1)/32;
    tx=a;
    ty=b;
    hp=c;
    type=d;
    talk=e;
    name=f;
    word=0;
    ss=false;
    desc=new message(name+" HP:"+hp);
  }
  public void startspeak() {
    if(ss&&word<talk.length-1)
      word++;
    item.play();
    ss=true;
    temp =new message(talk[word]);
  }
  public void speak() {
    if (ss)
    {
      temp.drawBox(width/12, height/16, width-width/6, 200, 3, 0);
      if (temp.isDone()) {
        ss=false;
        word++;
        if (word==talk.length)
          word=0;
      }
    }
  }
  public void reset(String name, float a, float b, int c) {
    img = loadImage(name+".png");
    x=width*(a*2+3)/48;
    y=height*(b*2+1)/32;
    tx=a;
    ty=b;
    hp=c;
  }
  public void drawshack(float size) {

    //println(tx);
    image(img, x+random(-5, 5), y+random(-5, 5), size, size);
  }
  public void drawitem() {
    //println(x);
    //println(width*(tx*2+3)/48);
    //println(tx);
    //println();
    if (x-(width*(tx*2+3)/48)>4)
      x-=main_speed;
    else if (x-(width*(tx*2+3)/48)<-4)
      x+=main_speed;

    if (y-(height*(ty*2+1)/32)>4)
      y-=main_speed;
    else if (y-(height*(ty*2+1)/32)<-4)
      y+=main_speed;
    if (img!=null) {
      if (type==0)
        image(img, x+1, y, height/8, height/8);
      else   image(img, x-width/48+1, y-height/32, width/24-1, height/16-1);
    }
  }
  public void move() {
    int r1=(int)random(-2, 2);
    int r2=(int)random(-2, 2);
    if (tx+r1>=1&&tx+r1<=17)
      tx+=r1;
    if (ty+r2>=0&&ty+r2<=10)
      ty+=r2;
  }
  public void bossfireball() {
    Fireball f=new Fireball(x, y, this);
    f.colorb=255;
    f.colorr=50;
    f.colorg=150;
    Fireballs.add(f);
    magic.play();
  }
  public void bossswing() {
    fill(255, 0, 0);
    stroke(255, 0, 0);
    if (main.x<this.x)
      curve(x, y, x-height/32, y+height/32, x-height/32, y+height*3/32, x, y+height/8);
    else
      curve(x+width/16, y, x+width/16+height/32, y+height/32, x+width/16+height/32, y+height*3/32, x+width/16, y+height/8);
  }
  public void swinghit() {
    if (main.tx>this.tx-1&&main.tx<this.tx+5&&main.ty>=this.ty&&main.ty<this.ty+4) {
      main.n.hp-=5*difficultmut;
      injurttt=0;
      injurc=true;
      injur=200;
      injurt=millis();
    }
  }
  public void mouseover() {
    if (mouseX>x-height/16&&mouseX<x+height/16&&mouseY>y-height/16&&mouseY<y+height/16) {
      desc.drawBox(mouseX, mouseY, width-200, 200, 1, 0);
    } else {
      desc=new message(name+" HP:"+hp);
    }
  }
  public void bigmouseover() {
    if (hp>0) {
      if (mouseX>x&&mouseX<x+height/8&&mouseY>y&&mouseY<y+height/8) {
        desc.drawBox(mouseX, mouseY, width-200, 200, 1, 0);
      } else {
        desc=new message(name+" HP:"+hp);
      }
    }
  }
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "majorProject" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
