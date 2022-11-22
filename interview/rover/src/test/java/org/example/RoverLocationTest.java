package org.example;

import org.example.pojo.Plateau;
import org.example.pojo.Rover;
import org.example.utils.RoverUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoverLocationTest {

    @Test
    void startMove() {
        Plateau plateau;
        Rover rover;
        String instruction;
        plateau = new Plateau(5, 5);
        plateau.setNorth_border(new boolean[plateau.getUpperRight_X() + 1]);
        rover = new Rover(1, 2, "N");
        instruction = "LMLMLMLMM";
        new RoverLocation().startMove(plateau, rover, instruction);
        Assertions.assertEquals("1 3 N", rover.toString());
        rover = new Rover(3, 3, "E");
        instruction = "MMRMMRMRRM";
        new RoverLocation().startMove(plateau, rover, instruction);
        Assertions.assertEquals("5 1 E", rover.toString());
        rover = new Rover(5, 5, "N");
        instruction = "MLMR";
        String res = new RoverLocation().startMove(plateau, rover, instruction);
        Assertions.assertEquals("5 5 N F", res);

    }

    @Test
    void should_leave_beacon_when_first_get_out_plateau() {
        Plateau plateau;
        Rover rover;
        String instruction;
        plateau = new Plateau(5, 5);
        rover = new Rover(5, 5, "N");
        plateau.setNorth_border(new boolean[plateau.getUpperRight_X() + 1]);
        instruction = "M";

        String res = new RoverLocation().startMove(plateau, rover, instruction);

        Assertions.assertEquals("5 5 N F", res);
    }

    @Test
    void should_hit_beacon_when_second_get_out_plateau() {
        Plateau plateau;
        Rover rover;
        String instruction;
        plateau = new Plateau(5, 5);
        rover = new Rover(5, 5, "N");
        boolean[] n_border = new boolean[plateau.getUpperRight_X() + 1];
        n_border[plateau.getUpperRight_X()] = RoverUtil.BEACON_ON;
        plateau.setNorth_border(n_border);
        instruction = "M";

        String res = new RoverLocation().startMove(plateau, rover, instruction);

        Assertions.assertEquals("5 5 N B", res);
    }
}