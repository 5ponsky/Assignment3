import java.util.Random;
import java.util.LinkedList;
import java.util.Iterator;

class Model {
  boolean game_lost, no_energy, fall_ending, collision_ending;
  boolean collisionKnockback = true;
  int tubeCounter, damageDelay;
  Cloud cloud;
  Tube tube;
  Bird bird;
  Hand hand;
  Random random;
  LinkedList<Tube> tubes;

  Model() {
    game_lost = false;
    no_energy = false;
    fall_ending = false;
    collision_ending = false;
    tubeCounter = 0;
    damageDelay = 0;

    bird = new Bird();
    random = new Random();
    tube = new Tube(random);
    hand = new Hand(bird);
    cloud = new Cloud(random);
    tubes = new LinkedList<Tube>();
  }

  public void update() {

    // Manage Game State
    if(!game_lost) {

      // Update our list of tubes
      Iterator<Tube> i = tubes.iterator();
      while(i.hasNext()) {
        tube = i.next();
        if(tubeCollision(bird, tube) && damageDelay >= 25) {
          bird.energy = bird.energy - 71;
          damageDelay = 0;
        }

        if(tube.update()) {
          i.remove();
          System.out.println("GONE");
        }
      }
      ++damageDelay;

      // Decide if we can add a new tube into our list
      if(tubeCounter >= 45 && tubes.size() < 3) {
        Tube t = new Tube(random);
        tubes.add(t);
        tubeCounter = 0;
        System.out.println("ADDED NEW");
      }
      ++tubeCounter;

      // Conditions to trigger a lost game
      if(bird.energy < 0) {
        game_lost = true;
        no_energy = true;
      } else if(bird.y_pos > 500) {
        game_lost = true;
        fall_ending = true;
      }

      // Update everything else
      bird.update();
      cloud.update();


    } else {
      bird.update();

      // The game is lost!
      if(no_energy) {
        hand.update();
      } else {
        System.out.println("Game Over!");
        System.exit(0);
      }
    }

    // End the game
    if(bird.y_pos > 500) {
      System.out.println("Game Over!");
      System.exit(0);
    }

  }

  public void onClick() {
    bird.flap();
  }

    public boolean tubeCollision(Bird b, Tube t) {
      if(collisionDetected(b.x_pos, b.y_pos, 64, 57, t.x_pos, t.y_pos, 55, 400))
        return true;
      return false;
    }

    // Generic Collision Detection
    private boolean collisionDetected(
      int a_x, int a_y, int a_w, int a_h, int b_x, int b_y, int b_w, int b_h) {

      if(a_x + a_w < b_x) // right -> left collision
        return false;
      if(a_x > b_x + b_w) // left -> right collision
        return false;
      if(a_y + a_h < b_y) // bottom -> top collision
        return false;
      if(a_y > b_y + b_h) // top -> bottom collision
        return false;

      System.out.println("Ouch!");
      return true;
    }
    /*
      private boolean collisionDetected() {
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
      } */
}
