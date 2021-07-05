package algorithms.stacksandqueues;

import java.util.Iterator;

public class ResizingArrayStackOfStrings implements Stack<String> , Iterable<String> {

    private String [] s;
    private int N;

    public ResizingArrayStackOfStrings() {
        s = new String[1];
    }
    private void resize(int capacity){
        String[] copy = new String[capacity];
        for (int i = 0; i < s.length; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }
    @Override
    public void push(String item) {
        if (s.length == N) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    @Override
    public String pop() {
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length/4) {
            resize(s.length/2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int i = N;
            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public String next() {
                return s[--i];
            }

            @Override
            public void remove() {
                // not supported
            }
        };
    }
}
