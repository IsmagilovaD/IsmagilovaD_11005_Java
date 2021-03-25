import java.util.ArrayList;

public class Buyer {
    private String name;
    private ArrayList<City> cities = new ArrayList<>();

    public Buyer(String name, City cities) {
        this.name= name;
        this.cities.add(cities);
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
