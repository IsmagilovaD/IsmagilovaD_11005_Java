package linkedListIterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(100);
        linkedList.add(2000);
        linkedList.add(30);
        linkedList.add(4);
        for (Integer item : linkedList){
            System.out.println(item);
        }
    }

}
