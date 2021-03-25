import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<Order> orders = new ArrayList<>();

    public City(String name, Order orders) {
        this.name = name;
        this.orders.add(orders) ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders.add(orders);
    }
}
