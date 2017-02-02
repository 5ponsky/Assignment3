import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;

class View extends JPanel
{
	JButton b1;
	Model model;
	Controller controller;

	View(Controller c, Model m)
	{
		model = m;
		controller = c;
		controller.setView(this);
	}

	public void paintComponent(Graphics g) {
		// Draw background
		g.setColor(new Color(128, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		// Draw bird wings up or down
		if(model.bird.flapCounter <= 0)
			g.drawImage(model.bird.bird_image_up, model.bird.x_pos, model.bird.y_pos, null);
		else
			g.drawImage(model.bird.bird_image_down, model.bird.x_pos, model.bird.y_pos, null);

		// Draw either up or down sprite
		if(model.tube.tubeUpwards)
			g.drawImage(model.tube.tube_up_image, model.tube.x_pos, model.tube.y_pos, null);
		else
			g.drawImage(model.tube.tube_down_image, model.tube.x_pos, model.tube.y_pos, null);

		// Draw a cloud_image
		g.drawImage(model.cloud.cloud_image, model.cloud.x_pos, model.cloud.y_pos, null);

		// Draw energy bar
		g.setColor(new Color(0, 255, 0));
		g.fillRect(425, 200, 75, 2 * model.bird.energy);
		g.setColor(new Color(0, 0, 0));
		g.drawRect(424, 199, 76, 201);
	}

}
