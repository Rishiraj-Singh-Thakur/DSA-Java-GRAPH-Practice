import java.util.*;

public class isCycle_Directed_DFD_Graph {
    public class Edge {
        int src;
        int dest;

        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static boolean isCycle(ArrayList<Edge>[] Graph){
        return true;
    }
    public static void main(String[] args) {

        // 0----->2
        // < <    |
        // |   \  |            isCycle :-- true;
        // |    \ |
        // |     \>
        // 1      3

        int v = 4;
        ArrayList<Edge>[] Graph = new ArrayList[v];
        for(int i = 0; i < v; i++) {
            Graph[i] = new ArrayList<Edge>();
        }
        // vertex -0
        Graph[0].add(new Edge(0, 2));

        // vertex -1
        Graph[1].add(new Edge(1, 0));

        // vertex -2
        Graph[2].add(new Edge(2, 3));

        // vertex -3
        Graph[3].add(new Edge(3, 0));

        System.out.println(isCycle(Graph));
    }
}
