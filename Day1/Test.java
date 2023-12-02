package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Test {
    private static int totalProduces = 0;
    private static int totalCalibrationValue = 0;

    // Reads the file
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Day 1/input.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            totalCalibrationValue += getCalibrationValue(line);
            totalProduces += getCalibrationValueForStringDigits(line);
        }
        System.out.println(totalCalibrationValue);
        System.out.println(totalProduces);
    }

    //Part 1
    private static Integer getCalibrationValue(String line) {
        ArrayList<String> ints = new ArrayList<String>();
        for (String s : line.split("")) {
            try {
                Integer.parseInt(s);
                ints.add(s);
            } catch (NumberFormatException err) {}
        }

        return Integer.parseInt(ints.getFirst() + ints.getLast());
    }

    //Part 2
    private static int getCalibrationValueForStringDigits(String line) {
        Integer stringLeftDigit = -1;
        Integer stringRightDigit = -1;
        int lastIndex = line.length() - 1;
        String  digit = "";
        for (int i = 0; i < line.length(); i++) {
            stringLeftDigit = findDigit(stringLeftDigit, line, i, line.substring(0, i + 1));
            stringRightDigit = findDigit(stringRightDigit, line, lastIndex, line.substring(lastIndex));
            lastIndex--;
        }

        digit = String.valueOf(stringLeftDigit ) + String.valueOf(stringRightDigit);
        return Integer.parseInt(digit);

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