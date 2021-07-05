package algorithms.stacksandqueues.queues;

public class LinkedQueueOfStrings implements Queue<String> {
    private Node first, last;
    private class Node {
        String item;
        Node next;
    }
    @Override
    public void enqueue(String item) {
            Node node = new Node();
            node.item = item;
            if (isEmpty()){
                first = node;
            } else {
                last.next = node;
            }
            last = node;
    }

    @Override
    public String dequeue() {
        if (!isEmpty()){
            Node oldFirst = first;
            first = oldFirst.next;
            return oldFirst.item;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return 0;
    }
}
