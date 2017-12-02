package model.enteties;

import java.util.*;
import java.util.function.Consumer;
import java.util.Map.Entry;

/**
 * Created by Gatsby on 5/22/2017.
 */
public class Bouquet implements Iterable<Entry<Flower, Integer>>{
    private Integer id;
    private String name;
    private String accessory;
    private LinkedHashMap<Flower, Integer> flowers;

    public Bouquet(){
        flowers = new LinkedHashMap<Flower, Integer>();
    }

    public Bouquet(String name, String accessory) {
        this.name = name;
        this.accessory = accessory;
        flowers = new LinkedHashMap<Flower, Integer>();
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public boolean contains(Flower flower){
        return flowers.containsValue(flower);
    }

    public LinkedHashMap<Flower, Integer> getFlowers(){
        return flowers;
    }

    public void setFlowers(LinkedHashMap<Flower, Integer> flowers){
        this.flowers = flowers;
    }

    public void add(Flower flower, int count){
        flowers.put(flower, count);
    }

    public void remuve(Flower flower){
        flowers.remove(flower);
    }

    public void sort(){
        ArrayList<Entry<Flower, Integer>> list = new ArrayList<Entry<Flower, Integer>>(flowers.entrySet());
        list.sort(new Comparator<Entry<Flower, Integer>>() {
            public int compare(Entry<Flower, Integer> o1, Entry<Flower, Integer> o2) {
                return o1.getKey().getDateImport().compareTo(o2.getKey().getDateImport());
            }
        });
        flowers = new LinkedHashMap<Flower, Integer>();
        for (Entry<Flower, Integer> entry : list)
        {
            flowers.put(entry.getKey(), entry.getValue());
        }
    }

    public ArrayList<Flower> getFlowersFromStemRange(double lowerBound, double upperBound){
        ArrayList<Flower> list = new ArrayList<Flower>();
        for(Flower item : flowers.keySet()){
            if(item.getStemSize() >= lowerBound && item.getStemSize() <= upperBound)
                list.add(item);
        }
        return  list;
    }

    public Iterator<Entry<Flower, Integer>> iterator() {
        return flowers.entrySet().iterator();
    }

}
