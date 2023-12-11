package Day5;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Day5 {
    public static void part1(Scanner input) {
        String text = "";
        while (input.hasNextLine()) {
            text += input.nextLine() + "\n";
        }

        // Creates a large array containing all the information
        ArrayList<String> maps = new ArrayList<String>(Arrays.asList(text.split("\n\n")));

        // Splitting the main array into multiple specialized groups.
        ArrayList<String> seeds = new ArrayList<String>(Arrays.asList(maps.get(0).split(" ")));
        ArrayList<String> seedToSoilArr = new ArrayList<String>(Arrays.asList(maps.get(1).split("\n")));
        ArrayList<String> soilToFertilizerArr = new ArrayList<String>(Arrays.asList(maps.get(2).split("\n")));
        ArrayList<String> fertilizerToWaterArr = new ArrayList<String>(Arrays.asList(maps.get(3).split("\n")));
        ArrayList<String> waterToLightArr = new ArrayList<String>(Arrays.asList(maps.get(4).split("\n")));
        ArrayList<String> lightToTempArr = new ArrayList<String>(Arrays.asList(maps.get(5).split("\n")));
        ArrayList<String> tempToHumidityArr = new ArrayList<String>(Arrays.asList(maps.get(6).split("\n")));
        ArrayList<String> humidityToDestArr = new ArrayList<String>(Arrays.asList(maps.get(7).split("\n")));

        // Removing the label from each specialized group.
        seeds.remove(0);
        seedToSoilArr.remove(0);
        soilToFertilizerArr.remove(0);
        fertilizerToWaterArr.remove(0);
        waterToLightArr.remove(0);
        lightToTempArr.remove(0);
        tempToHumidityArr.remove(0);
        humidityToDestArr.remove(0);

        // Creating the HashMaps
        HashMap<Double, Double> seedToSoilMap = new HashMap<Double,Double>();
        HashMap<Double, Double> soilToFertilizerMap = new HashMap<Double,Double>();
        HashMap<Double, Double> fertilizerToWaterMap = new HashMap<Double,Double>();
        HashMap<Double, Double> waterToLightMap = new HashMap<Double,Double>();
        HashMap<Double, Double> lightToTempMap = new HashMap<Double,Double>();
        HashMap<Double, Double> tempToHumidityMap = new HashMap<Double,Double>();
        HashMap<Double, Double> humidityToDestMap = new HashMap<Double,Double>();

        for (String line : seedToSoilArr) {
            String[] values = line.split(" ");
            double seedVal = Double.parseDouble(values[0]);
            double destVal = Double.parseDouble(values[1]);
            double size = Double.parseDouble(values[2]);

            for (double i = 0; i < size; i++){
                seedToSoilMap.put(seedVal + i, destVal + i);
            }
        }

        for (String line : soilToFertilizerArr) {
            String[] values = line.split(" ");
            double seedVal = Double.parseDouble(values[0]);
            double destVal = Double.parseDouble(values[1]);
            double size = Double.parseDouble(values[2]);

            for (double i = 0; i < size; i++){
                soilToFertilizerMap.put(seedVal + i, destVal + i);
            }
        }

        for (String line : fertilizerToWaterArr) {
            String[] values = line.split(" ");
            double seedVal = Double.parseDouble(values[0]);
            double destVal = Double.parseDouble(values[1]);
            double size = Double.parseDouble(values[2]);

            for (double i = 0; i < size; i++){
                fertilizerToWaterMap.put(seedVal + i, destVal + i);
            }
        }

        for (String line : waterToLightArr) {
            String[] values = line.split(" ");
            double seedVal = Double.parseDouble(values[0]);
            double destVal = Double.parseDouble(values[1]);
            double size = Double.parseDouble(values[2]);

            for (double i = 0; i < size; i++){
                waterToLightMap.put(seedVal + i, destVal + i);
            }
        }

        for (String line : lightToTempArr) {
            String[] values = line.split(" ");
            double seedVal = Double.parseDouble(values[0]);
            double destVal = Double.parseDouble(values[1]);
            double size = Double.parseDouble(values[2]);

            for (double i = 0; i < size; i++){
                lightToTempMap.put(seedVal + i, destVal + i);
            }
        }

        for (String line : tempToHumidityArr) {
            String[] values = line.split(" ");
            double seedVal = Double.parseDouble(values[0]);
            double destVal = Double.parseDouble(values[1]);
            double size = Double.parseDouble(values[2]);

            for (double i = 0; i < size; i++){
                tempToHumidityMap.put(seedVal + i, destVal + i);
            }
        }

        for (String line : humidityToDestArr) {
            String[] values = line.split(" ");
            double seedVal = Double.parseDouble(values[0]);
            double destVal = Double.parseDouble(values[1]);
            double size = Double.parseDouble(values[2]);

            for (double i = 0; i < size; i++){
                humidityToDestMap.put(seedVal + i, destVal + i);
            }
        }

        double min = 0;
        for (String seedStr : seeds){
            double seed = Double.parseDouble(seedStr);
            double soil = seedToSoilMap.getOrDefault(seed, seed);
            double fertilizer = soilToFertilizerMap.getOrDefault(soil, soil);
            double water = fertilizerToWaterMap.getOrDefault(fertilizer, fertilizer);
            double light = waterToLightMap.getOrDefault(water, water);
            double temp = lightToTempMap.getOrDefault(light, light);
            double humidity = tempToHumidityMap.getOrDefault(temp, temp);
            double dest = humidityToDestMap.getOrDefault(humidity, humidity);

            if (min == 0) {
                min = dest;
            } else if (dest < min) {
                min = dest;
            }
        }
        System.out.println(min);
    }
    
    public static void part2(Scanner input) {}
}