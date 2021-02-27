package stack;

public class Stack<T> {

    static class Node<T> {
        private T value;
        private  Node<T> next;
    }

    private Node<T> head;

    public Stack() {
    }

    public void push(T value){
        Node<T> newNode = new Node<>();
        newNode.value = value;
        newNode.next = head;
        head = newNode;
    }

    public T pop(){
        if (head == null) throw new NullPointerException("Stack is empty");
        T value = head.value;
        head = head.next;
        return value;

    }

    public T peek(){
        if (head == null) throw new NullPointerException("Stack is empty");
        return head.value;
    }
}
