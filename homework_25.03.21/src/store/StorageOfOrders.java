package store;

import store.Order;

import java.io.*;
import java.util.ArrayList;

public class StorageOfOrders {
    private ArrayList<Order> orders;

    public StorageOfOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void writeOrders() {
        orders = readOrder();
        for (Order newOrder : orders) {
            System.out.println(newOrder);
        }
    }

    public static ArrayList<Order> readOrder() {
        try (FileInputStream fis = new FileInputStream("orders.txt");
             ObjectInputStream in = new ObjectInputStream(fis)) {
            ArrayList<Order> order = (ArrayList<Order>) in.readObject();
            return order;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(Order order){
        orders.add(order);
        writeOrderToFile(orders);
    }

    public void removeOrder(int i){
        orders.remove(i);
        writeOrderToFile(orders);
    }

    public void changeCount(int i,int newCount){
        orders.get(i).setCount(newCount);
        writeOrderToFile(orders);
    }

    public static void writeOrderToFile(ArrayList<Order> order) {
        try (FileOutputStream fos = new FileOutputStream("orders.txt");
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(order);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}