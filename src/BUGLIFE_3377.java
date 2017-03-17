import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by anshu on 18/03/17.
 */
public class BUGLIFE_3377 {
    static class Graph{
        int V;
        LinkedList<Integer> adj[];

        public Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for(int i=0;i<v;i++){
                adj[i]= new LinkedList<>();
            }
        }
        public void addEdge(int a,int b){
            adj[a].push(b);
            adj[b].push(a);
        }
    }
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            int v = scan.nextInt();
            Graph graph = new Graph(v);
            int edges = scan.nextInt();
            for(int i=0;i<edges;i++){
                graph.addEdge(scan.nextInt()-1,scan.nextInt()-1);
            }
            if(isBipartiteUtil(graph,v)){
                System.out.println("Scenario #"+(p+1)+":\n"+"No suspicious bugs found!");
            }
            else
                System.out.println("Scenario #"+(p+1)+":\n"+"Suspicious bugs found!");
        }
    }

    private static boolean isBipartiteUtil(Graph graph,int v) {
        int color[] = new int[v];
        Arrays.fill(color,-1);

        for(int i=0;i<v;i++){
            if(color[i]==-1){
                if(!isBipartite(graph,color,i))
                    return false;
            }
        }
        return true;
    }

    private static boolean isBipartite(Graph graph, int[] color, int source) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        color[source]=0;
        while(!q.isEmpty()){
            int curr = q.poll();

            for(int i=0;i<graph.adj[curr].size();i++){
                int neighbour = graph.adj[curr].get(i);
                if(color[neighbour]==-1){
                    color[neighbour]=1-color[curr];
                    q.add(neighbour);
                }
                else{
                    if(color[neighbour]==color[curr])
                        return false;
                }
            }
        }
        return true;
    }
}
