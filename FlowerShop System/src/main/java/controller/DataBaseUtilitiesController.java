package controller;

import model.enteties.Bouquet;
import model.enteties.Flower;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

public class DataBaseUtilitiesController implements ConnectionStrings, Queries {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public DataBaseUtilitiesController() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public ArrayList<Bouquet> loadBouquets() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(SELECT_BOUQUETS);
        ArrayList<Bouquet> list = new ArrayList<Bouquet>();
        Bouquet bouquet;
        int id = -1;
        while (resultSet.next()){
                bouquet = new Bouquet(resultSet.getString(2), resultSet.getString(3));
                id = resultSet.getInt(1);
                bouquet.setId(id);
                list.add(bouquet);
                do {
                    bouquet.add(new Flower(
                                    resultSet.getString(4),
                                    resultSet.getInt(5),
                                    resultSet.getDate(6),
                                    resultSet.getDouble(7)),
                            resultSet.getInt(8));
                }while (resultSet.next() && id == resultSet.getInt(1));
                resultSet.previous();
        }
        resultSet.close();
        return list;
    }

    public ArrayList<Flower> loadFlowers() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(SELECT_FLOWERS);
        ArrayList<Flower> list = new ArrayList<Flower>();
        while (resultSet.next()){
            Flower flower = new Flower(
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDate(5),
                    resultSet.getDouble(4));
            flower.setId(resultSet.getInt(1));
            list.add(flower);
        }
        resultSet.close();
        return list;
    }

    public void insertBouquet(Bouquet bouquet) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(INSERT_BOUQUET + "('" +
                bouquet.getAccessory() + "', '" +
                bouquet.getName() + "');");

        resultSet = statement.executeQuery(SELECT_LAST_BOUQUET_INDEX + bouquet.getName() + "';");
        resultSet.next();
        int id = resultSet.getInt(1);
        for(Map.Entry<Flower, Integer> item : bouquet) {
            statement.executeUpdate(INSERT_BOUQUET_DETAILS + "(" +
                    id + ", " +
                    item.getKey().getId() + ", " +
                    item.getValue() + ");");
        }
        resultSet.close();
    }

    public void insertFlower(Flower flower) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(INSERT_FLOWER + "('" +
                flower.getName() + "', " +
                flower.getStemSize() + ", " +
                flower.getPrice() + ", " +
                flower.getDateImport().getYear() + "-" + flower.getDateImport().getMonth() + "-" + flower.getDateImport().getDay() + ");");
    }
}
