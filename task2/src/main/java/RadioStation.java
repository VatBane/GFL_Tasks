import java.util.concurrent.TimeUnit;

/**
 * Данный класс управляет трансляцией и заодно
 * является "опекуном" паттерна Снимок
 *
 * Я видел, что сохраняемый объект должен уметь создавать снимок,
 * но не хранить его, а хранить должен "опекун"
 * к тому же, если возникнут проблемы с трансляцией
 * (перехваты не реализовывал) можно отсюда же восстановить ее
 */

public class RadioStation {
    private Broadcast broadcast;
    private Snapshot snapshot;

    public RadioStation(Broadcast broadcast) {
        this.broadcast = broadcast;
    }

    public void play() throws InterruptedException {
        System.out.println(broadcast.getSchedule().peek());

        // заглушка как будто идет трансляция
        TimeUnit.SECONDS.sleep(broadcast.getDuration());
        this.next();
    }

    private void next() throws InterruptedException {
        broadcast.next();
        if (!broadcast.getSchedule().isEmpty()) {
            snapshot = broadcast.createSnapshot();
            this.play();
        } else {
            this.end();
        }
    }

    private void end() {
        System.out.println("Translation has ended!");
    }

    public void setBroadcast(Broadcast broadcast) {
        this.broadcast = broadcast;
    }
}
