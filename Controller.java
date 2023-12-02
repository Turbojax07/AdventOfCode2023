import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Day1.Day1;
import Day2.Day2;
import Day3.Day3;
import Day4.Day4;
import Day5.Day5;
import Day6.Day6;
import Day7.Day7;
import Day8.Day8;
import Day9.Day9;
import Day10.Day10;
import Day11.Day11;
import Day12.Day12;
import Day13.Day13;
import Day14.Day14;
import Day15.Day15;
import Day16.Day16;
import Day17.Day17;
import Day18.Day18;
import Day19.Day19;
import Day20.Day20;
import Day21.Day21;
import Day22.Day22;
import Day23.Day23;
import Day24.Day24;
import Day25.Day25;

public class Controller {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Day2/input.txt");
        Scanner input = new Scanner(file);

        Day2.part2(input);
    }
}
