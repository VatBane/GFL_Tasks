package presenters;

import shows.Show;

import java.util.List;

public class RegularPresenter implements Presenter {
    private String name;
    private List<Show> shows;
    private int experience;

    public RegularPresenter (String name, List<Show> shows, int experience) {
        this.name = name;
        this.shows = shows;
        this.experience = experience;
    }

    public int getExperience() {
        return this.experience;
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
