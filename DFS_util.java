import java.util.*;
public class DFS_util {
    static class Edges{
        int src;
        int dest;
        int wt;

        public Edges(int src ,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static void dfs(ArrayList<Edges>[] graph , boolean visit[]){
        for(int i =0;i<graph.length;i++){
            if(!visit[i]){
                dfsutil(graph,i ,visit);

                System.out.println();
            }
        }
    }
    public static void dfsutil(ArrayList<Edges>[] graph, int str,boolean visit[]){
        System.out.print(str+"->");
        visit[str] = true;

        for(int i=0;i<graph[str].size();i++){
            Edges e = graph[str].get(i);
            if(!visit[e.dest]){
                dfsutil(graph , e.dest,visit);
            }
        }
    }
    public static void main(String[] args) {
                    // 0-----------.
                    // |           |                      5---------6                      if the graph is in two part we use util(helper function)
                    // |(5)        |                      |         |
                    // |     (3)   |    (4)               |         |
                    // 1-----------3----------4           7---------8
                    // |
                    // |(1)
                    // |
                    // 2
        int v = 9;         //number of edges
        ArrayList<Edges> [] Graph = new ArrayList[v];
        for(int i =0;i<v;i++){
            Graph[i] = new ArrayList<>();
        }
        // vertex -0
        Graph[0].add(new Edges(0,1,5));
        Graph[0].add(new Edges(0,3,5));


        // vertex -1
        Graph[1].add(new Edges(1,2,1));
        Graph[1].add(new Edges(1,3,3));
        Graph[1].add(new Edges(1,0,5));

        // vertex- 2
        Graph[2].add(new Edges(2,1,1));

        // vertex-3
        Graph[3].add(new Edges(3,1,3));
        Graph[3].add(new Edges(3,4,4));

        // vertex-4
        Graph[4].add(new Edges(4,3,4));

        // vertex-5
        Graph[5].add(new Edges(5,6,3));
        Graph[5].add(new Edges(5,7,4));

        // vertex-6
        Graph[6].add(new Edges(6,5,3));
        Graph[6].add(new Edges(6,8,4));

        // vertex-7
        Graph[7].add(new Edges(7,5,3));
        Graph[7].add(new Edges(7,8,4));

        // vertex-8
        Graph[8].add(new Edges(8,6,3));
        Graph[8].add(new Edges(8,7,4));

        // call function
        boolean [] visit = new boolean[Graph.length];
        dfs(Graph, visit);
    }

}


