package Day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {
    public static void start() throws FileNotFoundException {
        File file = new File("Day8/input.txt");
        Scanner input = new Scanner(file);

        int numRed = 0;
        int numGreen = 0;
        int numBlue = 0;
        int maxRed = 12;
        int maxGreen = 13;
        int maxBlue = 14;
        System.out.println(input.next());
    }
}