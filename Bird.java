import java.awt.Image;

class Bird {
  boolean flapped;
  double gravity, recharge;
  int x_pos, y_pos, flapCounter, energy;
  static Image bird_image_up, bird_image_down;

  Bird() {
    x_pos = 10;
    y_pos = 250;
    energy = 10;
    bird_image_up = null;
    bird_image_down = null;
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
