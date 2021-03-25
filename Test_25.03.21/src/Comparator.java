import java.util.Comparator;

class  BuyerByNameComparator  implements Comparator<Buyer> {

    @Override
    public int compare(Buyer o1, Buyer o2) {
        return o1.name.compareTo(o2.name);
    }
}

class BuyerByCityCountComparator implements  Comparator<Buyer> {

    @Override
    public int compare(Buyer o1, Buyer o2) {
        Integer i1 = o1.getCities().size();
        Integer i2 = o2.getCities().size();
        return i1.compareTo(i2);
    }
}
 class BuyerByOrdersCountComparator implements Comparator<Buyer>{

     @Override
     public int compare(Buyer o1, Buyer o2) {
         Integer i1 = o1.getOrdersCount();
         Integer i2  = o2.getOrdersCount();
         return i1.compareTo(i2);
     }
 }
