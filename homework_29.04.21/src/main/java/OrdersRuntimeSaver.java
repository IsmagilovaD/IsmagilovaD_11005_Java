import java.util.ArrayList;

public class OrdersRuntimeSaver implements OrderSaver {
    ArrayList<Order> orders = new ArrayList<>();

    @Override
    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public void saveOrders(ArrayList<Order> products) {
        this.orders = orders;
    }

}
