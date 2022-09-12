package shows;

import java.time.Duration;

public class Advertisement implements PaidShow {
    private String product;
    private final long duration;

    public Advertisement(int seconds, String product) {
        this.product = product;
        this.duration = seconds;
    }

    @Override
    public float getPrice() {
        return 5;
    }

    @Override
    public long getDuration() {
        return duration;
    }

    public String getProduct() {
        return product;
    }
}
