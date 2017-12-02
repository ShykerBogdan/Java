package view;

import model.enteties.Bouquet;
import model.enteties.Flower;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.ResourceBundle;

/**
 * Created by Gatsby on 5/22/2017.
 */
public class View {

    public static final String  LANGUAGE = "Choose your language:\n" +
            "1 - English\n" +
            "2 - Russian\n";

    public final String MENU = "Menu";
    public final String WRONG_DATA = "WrongData";
    public final String BOUQUET_NAME = "BouquetName";
    public final String BOUQUET_ACCESSORY = "BouquetAccessory";
    public final String INPUT_FLOWERS = "InputFlowers";
    public final String FLOWER_NAME = "FlowersName";
    public final String FLOWER_STEEM_SIZE = "FlowersSteemSize";
    public final String FLOWER_PRICE = "FlowersPrice";
    public final String FLOWER_COUNT = "FlowerCount";
    public final String CHOOSE_FLOWER = "ChooseFlower";

    public void printBouquets(Collection<Bouquet> bouquets, ResourceBundle bundle){
        for(Bouquet item : bouquets)
        {
            printLn(item.getId() + ") " + item.getName());
            for(Entry<Flower, Integer> flower : item)
                printLn("\t" + flower.getKey().getName() + ", count: " + flower.getValue() + ", price: " + flower.getKey().getPrice());
        }
    }

    public void printFlowers(Collection<Flower> flowers, ResourceBundle bundle){
        for(Flower item : flowers)
            printLn(item.getId() + ") " + item.getName() + ", steam size: " + item.getStemSize() + ", " + item.getPrice());
    }

    public void printLn(String str){
        System.out.println(str);
    }
}
