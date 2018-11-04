public class UnionFind {
    private int[] connections;

    public int[] getConnections() {
        return connections;
    }

    public void setConnections(int[] connections) {
        this.connections = connections;
    }

    public void Union(Ce)
}

    public int find(int i) {
        while (i != connections[i]) {
            connections[i] = connections[connections[i]];
            i = connections[i];
        }
        return i;
    }
