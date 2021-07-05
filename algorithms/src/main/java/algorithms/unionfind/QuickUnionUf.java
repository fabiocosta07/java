package algorithms.unionfind;

public class QuickUnionUf implements Uf{

    private int id[];

    QuickUnionUf(int n){
     id = new int[n];
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
        int rp = root(p);
        int rq = root(q);
        id[rp]=id[rq];
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
