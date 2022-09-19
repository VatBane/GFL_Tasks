package model;

public class Manufacturer {
    private long id;
    private String title;
    private String country;

    public Manufacturer(long id, String title, String country) {
        this.id = id;
        this.title = title;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
