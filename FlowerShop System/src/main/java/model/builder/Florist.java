package model.builder;

import model.enteties.Bouquet;
import model.enteties.Flower;

import java.util.*;
import java.util.Map.Entry;

/**
 * Created by Gatsby on 5/22/2017.
 */
public class Florist {
    AbstractCollector collector;

    public Florist(AbstractCollector collector) {
        this.collector = collector;
    }

    public void collectBouquet(String name, String accessory, LinkedHashMap<Flower, Integer> flowers){
        collector.setBouquetName(name);
        collector.collectBouquet(flowers);
        collector.putAccessory(accessory);
    }
}
