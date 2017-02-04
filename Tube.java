import java.util.Random;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;

class Tube {
  final int TUBEBOUND = 115;
  int x_pos, y_pos;
  boolean tubeUpwards;
  Random random;
  static Image tube_down_image = null;
  static Image tube_up_image = null;

  Tube(Random r) {
    random = r;
    x_pos = 555;

    // Only load the sprites if they exist and an instance is created
    try {
			this.tube_up_image = ImageIO.read(new File("tube_up.png"));
			this.tube_down_image = ImageIO.read(new File("tube_down.png"));
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}

    tubeUpwards = random.nextBoolean();

    if(tubeUpwards)
      y_pos = random.nextInt(TUBEBOUND) + 250;
    else
      y_pos = random.nextInt(TUBEBOUND) - 250;
  }

  public void drawTube(Graphics g) {
    if(this.tubeUpwards)
			g.drawImage(this.tube_up_image, this.x_pos, this.y_pos, null);
		else
			g.drawImage(this.tube_down_image, this.x_pos, this.y_pos, null);
  }

  public boolean update() {
    x_pos = x_pos - 6;
    if(x_pos < -56)
      return true;
    return false;
  }

}
