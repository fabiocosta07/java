package algorithms.sort;

public abstract class Sortable {
    protected static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    protected static void exch(Comparable[] a, int i, int j){
        final Comparable swap = a[i];
        a[i] = a [j];
        a[j] = swap;
    }
    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if (less(a[i],a[i-1]))
            return false;
        }
        return true;
    }

    public static boolean isSorted(Comparable[] a, int lo, int hi){
        Comparable [] aux = new Comparable[hi-lo] ;

        for (int i = 1; i < a.length; i++) {
            aux[i] = a[lo++];
        }

        return isSorted(aux);
    }

}
