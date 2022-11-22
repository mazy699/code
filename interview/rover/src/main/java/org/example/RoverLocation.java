package org.example;

import org.example.pojo.Plateau;
import org.example.pojo.Rover;
import org.example.utils.RoverUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mzy
 */
public class RoverLocation {

    public static void main(String[] args) {
        new RoverLocation().getRoverLocation();
    }

    /**
     * 输入高原右上角坐标、漫游车初始位置、漫游车前进指令;
     * 通过当前漫游车的位置及前进指令，获取漫游车最终位置。
     */
    public void getRoverLocation() {
        List<Rover> roverList = new ArrayList<>();
        List<String> instructionList = new ArrayList<>();
        Plateau plateau = new Plateau();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入高原右上角坐标（请以空格分隔，例如：5 5）:");
        // 高原右上角坐标
        String upperRightCoordinates = scanner.nextLine();
        // 验证高原右上角坐标输入是否符合规则
        if (RoverUtil.validateUpperRightCoordinates(upperRightCoordinates)) {
            // 根据获取的高原右上角坐标设置高原
            plateau.setUpperRight_X(Integer.parseInt(upperRightCoordinates.split("\\s")[0]));
            plateau.setUpperRight_Y(Integer.parseInt(upperRightCoordinates.split("\\s")[1]));
            plateau.setNorth_border(new boolean[plateau.getUpperRight_X() + 1]);
            System.out.println("第一行请输入漫游车当前位置（坐标和方向（请以空格分隔，例如：1 2 N））");
            System.out.println("第二行请输入漫游车前进指令（例如：LMLMLMLMM）");
            System.out.println("两行一组，按组输入完毕后输入 end 查看结果");
            while (!scanner.hasNext(RoverUtil.END)) {
                // 漫游车当前位置
                String roverCurrentLocation = scanner.nextLine();
                // 验证漫游车当前位置及前进指令输入是否符合规则
                if (RoverUtil.validateRoverCurrentLocation(roverCurrentLocation)) {
                    // 漫游车前进指令
                    String instruction = scanner.nextLine();
                    // 验证漫游车前进指令输入是否符合规则
                    if (RoverUtil.validateInstruction(instruction)) {
                        Rover rover = new Rover();
                        // 根据获取的漫游车当前位置设置漫游车
                        rover.setX(Integer.parseInt(roverCurrentLocation.split("\\s")[0]));
                        rover.setY(Integer.parseInt(roverCurrentLocation.split("\\s")[1]));
                        rover.setDirection(roverCurrentLocation.split(" ")[2]);
                        roverList.add(rover);
                        instructionList.add(instruction);
                    } else {
                        System.out.println("漫游车前进指令输入不正确，请重试！");
                    }
                } else {
                    System.out.println("漫游车当前位置输入不正确，请重试！");
                }
            }
        } else {
            System.out.println("高原右上角坐标输入不正确，请重试！");
        }
        for (int i = 0; i < roverList.size(); i++) {
            // 移动漫游车
            String res = startMove(plateau, roverList.get(i), instructionList.get(i));
            System.out.println(res);
        }

        // 关闭扫描器
        scanner.close();
    }

    /**
     * 通过当前漫游车的位置及前进指令，移动漫游车至最终位置。
     *
     * @param plateau     高原
     * @param rover       漫游车
     * @param instruction 漫游车前进指令
     */
    public String startMove(Plateau plateau, Rover rover, String instruction) {
        String res = "";
        // 存在有效前进指令时，此时指令中只包含了L、R、M
        if (instruction.length() > RoverUtil.ZERO) {
            for (int i = 0; i < instruction.length(); i++) {
                // 向左转
                if (RoverUtil.LEFT.equals(String.valueOf(instruction.charAt(i)))) {
                    RoverUtil.turnLeft(rover);
                    // 向右转
                } else if (RoverUtil.RIGHT.equals(String.valueOf(instruction.charAt(i)))) {
                    RoverUtil.turnRight(rover);
                    // 向前移动
                } else {
                    RoverUtil.move(plateau, rover);
                    if (RoverUtil.NORTH.equals(rover.getDirection())) {
                        if (plateau.getNorth_border()[rover.getX()]) {
                            res = rover.getX() + " " + rover.getY() + " " + rover.getDirection() + " " + plateau.getBeacon_flag();
//                            System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getDirection() + " " + plateau.getBeacon_flag());
                            plateau.setBeacon_flag("");
                            return res;
                        }
                    }
                    // 漫游车向前移动后检查是否还在高原坐标范围内
//                    if (!RoverUtil.checkCoordinate(plateau, rover)) {
//                        System.out.println("漫游车不在高原范围,请确认漫游车位置及前进指令后重新执行。");
//                        return;
//                    }
                }
            }
        }
        // 显示结果
//        System.out.println(rover.toString());
        res = rover.toString();
        return res;
    }
}