package algorithms.unionfind;

public class WeightedQuickUnionUf implements Uf{

    private int id[];
    private int sz[];

    WeightedQuickUnionUf(int n){
     id = new int[n];
     sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i]=i;
        }
    }

    private int root(int i){
        while (id[i] != i){
            i = id[i];
        }
        return i;
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else { id[j] = i; sz[i] += sz[j]; }
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p)==root(q);
    }

    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }
}
