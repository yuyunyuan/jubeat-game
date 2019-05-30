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
  void drawpeg() {

    rect(x, y, width/24+1, height/16+1);
  }
  boolean canwalk(){
    return canwalk;
  }
}