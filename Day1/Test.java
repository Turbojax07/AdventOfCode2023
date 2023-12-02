package Day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    //Part 1
    private static void part1(Scanner input) {
        int count = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            ArrayList<String> ints = new ArrayList<String>();
            for (String s : line.split("")) {
                try {
                    Integer.parseInt(s);
                    ints.add(s);
                } catch (NumberFormatException err) {}
            }

            count += Integer.parseInt(ints.getFirst() + ints.getLast());
        }

        System.out.println(count);
    }

    //Part 2
    private static void part2(Scanner input) {
        int count = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            int stringLeftDigit = -1;
            int stringRightDigit = -1;
            int lastIndex = line.length() - 1;
            String  digit = "";
            for (int i = 0; i < line.length(); i++) {
                stringLeftDigit = findDigit(stringLeftDigit, line, i, line.substring(0, i + 1));
                stringRightDigit = findDigit(stringRightDigit, line, lastIndex, line.substring(lastIndex));
                lastIndex--;
            }

            digit = String.valueOf(stringLeftDigit ) + String.valueOf(stringRightDigit);
            count += Integer.parseInt(digit);
        }

        System.out.println(count);
    }

    private static Integer findDigit(Integer stringDigit, String line, int index, String subString) {
        if (stringDigit == -1 && Character.isDigit(line.charAt(index))) {
            stringDigit = Integer.parseInt(String.valueOf(line.charAt(index)));
        } else if (stringDigit == -1) {
            stringDigit = checkForStringDigits(subString);
        }

        return stringDigit;
    }

    private static Integer checkForStringDigits(String line) {
        for (Map.Entry<String, Integer> entry : mapOfDigit().entrySet()) {
            if(line.contains(entry.getKey())){
                return entry.getValue();
            };
        }
        return -1;
    }

    private static Map<String, Integer> mapOfDigit(){
        Map<String,Integer> mapOfString = new HashMap<>();
        mapOfString.put("one", 1);
        mapOfString.put("two", 2);
        mapOfString.put("three", 3);
        mapOfString.put("four", 4);
        mapOfString.put("five", 5);
        mapOfString.put("six", 6);
        mapOfString.put("seven", 7);
        mapOfString.put("eight", 8);
        mapOfString.put("nine", 9);

        return mapOfString;
    }
}