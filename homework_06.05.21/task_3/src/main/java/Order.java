import java.io.Serializable;

public class Order implements Serializable {
    String name;
    int count;

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public Order(String name, int count) {
        this.name = name;
        this.count = count;
    }
}
