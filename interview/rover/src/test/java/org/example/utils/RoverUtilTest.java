package org.example.utils;

import org.example.pojo.Plateau;
import org.example.pojo.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoverUtilTest {

    @Test
    void validateUpperRightCoordinates() {
        Assertions.assertTrue(RoverUtil.validateUpperRightCoordinates("5 5"));
        Assertions.assertFalse(RoverUtil.validateUpperRightCoordinates(""));
        Assertions.assertFalse(RoverUtil.validateUpperRightCoordinates(" "));
        Assertions.assertFalse(RoverUtil.validateUpperRightCoordinates("5"));
        Assertions.assertFalse(RoverUtil.validateUpperRightCoordinates("A"));
        Assertions.assertFalse(RoverUtil.validateUpperRightCoordinates("5 "));
        Assertions.assertFalse(RoverUtil.validateUpperRightCoordinates(" 5"));
        Assertions.assertFalse(RoverUtil.validateUpperRightCoordinates(" 5 5"));
        Assertions.assertFalse(RoverUtil.validateUpperRightCoordinates("5 5 "));
        Assertions.assertFalse(RoverUtil.validateUpperRightCoordinates("5 5 5"));
    }

    @Test
    void validateRoverCurrentLocation() {
        Assertions.assertTrue(RoverUtil.validateRoverCurrentLocation("1 2 N"));
        Assertions.assertTrue(RoverUtil.validateRoverCurrentLocation("1 2 S"));
        Assertions.assertTrue(RoverUtil.validateRoverCurrentLocation("1 2 E"));
        Assertions.assertTrue(RoverUtil.validateRoverCurrentLocation("1 2 W"));
        Assertions.assertFalse(RoverUtil.validateRoverCurrentLocation(""));
        Assertions.assertFalse(RoverUtil.validateRoverCurrentLocation(" "));
        Assertions.assertFalse(RoverUtil.validateRoverCurrentLocation("1"));
        Assertions.assertFalse(RoverUtil.validateRoverCurrentLocation("N"));
        Assertions.assertFalse(RoverUtil.validateRoverCurrentLocation("1 2"));
        Assertions.assertFalse(RoverUtil.validateRoverCurrentLocation("2 N"));
        Assertions.assertFalse(RoverUtil.validateRoverCurrentLocation("S N"));
        Assertions.assertFalse(RoverUtil.validateRoverCurrentLocation(" 1 2 N"));
        Assertions.assertFalse(RoverUtil.validateRoverCurrentLocation("1 2 N "));
        Assertions.assertFalse(RoverUtil.validateRoverCurrentLocation(" 1 2 N"));
        Assertions.assertFalse(RoverUtil.validateRoverCurrentLocation("1 2 SN"));
        Assertions.assertFalse(RoverUtil.validateRoverCurrentLocation("1 2 A"));
    }

    @Test
    void validateInstruction() {
        Assertions.assertTrue(RoverUtil.validateInstruction(""));
        Assertions.assertTrue(RoverUtil.validateInstruction("LMLMLMLRM"));
        Assertions.assertFalse(RoverUtil.validateInstruction(" "));
        Assertions.assertFalse(RoverUtil.validateInstruction(" LMLMLMLRM"));
        Assertions.assertFalse(RoverUtil.validateInstruction("LMLM LMLRM"));
        Assertions.assertFalse(RoverUtil.validateInstruction("LMLMLMLRM "));
        Assertions.assertFalse(RoverUtil.validateInstruction("LMLMAMLRM"));
    }

    @Test
    void checkCoordinate() {
        Plateau plateau;
        Rover rover;
        plateau = new Plateau(5, 5);
        rover = new Rover(0, 0, "N");
        Assertions.assertTrue(RoverUtil.checkCoordinate(plateau, rover));
        rover = new Rover(5, 5, "N");
        Assertions.assertTrue(RoverUtil.checkCoordinate(plateau, rover));
        rover = new Rover(-1, 0, "N");
        Assertions.assertFalse(RoverUtil.checkCoordinate(plateau, rover));
        rover = new Rover(0, -1, "N");
        Assertions.assertFalse(RoverUtil.checkCoordinate(plateau, rover));
        rover = new Rover(6, 5, "N");
        Assertions.assertFalse(RoverUtil.checkCoordinate(plateau, rover));
        rover = new Rover(5, 6, "N");
        Assertions.assertFalse(RoverUtil.checkCoordinate(plateau, rover));
    }

    @Test
    void move() {
        Plateau plateau;
        Rover rover;
        plateau = new Plateau(5, 5);
        rover = new Rover(1, 2, "N");
        RoverUtil.move(plateau, rover);
        Assertions.assertEquals(3, rover.getY());
        rover = new Rover(1, 2, "S");
        RoverUtil.move(plateau, rover);
        Assertions.assertEquals(1, rover.getY());
        rover = new Rover(1, 2, "W");
        RoverUtil.move(plateau, rover);
        Assertions.assertEquals(0, rover.getX());
        rover = new Rover(1, 2, "E");
        RoverUtil.move(plateau, rover);
        Assertions.assertEquals(2, rover.getX());
    }

    @Test
    void turnLeft() {
        Rover rover;
        rover = new Rover(1, 2, "N");
        RoverUtil.turnLeft(rover);
        Assertions.assertEquals("W", rover.getDirection());
        rover = new Rover(1, 2, "S");
        RoverUtil.turnLeft(rover);
        Assertions.assertEquals("E", rover.getDirection());
        rover = new Rover(1, 2, "W");
        RoverUtil.turnLeft(rover);
        Assertions.assertEquals("S", rover.getDirection());
        rover = new Rover(1, 2, "E");
        RoverUtil.turnLeft(rover);
        Assertions.assertEquals("N", rover.getDirection());
    }

    @Test
    void turnRight() {
        Rover rover;
        rover = new Rover(1, 2, "N");
        RoverUtil.turnRight(rover);
        Assertions.assertEquals("E", rover.getDirection());
        rover = new Rover(1, 2, "S");
        RoverUtil.turnRight(rover);
        Assertions.assertEquals("W", rover.getDirection());
        rover = new Rover(1, 2, "W");
        RoverUtil.turnRight(rover);
        Assertions.assertEquals("N", rover.getDirection());
        rover = new Rover(1, 2, "E");
        RoverUtil.turnRight(rover);
        Assertions.assertEquals("S", rover.getDirection());
    }
}