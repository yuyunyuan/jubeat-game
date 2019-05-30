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
    grav = new PVector(0,0.02);
    
    tail = new ArrayList();
  }

  void run() {
    pos.add(speed);

    tail.add(new PVector(pos.x,pos.y,0));
    if(tail.size() > taillength) {
      tail.remove(0);
    }

    float damping = random(-0.5,-0.6);
    if(pos.x > width - margin || pos.x < margin) {
      speed.x *= damping;
    }
    if(pos.y > height*7/8 -margin) {
      speed.y *= damping;
    }
  }

  void gravity() {
    speed.add(grav);
  }

  void update() {
    for (int i = 0; i < tail.size(); i++) {
      PVector tempv = (PVector)tail.get(i);
      noStroke();
      fill(6*i + 50);
      ellipse(tempv.x,tempv.y,r,r);
    }
  }
}