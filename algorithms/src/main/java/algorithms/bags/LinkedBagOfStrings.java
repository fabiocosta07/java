package algorithms.bags;

import java.util.Iterator;

public class LinkedBagOfStrings implements Bag<String>{
    @Override
    public void add(String item) {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public String next() {
                return null;
            }

            @Override
            public void remove() {

            }
        };
    }
}
