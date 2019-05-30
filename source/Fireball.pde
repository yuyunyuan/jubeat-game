
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

  boolean checkhit(npc n) {
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

  void update_fire() {
    for (int flame=0; flame<100000; flame++) {
      if (fire[flame][0]==1) {

        if (get(int(fire[flame][1]), int(fire[flame][2]))>200) {
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
  void draw_fire() {
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
  void create_fire(float a, float b) {
    nextflame=currentflame+10;
    for (int flame=currentflame; flame<nextflame; flame++) {
      fire[flame][0]=1;
      fire[flame][1]=a;
      fire[flame][2]=b;
      fire[flame][3]=random(0, PI*2);//angle
      fire[flame][4]=random(5, 15);//size
      fire[flame][5]=random(.5, 1);//speed
      fire[flame][6]=random(5, 20)/fire[flame][5];//maxlife
      fire[flame][7]=0;//currentlife
      fire[flame][8]=random(0, TWO_PI);
      fire[flame][9]=random(200, 255);//red
      fire[flame][10]=random(50, 150);//green
    }
    currentflame=nextflame;
  }
}