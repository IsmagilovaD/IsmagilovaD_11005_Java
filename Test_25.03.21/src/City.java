import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<Order> orders = new ArrayList<>();

    public City(String name, Order orders) {
        this.name = name;
    }

    void addOrder(String name, int count) {
        for (Order order : orders ){
            if (order.getName().equals(name))
            { int i = order.getCount() + count;
                order.setCount(i);
            return;}
        }
        orders.add(new Order(name, count));
    }

    void print(){
        System.out.println(name + "\n\t" + orders.toString());
    }

    public String toString(){
        return name + orders;
    }

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getOrdersCount() {
        return orders.size();
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
