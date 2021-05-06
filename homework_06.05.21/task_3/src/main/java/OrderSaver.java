import java.util.ArrayList;

public interface OrderSaver {
    ArrayList<Order> getOrders();

    void saveOrders(ArrayList<Order> products);

}
