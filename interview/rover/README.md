# 程序题目：火星车
### Problem Statement:
- A squad of robotic rovers is to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.
- NASA 将在火星高原上降落一队机器人漫游车。 这个奇怪的长方形高原必须由漫游车导航，以便他们的机载相机可以全面了解周围地形并将其发送回地球。
- A rover’s position and the location is represented by a combination of x and y coordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.
- 流动站的位置和位置由 x 和 y 坐标的组合以及代表四个罗盘基点之一的字母表示。 高原被划分为网格以简化导航。 一个示例位置可能是 0、0、N，这意味着流动站位于左下角并面向北方。
- In order to control a rover, NASA sends a simple string of letters. The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ make the rover spin 90 degrees left or right respectively, without moving from its current spot. ‘M’ means move forward one grid point, and maintain the same heading.
- 为了控制漫游者，NASA 发送一串简单的字母。 可能的字母是“L”、“R”和“M”。 “L”和“R”分别使漫游车向左或向右旋转 90 度，而不会从当前位置移动。 “M”表示向前移动一个格点，并保持相同的航向。
- Assume that the square directly North from (x, y) is (x, y+1).
- 假设(x, y) 正北的正方形是(x, y+1)。
### Input:
- The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.
- 输入的第一行是高原的右上角坐标，左下角坐标假定为0,0。
- The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover’s position, and the second line is a series of instructions telling the rover how to explore the plateau.
- 输入的其余部分是与已部署的流动站有关的信息。 每个流动站有两行输入。 第一行给出了漫游者的位置，第二行是一系列指令，告诉漫游者如何探索高原。
  -The position is made up of two integers and a letter separated by spaces, corresponding to the x and y coordinates and the rover’s orientation.
- 位置由两个整数和一个用空格分隔的字母组成，对应于 x 和 y 坐标以及流动站的方向。
- Each rover will be finished sequentially, which means that the second rover won’t start to move until the first one has finished moving.
- 每个流动站将按顺序完成，这意味着第二个流动站不会开始移动，直到第一个流动站完成移动。
### Output:
- The output for each rover should be its final coordinates and heading.
- 每个流动站的输出应该是它的最终坐标和航向。
### Example:
- Input:

    5 5

    1 2 N

    LMLMLMLMM

    3 3 E

    MMRMMRMRRM
- Expected Output:

    1 3 N

    5 1 E
