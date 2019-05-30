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
  void drawitem() {
    if (value){
      image(img, x,y, height/16, height/16);
    }
  }
  void mouseover() {
    if (mouseX>x&&mouseX<x+height/16&&mouseY>y&&mouseY<y+height/16&&value) {
      desc.drawBox(mouseX, mouseY, width-200, 200, 1,0);
    } else {
      desc=new message(des);
    }
  }
}