import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CRUDHolder<T extends Comparable<T> & Printable> {
    ArrayList<T> items = new ArrayList<>();

    public void create(T item) throws IllegalArgumentException {
        for (T x : items) {
            if (x.compareTo(item) == 0) {
                throw new IllegalArgumentException("Such an element already exist");
            }
        }
        items.add(item);
    }

    public T read(int id) throws NoSuchElementException {
        if (id < 0 || id >= items.size()) throw new IllegalArgumentException("There is no such element");
        else return items.get(id);
    }

    public void update(T item) throws NoSuchElementException {
        boolean flag = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).compareTo(item) == 0) {
                items.set(i, item);
                flag = true;
            }
        }
        if (!flag) throw new IllegalArgumentException("There is no such element");
    }

    public void delete(T item) throws NoSuchElementException {
        boolean flag = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).compareTo(item) == 0) {
                items.remove(i);
                flag = true;
            }
        }
        if (!flag) throw new IllegalArgumentException("There is no such element");
    }
}
