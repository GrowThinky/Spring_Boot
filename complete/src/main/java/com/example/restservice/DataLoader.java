package com.example.restservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class loads the data from csv file and provides Dataholder Class Betriebsstelle as list.
 */
public class DataLoader {
    public List<Betriebsstelle> initializeData(){

        List<Betriebsstelle> betriebsstellen = new ArrayList<>();
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
            betriebsstellen.add(new Betriebsstelle(e[1],e[2],e[3],e[5]));
            // betriebsstellen.add(new BetriebsstelleAlleInfos(e[0],e[1],e[2],e[3],e[4],e[5],e[6],e[7],e[8],e[9],e[10],e[11]));
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
