package store;

import java.io.Serializable;

public class Order implements Serializable {
    private String name;
    private int count;

    @Override
    public String toString() {
        return name + " " + count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Order(String name, int count) {
        this.name = name;
        this.count = count;
    }
}
