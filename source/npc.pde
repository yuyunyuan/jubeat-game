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
  void startspeak() {
    if(ss&&word<talk.length-1)
      word++;
    item.play();
    ss=true;
    temp =new message(talk[word]);
  }
  void speak() {
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
  void reset(String name, float a, float b, int c) {
    img = loadImage(name+".png");
    x=width*(a*2+3)/48;
    y=height*(b*2+1)/32;
    tx=a;
    ty=b;
    hp=c;
  }
  void drawshack(float size) {

    //println(tx);
    image(img, x+random(-5, 5), y+random(-5, 5), size, size);
  }
  void drawitem() {
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
  void move() {
    int r1=(int)random(-2, 2);
    int r2=(int)random(-2, 2);
    if (tx+r1>=1&&tx+r1<=17)
      tx+=r1;
    if (ty+r2>=0&&ty+r2<=10)
      ty+=r2;
  }
  void bossfireball() {
    Fireball f=new Fireball(x, y, this);
    f.colorb=255;
    f.colorr=50;
    f.colorg=150;
    Fireballs.add(f);
    magic.play();
  }
  void bossswing() {
    fill(255, 0, 0);
    stroke(255, 0, 0);
    if (main.x<this.x)
      curve(x, y, x-height/32, y+height/32, x-height/32, y+height*3/32, x, y+height/8);
    else
      curve(x+width/16, y, x+width/16+height/32, y+height/32, x+width/16+height/32, y+height*3/32, x+width/16, y+height/8);
  }
  void swinghit() {
    if (main.tx>this.tx-1&&main.tx<this.tx+5&&main.ty>=this.ty&&main.ty<this.ty+4) {
      main.n.hp-=5*difficultmut;
      injurttt=0;
      injurc=true;
      injur=200;
      injurt=millis();
    }
  }
  void mouseover() {
    if (mouseX>x-height/16&&mouseX<x+height/16&&mouseY>y-height/16&&mouseY<y+height/16) {
      desc.drawBox(mouseX, mouseY, width-200, 200, 1, 0);
    } else {
      desc=new message(name+" HP:"+hp);
    }
  }
  void bigmouseover() {
    if (hp>0) {
      if (mouseX>x&&mouseX<x+height/8&&mouseY>y&&mouseY<y+height/8) {
        desc.drawBox(mouseX, mouseY, width-200, 200, 1, 0);
      } else {
        desc=new message(name+" HP:"+hp);
      }
    }
  }
}