import java.util.Random;
import java.util.LinkedList;
import java.util.Iterator;

class Model {
  int tube_y;
  Cloud cloud;
  Bird bird;
  Tube tube;
  Hand hand;
  Random random;
  LinkedList<Tube> tube_list;
  Iterator<Tube> t;

  Model() {
    bird = new Bird();
    random = new Random();
    tube = new Tube(random);
    hand = new Hand();
    cloud = new Cloud(random);
    tube_list = new LinkedList<Tube>(); // IDK if this is right...
    t = new Iterator<Tube>();
  }

  private boolean collisionDetected() {
    // Bird: 64 x 57
    // Tube: 55 x 400

    if(bird.x_pos + 64 < tube.x_pos) // right -> left collision
      return false;
    if(bird.x_pos > tube.x_pos + 55) // left -> right collision
      return false;
    if(bird.y_pos + 57 < tube.y_pos) // bottom -> top collision
      return false;
    if(bird.y_pos > tube.y_pos + 400) // top -> bottom collision
      return false;

    System.out.println("Ouch!");
    return true;
  }

  private boolean birdCrashed() {
    if(bird.y_pos > 500) {
      System.out.println("AAAAAAAAHHH!");
      bird.y_pos = 250;
      bird.gravity = -1.5;
    }
  }

  private boolean noEnergy() {
    if(bird.energy <= 0)
      return true;
    return false;
  }

  public void update() {
    bird.update();
    for(t = tube_list; t.hasNext(); ) { // Maybe this works?
      t.update();
    }
    // Use an Iterator class to iterate over all tubes in a collection,
    // and call tube.update() on each of them to draw them.
    //
    // Add a new tube to the collection every n frames (2-3 tubes visible at all times)
    //
    // Once a tube runs past the screen, let the garbage collect it and make a new Once
    // (Have tube.update return a boolean value to model.update indicating drop/keep)
    tube.update();
    hand.update();
    cloud.update();

    if(collisionDetected())
      System.exit(0);
    if(birdCrashed())
      System.exit(0);
    if(noEnergy()) {
      System.exit(0);
      energy
    }

  }

  public void onClick() {
    bird.flap();
  }

}
