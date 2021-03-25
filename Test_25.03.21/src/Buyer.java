import java.util.ArrayList;

public class Buyer {
     String name;
     ArrayList<City> cities = new ArrayList<>();

    public Buyer(String name) {
        this.name= name;
    }

    void addOrder(String city, String name, int count) {
        for (City c : cities) {
            if (c.getName().equals(city)) {
                c.addOrder(name, count);
                return;
            }
        }
        cities.add(new City(city));
        addOrder(city, name, count);
    }

    public int getOrdersCount(){
            int count = 0;
            for(City c:cities) {
                count += c.getOrdersCount();
            }
            return count;
    }

    void print(){
        for (int i = 0; i < cities.size(); i++){
            cities.get(i).print();
        }
    }

    public String toString(){
        return name + cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(City cities) {
        this.cities.add(cities);
    }
}
