//Done by Yunyuan Yu(u6092441)
// Please help to take a screen shot :)
//displayname: Fishy
//use and modified code from https://processing.org/discourse/beta/num_1260921434.html to create fireball class
//use and modified code from https://www.openprocessing.org/sketch/28053# to create particle class
//image without comment are made by myself


Scene Sf0, Sf1, Sf2, Sf3, Sf4, Sf5, Sf6, Sf7, Sf8, Cover;
import processing.sound.*;
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
import controlP5.*;
int scene7status;
String[] aa;
float fbcd;
float s8i;
ControlP5 cp5;

ArrayList plist = new ArrayList();
int MAX = 100;

void setup() {
  fullScreen();
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
void mouseClicked() {
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
void draw() {
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
void keyPressed() {
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

void drawcontrol() {
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

void drawstone() {
  stone1.drawitem();
  stone2.drawitem();
  stone3.drawitem();
  stone4.drawitem();
  stone5.drawitem();
  stone6.drawitem();
  stone7.drawitem();
}
void stonemouseover() {
  stone1.mouseover();
  stone2.mouseover();
  stone3.mouseover();
  stone4.mouseover();
  stone5.mouseover();
  stone6.mouseover();
  stone7.mouseover();
}
void restart()
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
void getthit(int c, float a, float b) {
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
void guess() {
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