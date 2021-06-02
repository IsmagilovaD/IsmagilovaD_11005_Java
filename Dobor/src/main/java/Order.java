class Order implements Comparable<Order>, Printable {
    String name;
    int value;

    Order(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public int compareTo(Order o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public void print() {
        System.out.println("name is " + name + " value is " + value);
    }
}
