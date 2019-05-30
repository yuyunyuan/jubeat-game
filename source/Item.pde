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
  void drawitem(float a, float b) {
    tint(255,255);
    if (status)
      image(img, a, b, height/16, height/16);
  }
  void mouseover() {
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
  void getitem(int a, int b) {
    if (a==tx&&b==ty) {
      item.play();
      sword.value+=this.value;
      status=false;
      scene4counter++;
    }
  }
}