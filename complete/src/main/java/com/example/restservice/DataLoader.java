package com.example.restservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Class loads the data from csv file and provides Dataholder Class Betriebsstelle as list.
 */
public class DataLoader {
    public HashMap<String,Betriebsstelle> initializeData(){

        HashMap<String,Betriebsstelle> betriebsstellen = new HashMap();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource("DBNetz-Betriebsstellenverzeichnis-Stand2021-10.csv").getFile());
        List<List<String>> records= new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(List<String> line : records){
            String[] e = new String[line.size()];
            int i = 0;
            for(String cell : line){
                e[i] = cell.toLowerCase();
                i++;
            }
            betriebsstellen.put(e[1],new Betriebsstelle(e[2],e[3],e[5]));
        }
        return betriebsstellen;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter("(?<=;)");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next().replaceAll(";", ""));
            }
        }
        return values;
    }
}
