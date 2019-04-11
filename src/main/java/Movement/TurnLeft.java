package Movement;

import Rover.MarsRover;

public class TurnLeft implements IMovement {


    public void move(MarsRover marsRover) {
        marsRover.turnLeft();
    }
}
