package stackIterator;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    static class Node<T> {
        private T value;
        private  Node<T> next;
    }

    private Node<T> head;

   public class StackIterator implements Iterator<T> {
       Node<T> iteratorHead = head;
       @Override
       public boolean hasNext() {
           return iteratorHead != null;
       }
       @Override
       public T next() {
           T temp = iteratorHead.value;
           iteratorHead = iteratorHead.next;
           return temp;
       }
   }

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
