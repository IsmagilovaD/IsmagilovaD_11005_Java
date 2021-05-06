import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class OrdersFileSaver implements OrderSaver {
    private
    File file;

    public OrdersFileSaver(File file) {
        this.file = file;
    }

    public OrdersFileSaver(String fileName) {
        file = new File(fileName);
    }

    @Override
    public ArrayList<Order> getOrders() {
        ArrayList<Order> result = new ArrayList<>();

        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file))) {
            Order[] temp = (Order[]) oin.readObject();

            result.addAll(Arrays.asList(temp));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void saveOrders(ArrayList<Order> products) {
        try (ObjectOutputStream oin = new ObjectOutputStream(new FileOutputStream(file))) {
            Order[] temp = new Order[products.size()];
            for (int i = 0; i < products.size(); i++) {
                temp[i] = products.get(i);
            }

            oin.writeObject(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
