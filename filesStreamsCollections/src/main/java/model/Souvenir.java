package model;

import java.util.Date;

public class Souvenir {
    private String title;
    private Manufacturer manufacturer;
    private Date date;
    private double price;

    public Souvenir(String title, Manufacturer manufacturer, Date date, double price) {
        this.title = title;
        this.manufacturer = manufacturer;
        this.date = date;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Souvenir{" +
                "title='" + title + '\'' +
                ", manufacturer=" + manufacturer +
                ", date=" + date +
                ", price=" + price +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

