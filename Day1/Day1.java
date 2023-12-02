// Java 21
package Day1;

import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    // Answer: 54634
    public static void part1(Scanner input) {
        int count = 0;
        ArrayList<String> ints = new ArrayList<String>();
        while (input.hasNextLine()) {
            String str = input.nextLine();
            /*
            // Replaces the safe numbers (numbers that cannot be mixed with others)
            str.replace("four", "4");
            str.replace("six", "6");

            // Replaces the unsafe numbers
            for (int i = 0; i < str.length() - 4; i++) {
                String str3 = str.substring(i, i + 5);
                String str4 = str.substring(i, i + 5);
                String str5 = str.substring(i, i + 5);
                if (str3.equals("one")) str = str.substring(0, i) + "1" + str.substring(i + 3);
                if (str3.equals("two")) str = str.substring(0, i) + "2" + str.substring(i + 3);
                if (str5.equals("three")) str = str.substring(0, i) + "3" + str.substring(i + 5);
                if (str4.equals("five")) str = str.substring(0, i) + "5" + str.substring(i + 4);
                if (str5.equals("seven")) str = str.substring(0, i) + "7" + str.substring(i + 5);
                if (str5.equals("eight")) str = str.substring(0, i) + "8" + str.substring(i + 5);
                if (str4.equals("nine")) str = str.substring(0, i) + "9" + str.substring(i + 4);
            }

            // Fixes gaps in logic (numbers at the end not accounted for above)
            str.replace("one", "1");
            str.replace("two", "2");
            str.replace("five", "5");
            str.replace("nine", "9");

            */
            for (int i = 0; i < str.length() - 1; i++) {
                

                try {
                    Integer.parseInt(String.valueOf(str.charAt(i)));
                    ints.add(String.valueOf(str.charAt(i)));
                } catch (NumberFormatException err) {
                    String test = str.substring(i, i + 5);
                    if (test.contains("one")) str = "1" + str.substring(i + 3, str.length());
                    if (test.contains("two")) str = "2" + str.substring(i + 3, str.length());
                    if (test.contains("three")) str = "3" + str.substring(i + 5, str.length());
                    if (test.contains("four")) str = "4" + str.substring(i + 4, str.length());
                    if (test.contains("five")) str = "5" + str.substring(i + 4, str.length());
                    if (test.contains("six")) str = "6" + str.substring(i + 3, str.length());
                    if (test.contains("seven")) str = "7" + str.substring(i + 5, str.length());
                    if (test.contains("eight")) str = "8" + str.substring(i + 5, str.length());
                    if (test.contains("nine")) str = "9" + str.substring(i + 4, str.length());
                }
            }

            count += Integer.parseInt(ints.getFirst() + ints.getLast());
            ints.clear();
        }

        System.out.println(count);
    }

    // Answer: 53855
    public static void part2(Scanner input) {
        System.out.println("I do not have a working algorithm for this yet.  Please refer to Test.java for a part 2 algorithm.");
    }
}