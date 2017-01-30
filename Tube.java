import java.util.Random;
import java.awt.Image;

class Tube {
  final int TUBEBOUND = 115;
  int x_pos, y_pos;
  boolean tubeUpwards;
  Random random;
  static Image tube_down_image = null;
  static Image tube_up_image = null;

  Tube(Random r) {
    random = r;
    
    try {
      this.tube_up_image = ImageIO.read(new File("tube_up.png"));
      this.tube_down_image = ImageIO.read(new File("tube_down.png"));
    } catch(Exception e) {
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }

  public void update() {
    x_pos = x_pos - 6;

    if(x_pos < -56) {
      x_pos = 556;
      tubeUpwards = random.nextBoolean();

      if(tubeUpwards)
        y_pos = random.nextInt(TUBEBOUND) + 250;
      else
        y_pos = random.nextInt(TUBEBOUND) - 250;
    }

  }

}
