import java.util.Random;
import java.awt.Image;

class Cloud {
  int x_pos, y_pos;
  Random random;
  static Image cloud_image;

  Cloud(Random r) {
    random = r;
    x_pos = 575;
    cloud_image = null;
  }

  public void update() {
    x_pos = x_pos - 2;

    if(x_pos < -501) {
      x_pos = 501;
      y_pos = random.nextInt(250) + 50;
    }
  }

}
