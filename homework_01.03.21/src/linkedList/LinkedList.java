package linkedList;

public class LinkedList<T> {

    static class Node<T> {
        private T item;
        private Node<T> next;
    }

    private Node<T> root;

    public LinkedList(){

    }

    public void add(T item){
        Node<T> node = new Node<>();
        node.item = item;
        if (root == null){
            root = node;
        }
        else{
        Node<T> temp = root;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }
    }

    public int size(){
        int i = 0;
        if (root == null) {
           return 0;
        } else {
            Node<T> temp = root;
            while (temp.next != null) {
                temp = temp.next;
                i++;
            }
            return i+1;
        }
    }

    public T get(int id) throws Exception {
        int i = 0;
        if (root == null) {
            throw new Exception("No elements");
        }
        else {
            Node<T> temp = root;
            while (i != id) {
                if (temp.next != null) {
                    temp = temp.next;
                    i++;
                } else throw new Exception("id is not correct");
            }
                return temp.item;
        }
    }

    public void remove(int id) throws Exception{
        int i = 0;
        if (root == null) {
            throw new Exception("No elements");
        } else {
            if (id == 0){
                root = root.next;
            } else {
                Node<T> prev = root;
                while (i != id - 1){
                    if (prev.next != null) {
                        prev = prev.next;
                        i++;
                    } else {throw new Exception("id is not correct");}
                }
                if (prev.next != null) {
                    Node<T> temp = prev.next;
                    prev.next = temp.next;
                } else {throw new Exception("id is not correct");}
            }
        }
    }
}

