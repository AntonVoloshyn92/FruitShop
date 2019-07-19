import com.google.gson.JsonSerializer;

import java.io.Serializable;
import java.util.*;

public class Fruit {
    private int shelfLife;
    private Calendar data;
    private int price;
    private FruitsType fruitsType;

    Fruit() {
    }

    Fruit(FruitsType fruitsType, int shelfLife, Calendar data, int price) {
        this.fruitsType = fruitsType;
        this.shelfLife = shelfLife;
        this.data = data;
        this.price = price;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public Calendar getData() {
        return data;
    }

    public int getPrace() {
        return price;
    }

    public FruitsType getFruitsType() {
        return fruitsType;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "shelfLife=" + shelfLife + "\n" +
                ", data=" + data.get(Calendar.YEAR) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.DAY_OF_MONTH) + "\n" +
                ", price=" + price + "\n" +
                ", fruitsType=" + fruitsType + "\n" +
                '}';
    }

    public class FruitSeria implements Serializable{
        
    }
}

