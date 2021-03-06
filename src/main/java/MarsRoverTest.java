import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;

public class MarsRoverTest {
    @Rule
    public ExpectedException exceptedException = ExpectedException.none();

    @Test
    public void landTest() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.EAST);
        String position = rover.getPosition();
        assertThat(position).isEqualTo("55E");
    }

    @Test
    public void moveForwardTest() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.EAST);
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("65E");
    }

    @Test
    public void turnLeftTest() {
        Area area = new Area(10, 10);

        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.SOUTH);
        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55E");

        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55N");

        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55W");

        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55S");


    }

    @Test
    public void turnRightTest() {
        Area area = new Area(10, 10);

        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.SOUTH);
        rover.turnRight();
        assertThat(rover.getPosition()).isEqualTo("55W");

        rover.turnRight();
        assertThat(rover.getPosition()).isEqualTo("55N");

        rover.turnRight();
        assertThat(rover.getPosition()).isEqualTo("55E");

        rover.turnRight();
        assertThat(rover.getPosition()).isEqualTo("55S");


    }

    @Test
    public void roverExecuteTest() {
        Rover rover = new Rover();
        RoverController roverController = new RoverController(rover);
        String mission = "10,10,5,5,E,M,L,M,R";
        String position = roverController.execute(mission);
        assertThat(position).isEqualTo("66E");
    }

    @Test
    public void landException() {
        exceptedException.expect(IllegalArgumentException.class);
        exceptedException.expectMessage("out of bound !");
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 20, 5, Rover.EAST);
        rover.move();
    }

    @Test
    public void moveException() {
        exceptedException.expect(IllegalArgumentException.class);
        exceptedException.expectMessage("out of bound !");
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 10, 5, Rover.EAST);
        rover.move();
    }
}
