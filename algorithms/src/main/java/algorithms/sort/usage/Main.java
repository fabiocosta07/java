package algorithms.sort.usage;

import algorithms.sort.*;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.Stopwatch;
import org.apache.commons.lang3.ArrayUtils;

public class Main {
    public static void main(String []args){
        int N = 6;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(6);

        StdOut.println("Before");
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);



        //Insertion.sort(a);
        //ArrayUtils.reverse(a);
        //ShellSort.sort(a);
        Stopwatch stopwatch = new Stopwatch();
        //Merge.sort(a);
        //ShellSort.sort(a);
        MergeBU.sort(a);
        //Selection.sort(a);

        StdOut.println("After - elapsed time : "+stopwatch.elapsedTime());
        if (Sortable.isSorted(a))
            StdOut.println("Sorted");

/*
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
*/
    }
}
