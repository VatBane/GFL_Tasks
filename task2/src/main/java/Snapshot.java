/**
 * Реализует паттерн снимок (Memento)
 * на случай проблем с трансляций
 * при переключении шоу делается снимок,
 * который можно потом сохранить просто или в файл (это не реализовал)
 */
public class Snapshot {
    private Broadcast broadcast;
    private Schedule schedule;
    private int duration;

    public Snapshot(Broadcast broadcast, Schedule schedule, int duration) {
        this.broadcast = broadcast;
        this.schedule = schedule;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object obj) {
        Snapshot snapshot = (Snapshot) obj;
        if (snapshot.broadcast != ((Snapshot) obj).broadcast)
            return false;
        if (snapshot.schedule != ((Snapshot) obj).schedule)
            return false;
        return snapshot.duration == ((Snapshot) obj).duration;
    }

    @Override
    public String toString() {
        return "Snapshot{" +
                "broadcast=" + broadcast +
                ", schedule=" + schedule +
                ", duration=" + duration +
                '}';
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Broadcast getBroadcast() {
        return broadcast;
    }

    public int getDuration() {
        return duration;
    }
}
