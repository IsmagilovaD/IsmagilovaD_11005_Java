public class Main {

    public static void main(String[] args) {
        OrdersFileSaver fileSaver = new OrdersFileSaver("products.txt");
        Storage storage = new Storage(fileSaver);

        storage.createNewOrder("chair", 10);
        storage.createNewOrder("table", 5);

        storage.printAllProducts();

    }
}