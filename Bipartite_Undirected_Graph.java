
// Use graph coloring
// Use BFS
// -1 = no color
// 0 = yellow
// 1 = blue
import java.util.*;

public class Bipartite_Undirected_Graph {

    static class Edges{
        int src;
        int dest;
        // int wt;

        public Edges(int src ,int dest){
            this.src = src;
            this.dest = dest;
            // this.wt = wt;
        }
    }
    public static boolean isBipartite(ArrayList<Edges>[] graph){
        int color [] = new int[graph.length];
        for(int i = 0;i<color.length;i++){
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<graph.length;i++){
            if(color[i] == -1){
                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j = 0; j<graph[curr].size();j++){
                        Edges e = graph[curr].get(j);
                        if(color[e.dest] == -1){
                            color[e.dest] = color[curr] == 0? 1:0;
                            q.add(e.dest);
                        }
                        else if(color[e.dest] == color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

        //    0------2
        //    |      |
        //    |      |            non-Bipartite         if i remove the connection of 2---4 
        //    1      |            Ans :- false          then, the answer :--- true;
        //    |      |
        //    |      |
        //    3------4


        int v = 9;         //number of edges
        ArrayList<Edges> [] Graph = new ArrayList[v];
        for(int i =0;i<v;i++){
            Graph[i] = new ArrayList<>();
        }
        // vertex -0
        Graph[0].add(new Edges(0,1));
        Graph[0].add(new Edges(0,2));


        // vertex -1
        Graph[1].add(new Edges(1,0));
        Graph[1].add(new Edges(1,3));

        // vertex- 2
        Graph[2].add(new Edges(2,0));
        // Graph[2].add(new Edges(2,4));

        // vertex-3
        Graph[3].add(new Edges(3,1));
        Graph[3].add(new Edges(3,4));
        // Graph[3].add(new Edges(3,0,4));

        // vertex-4
        Graph[4].add(new Edges(4,3));
        // Graph[4].add(new Edges(4,2));

        // call function
        System.out.println(isBipartite(Graph));
    }

}

