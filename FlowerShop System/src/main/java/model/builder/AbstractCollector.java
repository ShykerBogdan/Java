package model.builder;

import model.enteties.Bouquet;
import model.enteties.Flower;

import java.util.*;
import  java.util.Map.Entry;

/**
 * Created by Gatsby on 5/22/2017.
 */
public abstract class AbstractCollector {
    public abstract Bouquet getResult();
    public abstract void setBouquetName(String name);
    public abstract void collectBouquet(LinkedHashMap<Flower, Integer> flowers);
    public abstract void putAccessory(String accessory);
}
