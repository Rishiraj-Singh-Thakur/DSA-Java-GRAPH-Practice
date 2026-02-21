import java.util.*;
public class Graph_BFS_Print{
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
    //BFS Function
    public static void printBfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[graph.length];
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!visit[curr]){
                System.out.print(curr+"->");
                visit[curr] = true;
                for(int i =0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
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

            printBfs(graph);
    }
}