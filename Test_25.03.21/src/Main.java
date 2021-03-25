import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Buyer> buyers = new ArrayList<>();
        ArrayList<String> str = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("orders.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                str.add(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < str.size(); i++) {
            String[] str1 = str.get(i).split("\\|");
            Order order = new Order(str1[2], Integer.parseInt(str1[3]));
            City city = new City(str1[1], order);
            Buyer buyer = new Buyer(str1[0], city);
            if (buyers.size() > 0) {
                for (int k = 0; k < buyers.size(); k++) {
                    if (buyers.get(k).getName().equals(buyer.getName())) {
                        ArrayList<City> cities1 = buyers.get(k).getCities();
                        for (int j = 0; j < buyers.size(); j++) {
                            if (cities1.get(j).getName().equals(city.getName())) {
                                ArrayList<Order> orders1 = cities1.get(j).getOrders();
                                for (int l = 0; l < orders1.size(); l++) {
                                    if (orders1.get(l).getName().equals(order.getName())) {
                                        int count = orders1.get(l).getCount();
                                        orders1.get(l).setCount(count + order.getCount());
                                    }
                                    buyers.get(k).getCities().get(j).setOrders(order);
                                }
                            } else buyers.get(k).setCities(city);
                        }
                    } else buyers.add(buyer);
                }
            }else buyers.add(buyer);
        }
      /*  for (int i = 0 ; i <buyers.size();i++){
            System.out.println(buyers.get(i).getName() + " : ");
            for (int k = 0; k <buyers.get(i).getCities().size(); k++){
                System.out.println(buyers.get(i).getCities().get(k).getName() + " : ");
                for (int l = 0; l <buyers.get(i).getCities().get(k).getOrders().size(); l++){
                    System.out.println(buyers.get(i).getCities().get(k).getOrders().get(l).getName() +
                                    buyers.get(i).getCities().get(k).getOrders().get(l).getCount()
                            );
                }
            }
        }

       */
        for (int i = 0 ; i <buyers.size();i++) {
            System.out.println(buyers.get(i).getName() + " : ");
        }
    }


}