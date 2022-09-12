import shows.PaidShow;
import shows.Show;

import java.time.Duration;
import java.util.List;
import java.util.Queue;

public class Schedule {
    Queue<Show> schedule;

    public Schedule(Queue<Show> shows) {
        this.schedule = shows;
    }

    public long getDuration() {
        long duration = 0;
        for (Show show: schedule) {
            duration += show.getDuration();
        }

        return duration;
    }

    public long getPaidDuration() {
        long duration = 0;
        for (Show show: schedule) {
            if (show instanceof PaidShow)
                duration += show.getDuration();
        }

        return duration;
    }

    public void add(Show show) {
        schedule.add(show);
    }

    public void remove() {
        schedule.remove();
    }

    public Show peek() {
        return schedule.peek();
    }

    public boolean isEmpty() {
        return schedule.isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        return schedule.equals(((Schedule) obj).schedule);
    }

}
