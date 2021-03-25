import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class StorageOfBuyers {

    static ArrayList<Buyer> buyers = new ArrayList<>();

    Buyer getBuyer(String name) {
            for (Buyer buyer : buyers) {
                if (buyer.getName().equals(name)) {
                    return buyer;
                }
            }
        Buyer buyer = new Buyer(name);
        buyers.add(buyer);
        return buyer;
    }

     void addOrder(String name, String city, String order, int count) {
        Buyer buyer = getBuyer(name);
        buyer.addOrder(city, order, count);
    }
    @Override
    public String toString() {
        return buyers.toString();
    }

    public void nameSort(){
        BuyerByOrdersCountComparator ordersCountComparator = new BuyerByOrdersCountComparator();
        BuyerByCityCountComparator cityCountComparator = new BuyerByCityCountComparator();
        BuyerByNameComparator nameComparator = new BuyerByNameComparator();
        Comparator<Buyer> comparator1 = nameComparator.thenComparing(cityCountComparator).thenComparing(ordersCountComparator);
        TreeSet<Buyer> nameSort = new TreeSet<>(comparator1);
        nameSort.addAll(buyers);
        try {
            FileOutputStream fos = new FileOutputStream("sortedByNames.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Buyer buyer : nameSort)
                oos.writeObject(buyer.toString());

            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ordersCountSort(){
        BuyerByOrdersCountComparator ordersCountComparator = new BuyerByOrdersCountComparator();
        BuyerByCityCountComparator cityCountComparator = new BuyerByCityCountComparator();
        BuyerByNameComparator nameComparator = new BuyerByNameComparator();
        Comparator<Buyer> comparator2 = ordersCountComparator.thenComparing(cityCountComparator).thenComparing(nameComparator);
        TreeSet<Buyer> ordersCountSort = new TreeSet<>(comparator2);
        ordersCountSort.addAll(buyers);
        try {
            FileOutputStream fos = new FileOutputStream("sortedByOrders.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Buyer buyer : ordersCountSort)
                oos.writeObject(buyer.toString());

            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    void printAll(){
        for (int i = 0; i < buyers.size(); i++){
            System.out.println(buyers.get(i).getName() + " : \t" );
            buyers.get(i).print();
            System.out.println();

        }
    }
}
