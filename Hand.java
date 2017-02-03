import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;

class Hand {
  double speed;
  int x_pos, y_pos;
  Bird bird;
  static Image open_hand = null;
  static Image closed_hand = null;

  Hand(Bird b) {
    bird = b;

    // Only load the sprites if they exist and an instance is created
    try {
      this.open_hand = ImageIO.read(new File("hand1.png"));
      this.closed_hand = ImageIO.read(new File("hand2.png"));
    } catch(Exception e) {
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }

  public void update() {
    grab();
  }

  public void grab() {
    x_pos = bird.x_pos;
    if(y_pos != bird.y_pos) {
      speed = speed - 10.5;
      y_pos = y_pos - (int) speed;
    } else {
      bird.y_pos = y_pos;
      speed = speed + 4.5;
      y_pos = y_pos + (int) speed;
    }

  }

}
