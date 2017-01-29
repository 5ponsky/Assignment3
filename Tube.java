import java.util.Random;
import java.awt.Image; 

class Tube {
  final int TUBEBOUND = 115;
  int x_pos, y_pos;
  boolean tubeUpwards;
  Random random;
  static Image tube_down_image, tube_up_image;

  Tube(Random r) {
    random = r;
    tube_down_image = null;
    tube_up_image = null;
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
