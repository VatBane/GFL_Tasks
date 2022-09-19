import shows.Show;

import java.time.Duration;
import java.util.LinkedList;
import java.util.Queue;

public class BroadcastImpl implements Broadcast {
    private Schedule schedule;
    private long duration;

    // по готовому расписанию
    public BroadcastImpl(Schedule schedule) {
        this.schedule = schedule;
        this.duration = schedule.getDuration();
    }

    // создаем по выделенному на трансляцию времени,
    // а потом дополняем
    public BroadcastImpl(long minutes) {
        this.duration = minutes * 60L;
        this.schedule = new Schedule(new LinkedList<>());
    }

    public void addShow(Show show) throws Exception {
        if (this.isFit(show.getDuration())) {
            schedule.add(show);
        } else {
            throw new Exception("Not enough time to add this show!");
        }
    }

    private boolean isFit(long duration) {
        if (this.duration - duration < duration)
            return false;
        return schedule.getPaidDuration() <= this.duration / 2;

    }

    @Override
    public Schedule getSchedule() {
        return schedule;
    }

    @Override
    public long getDuration() {
        return duration;
    }

    @Override
    public void next() {
        this.schedule.remove();
    }

    // memento
    // на случай сбоя в работе или паузы делается снимок,
    // с которого можно будет восстановаить трансляцию
    @Override
    public Snapshot createSnapshot() {
        return new Snapshot(this, schedule, 0);
    }

}
