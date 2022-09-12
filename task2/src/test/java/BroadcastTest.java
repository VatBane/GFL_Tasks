import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import shows.Advertisement;
import shows.Interview;
import shows.Show;
import shows.Song;

import javax.naming.InsufficientResourcesException;
import java.time.Duration;
import java.util.*;

public class BroadcastTest {
    private Broadcast broadcast;

    @Test
    void nextTest() {
        Show add = new Advertisement(30, "mobile");
        Show inter = new Interview(4, "Viktor");

        Queue<Show> list = new LinkedList<>();
        list.add(new Advertisement(20, "Apple watch"));
        list.add(new Song(167, "I prevail", "Let me be sad"));
        list.add(add);
        list.add(inter);

        Schedule schedule = new Schedule(list);

        Queue<Show> expectedList = new LinkedList<>();
        expectedList.add(add);
        expectedList.add(inter);

        Schedule expSchedule = new Schedule(expectedList);

        broadcast = new BroadcastImpl(schedule);

        broadcast.next();
        broadcast.next();

        Assertions.assertEquals(expSchedule, broadcast.getSchedule());
    }

    @Test
    void tooMuchDurationTest() throws Exception {
        broadcast = new BroadcastImpl(2);

        broadcast.addShow(new Advertisement(20, "SongCloud"));

        Assertions.assertThrows(Exception.class, () -> {
            broadcast.addShow(new Interview(2, "Vasya"));
        });
    }

    @Test
    void tooMuchPaidDurationTest() throws Exception {
        broadcast = new BroadcastImpl(2);

        Assertions.assertThrows(Exception.class, () -> {
            broadcast.addShow(new Interview(2, "Vasya"));
        });
    }
}
