package presenters;

import shows.Show;
import java.util.List;

/**
 * Реализует фабричный метод
 * и использует паттерн Мост
 *
 * Для того чтобы не делать непонятное наследование классов
 * создал наследование интерфейсов
 */
public interface Presenter {
    String getName();

    List<Show> getShows();
}
