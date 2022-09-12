package presenters;

import shows.Show;

import java.util.List;

public class GuestPresenter implements Presenter {
    private String name;
    private List<Show> shows;
    private String cv;

    public GuestPresenter(String name, List<Show> shows, String cv) {
        this.name = name;
        this.shows = shows;
        this.cv = cv;
    }

    public String getCV() {
        return this.cv;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Show> getShows() {
        return this.shows;
    }
}
