package shows;

public class Song implements Show {
    private final long duration;
    private String author;
    private String title;

    public Song(int seconds, String author, String title) {
        this.duration = seconds;
        this.author = author;
        this.title = title;
    }

    @Override
    public long getDuration() {
        return duration;
    }
}
