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
	//Image bird_image_up, bird_image_down, tube_down_image, tube_up_image, cloud_image;
	Model model;
	Controller controller;

	View(Controller c, Model m)
	{
		model = m;
		controller = c;
		controller.setView(this);
		/*
		try {
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
		*/
	}

	public void paintComponent(Graphics g) {
		g.setColor(new Color(128, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.fillRect(0, 452, 103, 48);
		g.fillRect(3, 455, model.bird.energy, 45);
		g.drawImage(this.cloud_image, model.cloud.x_pos, model.cloud.y_pos, null);

		if(model.bird.flapCounter <= 0) // Draw bird wings up or down
			g.drawImage(this.bird_image_up, model.bird.x_pos, model.bird.y_pos, null);
		else
			g.drawImage(this.bird_image_down, model.bird.x_pos, model.bird.y_pos, null);

		if(model.tube.tubeUpwards) // Draw either up or down sprite
			g.drawImage(this.tube_up_image, model.tube.x_pos, model.tube.y_pos, null);
		else
			g.drawImage(this.tube_down_image, model.tube.x_pos, model.tube.y_pos, null);
	}

}
