
public class Main {

    public static void main(String[] args) {
        OrdersFileSaver fileSaver = new OrdersFileSaver("products.txt");
        Storage storage = new Storage(fileSaver);

        storage.addListener(storage::printAllProducts);
        storage.addListener(() -> {
            int ans = 0;
            for (Order o : storage.orders) ans += o.getCount();
            System.out.println("Occupied space: " + ans);
        });
        storage.addListener(() -> {
            int max = 0;
            String ans = "-";
            for (int i = 0; i < storage.orders.size(); i++) {
                if (storage.orders.get(i).getCount() > max) {
                    max = storage.orders.get(i).getCount();
                    ans = storage.orders.get(i).name;
                }
            }
            System.out.println("The biggest-sized order: " + ans);
        });


        storage.createNewOrder("chair", 10);
        System.out.println();
        storage.createNewOrder("table", 5);
        System.out.println();
        storage.changeOrder("table", 20);
        System.out.println();
        storage.deleteOrder("table");
        System.out.println();
        storage.deleteOrder("chair");

    }
}