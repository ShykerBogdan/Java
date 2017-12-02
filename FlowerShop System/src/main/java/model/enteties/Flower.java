package model.enteties;

import java.util.Date;

/**
 * Created by Gatsby on 5/22/2017.
 */
public class Flower {
    private String name;
    private double stemSize;
    private Date dateImport;
    private Double price;
    private Integer id;

    public Flower(String name, double stemSize, Date dateImport, double price) {
        this.name = name;
        this.stemSize = stemSize;
        this.dateImport = dateImport;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getStemSize() {
        return stemSize;
    }

    public Date getDateImport() {
        return dateImport;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStemSize(double stemSize) {
        this.stemSize = stemSize;
    }

    public void setDateImport(Date dateImport) {
        this.dateImport = dateImport;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
