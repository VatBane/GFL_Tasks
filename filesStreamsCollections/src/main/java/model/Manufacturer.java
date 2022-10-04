package model;

import java.util.Objects;

public class Manufacturer {
    private String title;
    private String country;

    public Manufacturer(String title, String country) {
        this.title = title;
        this.country = country;
    }

    @Override
    public String toString() {
        return "title='" + title + "', country='" + country;
    }

    public String toFile() {
        return title + "," + country;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static Manufacturer fromLine(String s) {
        if (s.isEmpty()) return null;
        String[] params = s.split(",");
        return new Manufacturer(params[0], params[1]);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Manufacturer))
            return false;
        if (!title.equals(((Manufacturer) obj).title))
            return false;
        return country.equals(((Manufacturer) obj).country);
    }

    @Override
    public int hashCode() {
        return title.hashCode() + country.hashCode();
    }
}
