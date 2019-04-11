package Movement;

import Rover.MarsRover;

public class TurnRight implements IMovement {

    public void move(MarsRover marsRover) {
        marsRover.turnRight();
    }
}
