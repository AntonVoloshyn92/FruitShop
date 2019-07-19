import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


public class TradeShop {

    private final String pathToJsonFile = "/Users/antonvoloshyn/Desktop/Banana.json";

    public String getPathToJsonFile() {
        return pathToJsonFile;
    }

    public List<Fruit> getListFru() {
        return listFru;
    }

    List<Fruit> listFru = new ArrayList<>();

    public void addFruits(String pathToJsonFile) {
       try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToJsonFile))) {

           JsonParser parser = new JsonParser();
           JsonArray array = (JsonArray) parser.parse(new FileReader(pathToJsonFile));
           Gson gson = new Gson();
           for (JsonElement o : array) {
               // TODO: 2019-05-18 make custom parser for object
               Fruit fruit = gson.fromJson(o.toString(), Fruit.class);
               listFru.add(fruit);
           }
       } catch (IOException e){
           e.printStackTrace();
       }
    }


    void save(String pathToJsonFile, List<Fruit> listFru) {
        try (FileOutputStream os = new FileOutputStream(pathToJsonFile, false)) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String temp = gson.toJson(listFru);
            bw.append(temp);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void load(String pathToJsonFile) {
        listFru.clear();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToJsonFile))) {
            JsonParser parser = new JsonParser();
            JsonArray array = (JsonArray) parser.parse(new FileReader(pathToJsonFile));
            Gson gson = new Gson();
            for (JsonElement o : array) {
                Fruit fruit = gson.fromJson(o.toString(), Fruit.class);
                listFru.add(fruit);
            }
            bufferedReader.close();
//            for (Fruit fruit1 : listFru) {
//                System.out.println(fruit1);
//            }
            listFru.stream().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public List<Fruit> getSpoiledFruits(GregorianCalendar date) {
        List<Fruit> spoiledFruits = new ArrayList<>();
        // TODO: 2019-05-18 stream 
//        for (Fruit fru : listFru) {
//            if (Utils.daysBetween((GregorianCalendar) fru.getData(), date) > fru.getShelfLife()) {
//                spoiledFruits.add(fru);
//            }
//        }

        listFru.stream().forEach((x)->{
            if (Utils.daysBetween((GregorianCalendar) x.getData(), date)>x.getShelfLife()){
                spoiledFruits.add(x);
            }
        });
        return spoiledFruits;
    }

    public List<Fruit> getSpoiledFruits(GregorianCalendar date, FruitsType fruitsType) {
        List<Fruit> spoiledFruits = new ArrayList<>();
        for (Fruit fru : listFru) {
            if (Utils.daysBetween((GregorianCalendar) fru.getData(), date) > fru.getShelfLife() && fru.getFruitsType().equals(fruitsType)) {
                spoiledFruits.add(fru);
            }
        }
        return spoiledFruits;
    }

    List<Fruit> getAvailableFruits(GregorianCalendar date) {
        List<Fruit> availableFruits = new ArrayList<>();
        for (Fruit fru : listFru) {
            System.out.println(Utils.daysBetween((GregorianCalendar) fru.getData(), date));
            if (Utils.daysBetween((GregorianCalendar) fru.getData(), date) < fru.getShelfLife()) {
                availableFruits.add(fru);
            }
        }
        return availableFruits;
    }

    List<Fruit> getAvailableFruits(GregorianCalendar date, FruitsType fruitsType) {
        List<Fruit> availableFruits = new ArrayList<>();
        for (Fruit fru : listFru) {
            if (Utils.daysBetween((GregorianCalendar) fru.getData(), date) < fru.getShelfLife() && fru.getFruitsType().equals(fruitsType)) {
                availableFruits.add(fru);
            }
        }
        return availableFruits;
    }


}
