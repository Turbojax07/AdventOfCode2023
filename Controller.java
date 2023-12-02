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
    /*
     * How to use Controller.java
     * The classes are already imported into the file, so all you will edit is in the main function below.
     * 
     * To test a script, go down and change the path to point to the correct input.txt file. (EX: Day3/input.txt for day 3 testing)
     * You can change the path that the file is accessed at by changing the string.
     * 
     * To run a function from a Day's challenge, write out the day and run the function part1 or part2.  Don't forget to pass the input Scanner as a variable!
     * (EX: Day3.part1(input) to test part 1 of day 3's challenge)
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Day2/input.txt");
        Scanner input = new Scanner(file);

        Day2.part2(input);
    }
}
