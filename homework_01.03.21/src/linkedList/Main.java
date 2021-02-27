package linkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(100);
        list.add(200);
        System.out.println(list.size());
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));
        System.out.println(list.size());
    }
}
