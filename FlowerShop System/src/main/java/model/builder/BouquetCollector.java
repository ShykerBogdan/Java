package model.builder;

import model.enteties.Bouquet;
import model.enteties.Flower;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by Gatsby on 5/22/2017.
 */
public class BouquetCollector extends AbstractCollector {
    Bouquet bouquet;

    public BouquetCollector() {
        this.bouquet = new Bouquet();
    }

    @Override
    public Bouquet getResult() {
        return bouquet;
    }

    @Override
    public void setBouquetName(String name) {
        bouquet.setName(name);
    }

    @Override
    public void collectBouquet(LinkedHashMap<Flower, Integer> flowers){
        bouquet.setFlowers(flowers);
    }

    @Override
    public void putAccessory(String accessory) {
        bouquet.setAccessory(accessory);
    }
}
