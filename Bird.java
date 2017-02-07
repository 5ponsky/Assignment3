import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;

class Bird {
  boolean flapped;
  double gravity;
  int x_pos, y_pos, flapCounter, energy;
  static Image bird_image_up = null;
  static Image bird_image_down = null;

  Bird() {
    x_pos = 10;
    y_pos = 250;
    energy = 100;

    // Only load the sprites if they exist and an instance is created
    try {
      this.bird_image_up = ImageIO.read(new File("bird1.png"));
      this.bird_image_down = ImageIO.read(new File("bird2.png"));
    } catch(Exception e) {
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }

  public void flap() {
    if(energy > 0) {
      gravity = gravity - 2.5;
      y_pos = y_pos - (int) gravity;
      flapCounter = 3;
      //energy = energy - 35;
    } else
      energy = 0;
  }

  public void update() {

    // Allow the bird to recharge energy so long as it has more than 0,
    // and cap the energy at 100
    if(energy > 0) {

      // Simulate gravity and bird flapping
      gravity = gravity + 0.3;
      y_pos = y_pos + (int) gravity;
      --flapCounter;


      energy += 1;
      if(energy > 100)
        energy = 100;
    } else if (energy < 0)
      energy = 0; // Cosmetic effect to keep the bar from drawing backwards

  }

/*
  public void animateCollision(boolean knockback) {

    // Knock the bird backwards and upwards, indicating a "bump"
    energy = 0;
    if(knockback)
      gravity = gravity - 4.5;
    y_pos = y_pos + (int) gravity;
    x_pos = x_pos - 2;
  }
*/

}
