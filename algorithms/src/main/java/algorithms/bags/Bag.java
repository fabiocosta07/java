package algorithms.bags;

public interface Bag<T> extends Iterable<T>{
    void add(T item);
    int size();
}
