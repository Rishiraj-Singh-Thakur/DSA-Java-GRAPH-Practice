import java.util.*;

public class Cycle_Detect_Undirected_DFS {
    static class Edges{
        int src;
        int dest;
        // int wt;

        public Edges(int src ,int dest,int wt){
            this.src = src;
            this.dest = dest;
            // this.wt = wt;
        }
    }
    public static boolean isCycle(ArrayList<Edges>[] graph , boolean visit[]){
        for(int i =0;i<graph.length;i++){
            if(!visit[i]){
                if(isCycle_Util(graph,visit,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycle_Util(ArrayList<Edges>[] graph,boolean visit[],int curr , int parent){
        visit[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edges e = graph[curr].get(i);
            if(!visit[e.dest]){
                if(isCycle_Util(graph,visit,e.dest , curr)){
                    return true;
                }
            }else if(visit[e.dest] && e.dest != parent){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
                    // 0
                    // |                                  5---------6
                    // |(5)                               |         |
                    // |     (3)        (4)               |         |
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
        // Graph[0].add(new Edges(0,3,5));


        // vertex -1
        Graph[1].add(new Edges(1,2,1));
        Graph[1].add(new Edges(1,3,3));
        Graph[1].add(new Edges(1,0,5));

        // vertex- 2
        Graph[2].add(new Edges(2,1,1));

        // vertex-3
        Graph[3].add(new Edges(3,1,3));
        Graph[3].add(new Edges(3,4,4));
        // Graph[3].add(new Edges(3,0,4));


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
        System.out.println(isCycle(Graph, visit));
    }

}
