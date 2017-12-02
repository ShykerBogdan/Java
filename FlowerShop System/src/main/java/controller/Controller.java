package controller;

import model.Model;
import model.enteties.Bouquet;
import model.enteties.Flower;
import view.View;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by Gatsby on 5/20/2017.
 */
public class Controller {
    View view;
    Model model;
    Scanner scanner;
    ResourceBundle bundle;
    DataBaseUtilitiesController dataController;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void processUser() throws SQLException, ClassNotFoundException {
        dataController = new DataBaseUtilitiesController();
        scanner = new Scanner((System.in));
        int choice;
        bundle = ResourceBundle.getBundle("FlowersBundle", new Locale("EN", "US"));
        do {
            choice = inputInt (View.LANGUAGE);
            if(choice == 2)
                bundle = ResourceBundle.getBundle("FlowersBundle", new Locale("RU", "RU"));
        }while(choice > 2 && choice < 1);

        do {
            choice = inputInt(bundle.getString(view.MENU));
            switch (choice) {
                case 1:
                    getBouqetsFromDatabase();
                    break;
                case 2:
                    addBouquetToDatabase();
                    break;
                case 3:
                    getFlowersFromDatabase();
                    break;
                case 4:
                    addFlowerToDatabase();
                    break;
            }
        }while(choice != 5);
    }

    private void getBouqetsFromDatabase() throws SQLException {
        ArrayList<Bouquet> list = dataController.loadBouquets();
        view.printBouquets(list, bundle);
    }

    private void addBouquetToDatabase() throws SQLException {
        LinkedHashMap<Flower, Integer> flowers = choosedLoadFlowers();

        model.createBouquet(
                inputString(bundle.getString(view.BOUQUET_NAME)),
                inputString(bundle.getString(view.BOUQUET_ACCESSORY)),
                flowers);
        dataController.insertBouquet(model.getBouquet());
    }

    private LinkedHashMap<Flower, Integer> choosedLoadFlowers() throws SQLException {
        ArrayList<Flower> list = dataController.loadFlowers();
        LinkedHashMap<Flower, Integer> flowers = new LinkedHashMap<Flower, Integer>();
        //Map<Flower, Integer> flowers = new HashMap<Flower, Integer>();
        String name;
        int count;
        do {
            view.printLn(bundle.getString(view.CHOOSE_FLOWER));
            view.printFlowers(list, bundle);
            name = inputString(bundle.getString(view.FLOWER_NAME));
            if(name.equals("stop"))
                break;
            for(Flower item : list)
            {
                    if(item.getName().equals(name)) {
                    count = inputInt(bundle.getString(view.FLOWER_COUNT));
                    flowers.put(item, count);
                    list.remove(item);
                    break;
                }
            }
        }while (!list.isEmpty());
        return flowers;
    }

    private void getFlowersFromDatabase() throws SQLException {
        ArrayList<Flower> list = dataController.loadFlowers();
        view.printFlowers(list, bundle);
    }

    private void addFlowerToDatabase() throws SQLException {
        final Flower flower = new Flower(
                inputString(bundle.getString(view.FLOWER_NAME)),
                inputDouble(bundle.getString(view.FLOWER_STEEM_SIZE)),
                new Date(),
                inputDouble(bundle.getString(view.FLOWER_PRICE)));
        dataController.insertFlower(flower);
    }

    private int inputInt(String enterString)
    {
        view.printLn(enterString);
        while(!scanner.hasNextInt())
        {
            view.printLn (bundle.getString(view.WRONG_DATA));
            scanner.next();
        }
        return scanner.nextInt();
    }

    private double inputDouble(String enterString)
    {
        view.printLn(enterString);
        while(!scanner.hasNextDouble())
        {
            view.printLn (bundle.getString(view.WRONG_DATA));
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private String inputString(String enterString)
    {
        view.printLn (enterString);
        scanner.hasNext();
        return scanner.next();
    }
}
