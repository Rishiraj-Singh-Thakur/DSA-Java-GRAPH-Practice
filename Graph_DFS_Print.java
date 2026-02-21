import java.util.*;
public class Graph_DFS_Print {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    //DFS Function
    public static void printDFS(ArrayList<Edge>[] graph , int src , boolean[] visit){
        System.out.print(src+"->");
        visit[src] = true;

        for(int i =0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!visit[e.dest]){
                printDFS(graph, e.dest, visit);
            }
        }
    }
    public static void main(String[] args) {
            // 1------3------5------6
            // |      |     /
            // |      |    /
            // 0      |   /
            // |      |  /
            // |      | /
            // 2-------4

            int vertex = 7;
            ArrayList<Edge>[] graph = new ArrayList[vertex];
            for(int i = 0;i<vertex;i++){
                graph[i] = new ArrayList<>();
            }

            // vertex -0
            graph[0].add(new Edge(0,1,1));
            graph[0].add(new Edge(0,2,1));

            // vertex -1
            graph[1].add(new Edge(1,0,1));
            graph[1].add(new Edge(1,3,1));

            // vertex -2
            graph[2].add(new Edge(2,0,1));
            graph[2].add(new Edge(2,4,1));

            // vertex -3
            graph[3].add(new Edge(3,4,1));
            graph[3].add(new Edge(3,5,1));
            graph[3].add(new Edge(3,1,1));


            // vertex -4
            graph[4].add(new Edge(4,2,1));
            graph[4].add(new Edge(4,3,1));
            graph[4].add(new Edge(4,5,1));


            // vertex -5
            graph[5].add(new Edge(5,3,1));
            graph[5].add(new Edge(5,4,1));
            graph[5].add(new Edge(5,6,1));


            // vertex -0
            graph[6].add(new Edge(6,5,1));

            boolean visit[] = new boolean [graph.length];
            printDFS(graph, 0, visit);
    }
}
