import java.util.ArrayList;

public class Storage {
    OrderSaver saver;
    ArrayList<Order> orders;

    public Storage(OrderSaver saver) {
        this.saver = saver;
        orders = saver.getOrders();
    }

    public void createNewOrder(String name, int count) {
        Order order = new Order(name, count);
        orders.add(order);
        saver.saveOrders(orders);
    }

    public Order getOrder(String name) {
        for (Order p : orders) {
            if (p.name.equals(name))
                return p;
        }

        return null;
    }

    public void deleteOrder(String name) {
        Order p = getOrder(name);

        if (p != null)
            orders.remove(p);

        saver.saveOrders(orders);
    }

    public void changeOrder(String name, int count) {
        Order p = getOrder(name);

        if (p != null) {
            deleteOrder(name);
            createNewOrder(name, count);
        }
    }

    public void printAllProducts() {
        for (Order p : orders) {
            System.out.println(p.name + ": " + p.count);
        }
    }
}
