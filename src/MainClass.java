import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

public class MainClass {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws IOException {
//      Fruit apple = new Fruit(FruitsType.APPLE, 23, new GregorianCalendar(2019,3,12), 23);
//      Fruit banana = new Fruit(FruitsType.BANANA, 23, new GregorianCalendar(2018,4,11), 230);
//        List<Fruit> fruitList = new ArrayList<>();
//        fruitList.add(apple);
//        fruitList.add(banana);

//        String json = GSON.toJson(apple);
//        String json1 = GSON.toJson(banana);
//        System.out.println(json);
//        System.out.println(json1);

        TradeShop tradeShop = new TradeShop();
        tradeShop.addFruits(tradeShop.getPathToJsonFile());

        List<Fruit> fruitList = tradeShop.getAvailableFruits(new GregorianCalendar(2019, 0, 0), FruitsType.BANANA);
        for (Fruit f : fruitList) {
          System.out.println(f);
        }
//        tradeShop.save(tradeShop.getPathToJsonFile(), fruitList);

//        try {
//            tradeShop.save(tradeShop.pathToJsonFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
