package cracking.code.interview;

public class SortedMerge {
    public static Integer[] merge(Integer[] a, Integer[] b) {
        int ac = a.length - 1;
        int bc = b.length - 1;
        int nc = a.length - 1;
        while(bc >=0) {
            if (ac >= 0 && a[ac] == null) {
                ac--;
                continue;
            }
            if (ac >= 0 && a[ac] > b[bc]){
                a[nc] = a[ac];
                ac--;
            } else {
                a[nc] = b[bc];
                bc--;
            }
            nc--;
        }
        return a;
    }
}
