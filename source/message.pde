
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
  void drawBox(float x, float y, float width, float height, int wordRate,float c) {
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

  boolean isDone() {
    return charCounter >= boxText.length();
  }
}