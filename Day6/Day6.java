package Day6;

import java.util.Scanner;

public class Day6 {
    public static void part1(Scanner input) {
        // Parsing input
        String timeStr = input.nextLine();
        String distStr = input.nextLine();

        // Compiling the times as integers
        int i = 0;
        int[] timeArr = new int[4];
        for (String time : timeStr.split(" ")) {
            try {
                int timeInt = Integer.parseInt(time);
                timeArr[i] = timeInt;
                i++;
            } catch (Exception err) {}
        }

        // Compiling the distances as integers
        i = 0;
        int[] distArr = new int[4];
        for (String dist : distStr.split(" ")) {
            try {
                int distInt = Integer.parseInt(dist);
                distArr[i] = distInt;
                i++;
            } catch (Exception err) {}
        }

        // Getting the number of wins for each number and multiplying them into count.
        int count = 1;
        for (int x = 0; x < 4; x++) {
            int numWins = 0;
            int temp = timeArr[x] - 1;
            for (int y = 1; y < timeArr[x]; y++) {
                if (distArr[x] < y * temp) numWins++;
                temp--;
            }

            count *= numWins;
        }

        // Printing the final answer.
        System.out.println(count);
    }

    public static void part2(Scanner input) {
        // Collecting input
        String timeStr = input.nextLine();
        String distStr = input.nextLine();

        // Removing all spaces from the string.
        timeStr = timeStr.replace(" ", "");
        distStr = distStr.replace(" ", "");

        // Singling out the large numbers we have created.
        double time = Double.parseDouble(timeStr.split(":")[1]);
        double dist = Double.parseDouble(distStr.split(":")[1]);

        // Getting the number of wins for the number
        double numWins = 0;
        double temp = time - 1;
        for (double y = 1; y < time; y++) {
            if (dist < y * temp) numWins++;
            temp--;
        }

        System.out.println(numWins);
    }
}