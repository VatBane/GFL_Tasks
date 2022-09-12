package shows;

import presenters.Presenter;

public class Interview implements PaidShow, HasPresenter {
    private String guest;
    private final long duration;
    private Presenter presenter;

    public Interview(int minutes, String guest, Presenter presenter) {
        this.duration = minutes * 60L;
        this.guest = guest;
    }

    // заглушка, чтобы не использовать огромные конструкторы в тестах
    public Interview(int minutes, String guest) {
        this.guest = guest;
        this.duration = minutes * 60L;
    }

    public String getGuest() {
        return guest;
    }

    @Override
    public float getPrice() {
        return 0.5F;
    }

    @Override
    public long getDuration() {
        return duration;
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
