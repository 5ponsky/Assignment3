import java.util.Random;
import java.util.LinkedList;
import java.util.Iterator;

class Model {
  boolean game_lost, hand_ending, fall_ending, collision_ending;
  int tube_y;
  Cloud cloud;
  Bird bird;
  Tube tube;
  Hand hand;
  Random random;
  LinkedList<Tube> tubes;
  Iterator<Tube> i;

  Model() {
    game_lost = false;
    hand_ending = false;
    fall_ending = false;
    collision_ending = false;

    bird = new Bird();
    random = new Random();
    tube = new Tube(random);
    hand = new Hand(bird);
    cloud = new Cloud(random);
    tubes = new LinkedList<Tube>();
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

/*
  // Generic Collision Detection
  static boolean collisionDetected(
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
*/

  private boolean birdCrashed() {
    if(bird.y_pos > 500) {
      System.out.println("AAAAAAAAHHH!");
      bird.y_pos = 250;
      bird.gravity = -1.5;
      return true;
    }
    return false;
  }

  private boolean noEnergy() {
    if(bird.energy <= 0)
      return true;
    return false;
  }

  static boolean offScreen() {
    return true;
  }

  public void update() {
    if(!game_lost) {
      bird.update();
      hand.update();
      cloud.update();
      tube.update();

      Iterator<Tube> i = tubes.iterator();
      while(i.hasNext()) {
      Tube t = i.next();
      if(offScreen())
        i.remove();
      }

      if(collisionDetected()) {
        game_lost = true;
        collision_ending = true;
      } else if(bird.energy < 0) {
        game_lost = true;
        hand_ending = true;
      } else if(bird.y_pos > 500) {
        game_lost = true;
        fall_ending = true;
      }
  } else {

    // The game is lost!
    if(hand_ending) {
      //Do the hand ending animation
    } else if(collision_ending) {
      // Make it bounce and fall down
    } else {
      System.out.println("Game Over!");
    }
  }

  public void onClick() {
      bird.flap();
  }

  void end_game() {

  }

}
