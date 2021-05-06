import java.util.ArrayList;

public class Storage {
    OrderSaver saver;
    ArrayList<Order> orders;
    ArrayList<ProductsListener> listeners = new ArrayList<>();

    public void addListener(ProductsListener listener) {
        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    public Storage(OrderSaver saver) {
        this.saver = saver;
        orders = saver.getOrders();
    }

    public void createNewOrder(String name, int count) {
        Order order = new Order(name, count);
        orders.add(order);
        saver.saveOrders(orders);
        for (ProductsListener listener : listeners) listener.productsUpdated();
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
        for (ProductsListener listener : listeners) listener.productsUpdated();
    }

    public void changeOrder(String name, int count) {
        Order p = getOrder(name);

        if (p != null) {
            p.setCount(count);
            this.saver.saveOrders(this.orders);
        }
        for (ProductsListener listener : listeners) listener.productsUpdated();
    }

    public void printAllProducts() {
        for (Order p : orders) {
            System.out.println(p.name + ": " + p.count);
        }
    }

}
