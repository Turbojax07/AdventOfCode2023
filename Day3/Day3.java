package Day3;

import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    public static char[] specials = {'@', '#', '$', '%', '&', '*', '-', '+', '=', '/', '.'};
    public static ArrayList<String> strArr = new ArrayList<String>();

    public static void part1(Scanner input) {
        int count = 0;
        int sum = 0;
        while (input.hasNextLine()) {
            strArr.add(input.nextLine());
        }

        for (int i = 0; i < strArr.size(); i++) {
            // Gets the string
            char[] cArr = strArr.get(i).toCharArray();
            for (int j = 0; j < cArr.length; j++) {
                // Looks for a number
                if (Character.isDigit(cArr[j])) {
                    // Gets a String representation of the number
                    String strNum = strArr.get(i).substring(j, j + 3);

                    // Removes all special characters from the string
                    for (char special : specials) {
                        strNum = strNum.replace(special + "", "");
                    }

                    /* MISSED
                     * Number: 181
                     *     Line: 60
                     *     Character: '*'
                     *     Character coords: (58, 6)
                     * 
                     */
                    // checks for a surrounding special character.
                    Scanner scanner = new Scanner(System.in);
                    int num = Integer.parseInt(strNum);
                    int[] data = {i, j, j + strNum.length(), num};
                    int tempsum = sum;
                    sum += scanSurroundingChars(data);
                    if (tempsum == sum) {
                        System.out.printf("Line: %d\nNum: %d\n\n", i + 1, num);
                        scanner.nextLine();
                    }
                    count++;

                    // Increments j to skip over the rest of the string.
                    j += strNum.length();
                }
            }
        }

        System.out.println(sum);
        System.out.println(count);
        // 536157 -> Incorrect; Too low
        //45
    }

    public static int scanSurroundingChars(int[] data) {
        int line = data[0];
        int startchar = data[1];
        int endchar = data[2];
        int num = data[3];

        for (char special : specials) {
            if (special == '.') break;
            for (int i = line - 1; i <= line + 1; i++) {
                for (int j = startchar - 1; j <= endchar; j++) {
                    try {
                        if (strArr.get(i).charAt(j) == special) {
                            //System.out.printf("Char found: %c\n", special);
                            //System.out.printf("Char coords: (%d, %d)\n", i, j);
                            return num;
                        }
                    } catch (IndexOutOfBoundsException err) {}
                }
            }
        }
        System.out.println("Char not found");
        return 0;
    }

    public static void part2(Scanner input) {}
}