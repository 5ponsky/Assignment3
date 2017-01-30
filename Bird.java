import java.awt.Image;

class Bird {
  boolean flapped;
  double gravity, recharge;
  int x_pos, y_pos, flapCounter, energy;
  static Image bird_image_up = null;
  static Image bird_image_down = null;

  Bird() {
    x_pos = 10;
    y_pos = 250;
    energy = 100;
    
    try {
      this.bird_image_up = ImageIO.read(new File("bird1.png"));
      this.bird_image_down = ImageIO.read(new File("bird2.png"));
    } catch(Exception e) {
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }

  public void flap() {
    gravity = gravity - 2.5;
    y_pos = y_pos - (int) gravity;
    --energy;
    flapCounter = 3;
  }

  public void update() {
    gravity = gravity + 0.3;
    y_pos = y_pos + (int) gravity;
    --flapCounter;

    recharge = recharge + 0.5;
    energy = energy + (int) recharge;

    // Breakpoint
    if(this.y_pos > 400)
      System.out.println("Break here.");
  }

}
