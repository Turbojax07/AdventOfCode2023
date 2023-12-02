package Day2;

import java.util.Scanner;

public class Day2 {
    public static void part1(Scanner input) {
        int total = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            int id = Integer.parseInt(line.replace(":", "").split(" ")[0]);
            boolean addID = true;
            // This splits the line multiple times and loops through each part.
            for (String game : line.split(": ")[1].split("; ")) {
                for (String cubes : game.split(", ")) {
                    int numCubes = Integer.parseInt(cubes.split(" ")[0]);
                    String color = cubes.split(" ")[1];
                    if (color.equals("blue") && numCubes > 14) {
                        addID = false;
                    } if (color.equals("red") && numCubes > 12) {
                        addID = false;
                    } if (color.equals("green") && numCubes > 13) {
                        addID = false;
                    }
                }
            }

            // Adds the ID to the total
            if (addID) {
                total += id;
            }
        }

        System.out.println(total);
    }

    public static void part2(Scanner input) {
        int total = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();

            int minBlue = 0;
            int minGreen = 0;
            int minRed = 0;
            // This splits the line multiple times and loops through each part.
            for (String game : line.split(": ")[1].split("; ")) {
                for (String cubes : game.split(", ")) {
                    int num = Integer.parseInt(cubes.split(" ")[0]);
                    String color = cubes.split(" ")[1];
                    if (color.equals("blue")) {
                        minBlue = (minBlue < num) ? num : minBlue;
                    } if (color.equals("red")) {
                        minRed = (minRed < num) ? num : minRed;
                    } if (color.equals("green")) {
                        minGreen = (minGreen < num) ? num : minGreen;
                    }
                }
            }

            // Adds the power to the total
            total += minBlue * minGreen * minRed;
        }

        System.out.println(total);
    }
    
    // Pt 1: 2439
    // Pt 2: 
}