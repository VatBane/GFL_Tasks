package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Souvenir {
    private long id;

    private String title;

    private String manufacturer;
    private LocalDate date;
    private double price;

    public Souvenir(long id, String title, String manufacturer, LocalDate date, double price) {
        this.id = id;
        this.title = title;
        this.manufacturer = manufacturer;
        this.date = date;
        this.price = price;
    }

    public static Souvenir fromLine(String s) {
        if (s.isEmpty()) return null;
        String[] params = s.split(",");
        return new Souvenir(Long.parseLong(params[0]), params[1],
                params[2], LocalDate.parse(params[3]),
                Double.parseDouble(params[4]));
    }

    @Override
    public String toString() {
        return  "title='" + title + '\'' +
                ", manufacturer=" + manufacturer +
                ", date=" + date +
                ", price=" + price;
    }

    public String toFile() {
        return id + "," + title + "," + manufacturer + "," + date + "," + price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

