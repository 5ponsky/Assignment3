

class Hand {
  int x_pos, y_pos;
  static Image open_hand = null;
  static Image closed_hand = null;

  Hand() {
    
    try {
      this.open_hand = ImageIO.read(new File("hand1.png"));
      this.closed_hand = ImageIO.read(new File("hand2.png"));
    } catch(Exception e) {
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }

  public void update() {

  }

  public void grab() {

  }

}
