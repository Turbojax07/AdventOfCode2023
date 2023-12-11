package Day3;

import java.io.*;
import java.util.*;

public class Test {
    private static final ArrayList<String> input = new ArrayList<>();
    private static final Map<Pair, String> symbolMap = new HashMap<>();
    private static final Map<Pair, Integer> numberMap = new HashMap<>();
    private static final Set<Pair> gears = new HashSet<>();

    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Day3/input.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }

        System.out.println(runPart2());
    }

    public static void getSymbols() {
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).length(); j++) {
                if (input.get(i).substring(j, j+1).matches("[^.0-9]")) {
                    symbolMap.put(new Pair(i, j), input.get(i).substring(j, j+1));
                }
                if (input.get(i).substring(j, j+1).matches("\\*")) {
                    gears.add(new Pair(i, j));
                }
            }
        }
    }

    public static void fromMapGetNumbers() {
        for (Pair coord: symbolMap.keySet()) {
            for (Pair adj: checkAdjacent(coord)) {
                expandNum(adj);
            }
        }
    }

    private static Pair expandNum(Pair coord) {
        int start = coord.getY(), end = coord.getY() + 1;
        while (start >= 0 && input.get(coord.getX()).substring(start, end).matches("^\\d+$")) {
            start--;
        }
        start++;

        while (end <= input.get(coord.getX()).length() && input.get(coord.getX()).substring(start, end).matches("^\\d+$")) {
            end++;
        }
        end--;

        Pair key = new Pair(coord.getX(), start);
        Integer value = Integer.parseInt(input.get(coord.getX()).substring(start, end));
        if (!numberMap.containsKey(key)) {
            numberMap.put(key, value);
        }

        return key;
    }

    public static ArrayList<Pair> checkAdjacent(Pair coord) {
        ArrayList<Pair> adj = new ArrayList<>();
        for (Pair p : coord.getAdjacent()) {
            try {
                if (input.get(p.getX()).substring(p.getY(), p.getY() + 1).matches("\\d")) {
                    adj.add(p);
                }
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        return adj;
    }

    public static Object runPart1() {
        getSymbols();
        fromMapGetNumbers();

        int sum = 0;
        for (int x : numberMap.values().toArray(new Integer[numberMap.values().size()])) {
            sum += x;
        }
        return sum;
    }

    public static Object runPart2() {
        getSymbols();
        fromMapGetNumbers();

        int s = 0;

        for (Pair g : gears) {
            HashSet<Pair> adj = new HashSet<>();
            for (Pair coord : checkAdjacent(g)) {
                adj.add(expandNum(coord));
            }

            if (adj.size() == 2) {
                int m = 1;
                for (Pair c : adj) {
                    m *= numberMap.get(c);
                }
                s += m;
            }
        }

        return s;
    }

}