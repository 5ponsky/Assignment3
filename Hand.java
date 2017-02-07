import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;

class Hand {
  boolean gotcha;
  double speed;
  int x_pos, y_pos;
  Bird bird;
  static Image open_hand = null;
  static Image closed_hand = null;

  Hand(Bird b) {
    bird = b;
    gotcha = false;
    x_pos = 10;
    y_pos = 550;

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

    x_pos = bird.x_pos + 5;
    //if(y_pos < bird.y_pos + 10 && y_pos > bird.y_pos - 10) {
    if(y_pos > bird.y_pos - 15 && y_pos < bird.y_pos + 15) {
      gotcha = true;
      y_pos = y_pos + 3;
      bird.y_pos = y_pos;
    } else {
      y_pos = y_pos - 5;
    }

  }

}
