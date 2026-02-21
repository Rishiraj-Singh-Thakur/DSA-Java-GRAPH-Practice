import java.util.*;

public class EmplementGraphUsing_Adjacency{
    static class Edges{
        int Source , Destination , Wight;

        public Edges(int Source , int Destination ,int Wight){
            this.Source = Source;
            this.Destination = Destination;
            this.Wight = Wight;
        }
    }
    public static void main(String[] args) {
                    // 0
                    // |                                  ()=> wight
                    // |(5)                               --- => edges
                    // |     (3)        (4)
                    // 1-----------3----------4
                    // |
                    // |(1)
                    // |
                    // 2
        int v = 5;         //number of edges
        ArrayList<Edges> [] Graph = new ArrayList[v];
        for(int i =0;i<v;i++){
            Graph[i] = new ArrayList<>();
        }
        // vertex -0
        Graph[0].add(new Edges(0,1,5));

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

for(int i = 0; i < Graph.length; i++){
    System.out.print(i + " -> ");
    for(int j = 0; j < Graph[i].size(); j++){
        Edges e = Graph[i].get(j);
        System.out.print("(" + e.Destination + "," + e.Wight + ") ");
    }
    System.out.println();
}
    }

}

