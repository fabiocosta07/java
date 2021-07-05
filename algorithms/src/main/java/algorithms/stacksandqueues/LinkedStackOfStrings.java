package algorithms.stacksandqueues;

import java.util.Iterator;
import java.util.ListIterator;

public class LinkedStackOfStrings implements Stack<String>, Iterable<String> {

    private Node first;

    private class Node {
        String item;
        Node next;
    }

    @Override
    public void push(String item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;

    }

    @Override
    public String pop() {
        String firstItem = first.item;
        first = first.next;
        return firstItem;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return 0;
    }
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public String next() {
                String item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public void remove() {

            }
        };
    }

}
