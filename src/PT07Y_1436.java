import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by anshu on 06/03/17.
 */
class PT07Y_1436 {
    static class Graph{
        int V;
        LinkedList<Integer> adj[];
        boolean visited[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for(int i=0;i<v;i++)
                adj[i]=new LinkedList<>();
        }
        private void addEdge(int a,int b){
            adj[a].push(b);
            adj[b].push(a);
        }
        private boolean isTree(){
            visited = new boolean[V];
//            System.out.print("here");
//            for(int i=0;i<V;i++)
//                visited[i]=false;
            if(isCyclic(0,-1))
                return false;

            for(int i=0;i<V;i++)
                if(!visited[i])
                    return false;
//            for(int i=0;i<V;i++)
//                System.out.print(visited[i]+" ");
            return true;
        }

        private boolean isCyclic(int node, int parent) {
            visited[node]=true;
//            System.out.println(node+" "+parent);
            for(int i=0;i<adj[node].size();i++){
                int curr = adj[node].get(i);
//                System.out.println(curr);
                if(!visited[curr]){
                    if(isCyclic(curr,node))
                        return true;
                }
                else if(curr!=parent)
                    return true;
            }
            return false;
        }
    }



    static Reader scan;
    public static void main(String[] args) throws IOException {
        scan = new Reader();
        int n = scan.nextInt();
        int m = scan.nextInt();
        if(m!=n-1){
            System.out.println("NO");}
        else{
            Graph graph = new Graph(n);
            for(int i=0;i<m;i++){
                graph.addEdge(scan.nextInt()-1,scan.nextInt()-1);
            }
            if(graph.isTree()){
                System.out.println("YES");
            }
            else
            System.out.println("NO");

        }
    }

}
//class Reader {
//
//    final private int BUFFER_SIZE = 1 << 16;private DataInputStream din;private byte[] buffer;private int bufferPointer, bytesRead;
//    public Reader(){din=new DataInputStream(System.in);buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
//    }public Reader(String file_name) throws IOException {din=new DataInputStream(new FileInputStream(file_name));buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
//    }public String readLine() throws IOException{byte[] buf=new byte[64];int cnt=0,c;while((c=read())!=-1){if(c=='\n')break;buf[cnt++]=(byte)c;}return new String(buf,0,cnt);
//    }public int nextInt() throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
//    }public long nextLong() throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
//    }public double nextDouble() throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c = read();do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(c=='.')while((c=read())>='0'&&c<='9')ret+=(c-'0')/(div*=10);if(neg)return -ret;return ret;
//    }private void fillBuffer() throws IOException{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;
//    }private byte read() throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];
//    }public void close() throws IOException{if(din==null) return;din.close();}
//
//}
