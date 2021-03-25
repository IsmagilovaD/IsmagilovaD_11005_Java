package store;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order("apple", 4));
        orders.add(new Order("pear", 2));
        orders.add(new Order("grape", 1));
        orders.add(new Order("cucumber", 5));
        orders.add(new Order("pumpkin", 1));

        StorageOfOrders orders1 = new StorageOfOrders(orders);

        orders1.add(new Order("juice", 1));
        orders1.add(new Order("water",10));
        orders1.writeOrders();
        System.out.println();

        orders1.removeOrder(5);
        orders1.writeOrders();
        System.out.println();

        orders1.changeCount(0,20);
        orders1.writeOrders();
    }
}