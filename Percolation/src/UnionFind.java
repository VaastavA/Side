public class UnionFind {
    private int[] connections;
    private int[] sz;

    public UnionFind(int size) {
        connections = new int[size*size];
        this.sz = new int[size*size];
        for(int i=0;i<connections.length;i++){
            connections[i] = i;
        }
    }

    public int[] getConnections() {
        return connections;
    }

    public void setConnections(int[] connections) {
        this.connections = connections;
    }

    public void Union(Cell a, Cell b) {
        int i = find(a.cd.actual);
        int j = find(b.cd.actual);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            connections[i] = j;
            sz[j] += sz[i];
        } else {
            connections[j] = i;
            sz[i] += sz[j];
        }
    }

    public int find(int i) {
        while (i != connections[i]) {
            connections[i] = connections[connections[i]];
            i = connections[i];
        }
        return i;
    }

    public boolean connected(Cell a,Cell b){
        return  find(a.cd.actual)==find(b.cd.actual);
    }

    public static void main(String[] args) {
        int[][] a = new int[5][5];
        a[2][1] = -1;
        for(int[] i: a){
            for(int j: i){
                System.out.print(j);
            }
            System.out.println();
        }

    }
}
