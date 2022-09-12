import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presenters.RegularPresenter;
import shows.Advertisement;
import shows.Interview;
import shows.Show;
import shows.Song;

import java.time.Duration;
import java.util.LinkedList;
import java.util.Queue;

public class SnapshotTest {
    private Broadcast broadcast;
    private Snapshot snapshot;

    @BeforeEach
    void setUp() {
        Queue<Show> list = new LinkedList<>();

        list.add(new Interview(10, "Kostya"));
        list.add(new Interview(15, "Lesya"));
        list.add(new Song(180, "The veer union", "Soul of the beautiful"));
        list.add(new Advertisement(10, "cs go"));

        broadcast = new BroadcastImpl(new Schedule(list));
        snapshot = broadcast.createSnapshot();
    }

    @Test
    void snapshotTest() {
        Assertions.assertEquals(snapshot, broadcast.createSnapshot());
    }

    @Test
    void afterChangesTest() {
        snapshot = new Snapshot(broadcast, broadcast.getSchedule(), 0);
        snapshot.getSchedule().remove();

        broadcast.next();

        Assertions.assertEquals(snapshot, broadcast.createSnapshot());
    }

}
