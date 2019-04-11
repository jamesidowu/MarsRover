package Rover;

import Mars.*;
import Movement.IMovement;
import Parse.*;
import java.util.*;

public class MarsRover implements IRover {

    private Plateau existingPlateau;
    private Direction roverDirection;
    private Coordinates roverCoordinates;

    public MarsRover(Plateau plateau, Direction direction, Coordinates coordinates){
        this.existingPlateau = plateau;
        this.roverCoordinates = coordinates;
        this.roverDirection = direction;
    }

    public void run(final String commandString) {
        List<IMovement> roverCommands = new StringCommandParser(commandString).toCommands();
        for (IMovement command : roverCommands) {
            command.move(this);
        }
    }

    public String currentLocation() {
        return roverCoordinates.toString() + " " + roverDirection.toString();
    }

    public void turnRight() {
        this.roverDirection = this.roverDirection.right();
    }

    public void turnLeft() {

        this.roverDirection = this.roverDirection.left();
    }

    public void move() {
        Coordinates positionAfterMove = roverCoordinates.newCoordinatesForStepSize(roverDirection.stepSizeForXAxis(), roverDirection.stepSizeForYAxis());

        //ignores the command if rover is being driven off plateau
        if(existingPlateau.hasWithinBounds(positionAfterMove))
            roverCoordinates = roverCoordinates.newCoordinatesFor(roverDirection.stepSizeForXAxis(), roverDirection.stepSizeForYAxis());
    }
}
