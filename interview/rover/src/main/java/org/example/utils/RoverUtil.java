package org.example.utils;

import org.example.pojo.Plateau;
import org.example.pojo.Rover;

/**
 * @author mzy
 */
public class RoverUtil {
    public static final boolean BEACON_ON = true;
    public static final boolean BEACON_OFF = false;
    public static final String BEACON_hit = "B";
    public static final String BEACON_LEAVE = "F";
    public static final String END = "end";
    public static final String LEFT = "L";
    public static final String RIGHT = "R";
    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    public static final String WEST = "W";
    public static final String EAST = "E";
    /**
     * 正则表达式，匹配 数字空格数字（例如5 5）
     */
    public static final String REGEX_NUMBER_BLANK = "[0-9]\\s[0-9]";
    /**
     * 正则表达式，匹配 数字空格数字空格任一字母NSWE（例如1 2 N）
     */
    public static final String REGEX_N_S_W_E_NUMBER_BLANK = "[0-9]\\s[0-9]\\s[NSWE]";
    /**
     * 正则表达式，匹配 LRM 任意字母组合（例如LMLMLMLMM）
     */
    public static final String REGEX_L_R_M = "[LRM]+";
    public static final int ZERO = 0;

    /**
     * 验证高原右上角坐标输入是否符合规则
     *
     * @param upperRightCoordinates 高原右上角坐标
     * @return true 验证通过
     */
    public static boolean validateUpperRightCoordinates(String upperRightCoordinates) {
        return upperRightCoordinates.matches(REGEX_NUMBER_BLANK);
    }

    /**
     * 验证漫游车当前位置输入是否符合规则
     *
     * @param roverCurrentLocation 漫游车当前位置
     * @return true 验证通过
     */
    public static boolean validateRoverCurrentLocation(String roverCurrentLocation) {
        return roverCurrentLocation.matches(REGEX_N_S_W_E_NUMBER_BLANK);
    }

    /**
     * 验证漫游车前进指令输入是否符合规则
     *
     * @param instruction 漫游车前进指令
     * @return true 验证通过
     */
    public static boolean validateInstruction(String instruction) {
        return instruction.isEmpty() || instruction.matches(REGEX_L_R_M);
    }

    /**
     * 检查漫游车是否在高原坐标范围内
     *
     * @param plateau 高原
     * @param rover   漫游车
     * @return true 验证通过
     */
    public static boolean checkCoordinate(Plateau plateau, Rover rover) {
        return rover.getX() >= 0 && rover.getX() <= plateau.getUpperRight_X() && rover.getY() >= 0 && rover.getY() <= plateau.getUpperRight_Y();
    }

    /**
     * 漫游车向前移动
     *
     * @param rover 漫游车
     */
    public static void move(Plateau plateau, Rover rover) {
        if (NORTH.equals(rover.getDirection())) {
            rover.setY(rover.getY() + 1);
            if (!checkCoordinate(plateau, rover)) {
                rover.setY(rover.getY() - 1);
                if (BEACON_OFF == plateau.getNorth_border()[rover.getX()]) {
                    boolean[] n_border = plateau.getNorth_border();
                    n_border[rover.getX()] = BEACON_ON;
                    plateau.setNorth_border(n_border);
                    plateau.setBeacon_flag(BEACON_LEAVE);
                } else {
                    plateau.setBeacon_flag(BEACON_hit);
                }
            }
        } else if (SOUTH.equals(rover.getDirection())) {
            rover.setY(rover.getY() - 1);
        } else if (WEST.equals(rover.getDirection())) {
            rover.setX(rover.getX() - 1);
        } else if (EAST.equals(rover.getDirection())) {
            rover.setX(rover.getX() + 1);
        }
    }

    /**
     * 漫游车向左转
     *
     * @param rover 漫游车
     */
    public static void turnLeft(Rover rover) {
        if (NORTH.equals(rover.getDirection())) {
            rover.setDirection(WEST);
        } else if (WEST.equals((rover.getDirection()))) {
            rover.setDirection(SOUTH);
        } else if (SOUTH.equals((rover.getDirection()))) {
            rover.setDirection(EAST);
        } else if (EAST.equals((rover.getDirection()))) {
            rover.setDirection(NORTH);
        }
    }

    /**
     * 漫游车向右转
     *
     * @param rover 漫游车
     */
    public static void turnRight(Rover rover) {
        if (NORTH.equals(rover.getDirection())) {
            rover.setDirection(EAST);
        } else if (EAST.equals((rover.getDirection()))) {
            rover.setDirection(SOUTH);
        } else if (SOUTH.equals((rover.getDirection()))) {
            rover.setDirection(WEST);
        } else if (WEST.equals((rover.getDirection()))) {
            rover.setDirection(NORTH);
        }
    }


}
