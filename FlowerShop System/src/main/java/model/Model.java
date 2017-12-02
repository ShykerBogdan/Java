package model;

import model.builder.AbstractCollector;
import model.builder.BouquetCollector;
import model.builder.Florist;
import model.enteties.Bouquet;
import model.enteties.Flower;

import java.util.*;

/**
 * Created by Gatsby on 5/22/2017.
 */
public class Model {
    Bouquet bouquet;
    Florist florist;
    AbstractCollector abstractCollector;

    public  Model(){
        abstractCollector = new BouquetCollector();
        florist = new Florist(abstractCollector);
    }

    public void setBouquet(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    public void createBouquet(String name, String accessory, LinkedHashMap<Flower, Integer> flowers){
        florist.collectBouquet(name, accessory, flowers);
        bouquet = abstractCollector.getResult();
    }

    public Bouquet getBouquet() {
        return bouquet;
    }
}
