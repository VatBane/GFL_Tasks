import shows.Show;

import java.time.Duration;
import java.util.Queue;

public interface Broadcast {
    void addShow(Show show) throws Exception;

    Schedule getSchedule();

    long getDuration();

    void next();
    
    Snapshot createSnapshot();
}
