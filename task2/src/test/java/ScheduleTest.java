import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shows.Advertisement;
import shows.Interview;
import shows.Show;
import shows.Song;

import java.time.Duration;
import java.util.LinkedList;
import java.util.Queue;

public class ScheduleTest {
    @Test
    void getDurationTest() {
        Queue<Show> list = new LinkedList<>();
        list.add(new Advertisement(10, "Java"));
        list.add(new Advertisement(10, "Viknaroff"));
        Schedule schedule = new Schedule(list);

        Assertions.assertEquals(schedule.getDuration(), 20);
    }

    @Test
    void getPaidDurationTest() {
        Queue<Show> list = new LinkedList<>();
        list.add(new Advertisement(10, "antiPR"));
        list.add(new Song(10, "Normandie", "White flag"));
        Schedule schedule = new Schedule(list);

        Assertions.assertEquals(schedule.getPaidDuration(), 10);
    }
}
