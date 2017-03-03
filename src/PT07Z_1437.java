import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by anshu on 03/03/17.
 */
public class PT07Z_1437 {
    static int farthest;
    static int max;
    static class tree{
        int v;
        LinkedList<Integer> adj[];

        tree(int v) {
            this.v = v;
            adj= new LinkedList[v];
            for(int i=0;i<v;i++)
                adj[i]=new LinkedList<>();
        }
        void bfs(int node){
            boolean visited[] = new boolean[v];
            int distance[] = new int[v];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(node);
            visited[node]=true;
            while(!queue.isEmpty()){
                int curr = queue.poll();
                for(int i=0;i<adj[curr].size();i++){
                    if(!visited[adj[curr].get(i)]){
                        visited[adj[curr].get(i)]=true;
                        distance[adj[curr].get(i)]=distance[curr]+1;
                        queue.add(adj[curr].get(i));
                    }
                }
            }
//            for(int i=0;i<distance.length;i++)
//                System.out.print(distance[i]+" ");
//            System.out.println();
            max = Integer.MIN_VALUE;
            for(int i=0;i<distance.length;i++){
                if(distance[i]>max){
                    max=distance[i];
                    farthest=i;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        int n =scan.nextInt();
        tree tree1 = new tree(n);
        for(int i=0;i<n-1;i++){
            int a = scan.nextInt();
            a--;
            int b = scan.nextInt();
            b--;
            tree1.adj[a].push(b);
            tree1.adj[b].push(a);
        }
        tree1.bfs(0);
        tree1.bfs(farthest);
        System.out.println(max);

    }







    static  class Reader {

        final private int BUFFER_SIZE = 1 << 16;private DataInputStream din;private byte[] buffer;private int bufferPointer, bytesRead;
        public Reader(){din=new DataInputStream(System.in);buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
        }public Reader(String file_name) throws IOException {din=new DataInputStream(new FileInputStream(file_name));buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
        }public String readLine() throws IOException{byte[] buf=new byte[64];int cnt=0,c;while((c=read())!=-1){if(c=='\n')break;buf[cnt++]=(byte)c;}return new String(buf,0,cnt);
        }public int nextInt() throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
        }public long nextLong() throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
        }public double nextDouble() throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c = read();do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(c=='.')while((c=read())>='0'&&c<='9')ret+=(c-'0')/(div*=10);if(neg)return -ret;return ret;
        }private void fillBuffer() throws IOException{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;
        }private byte read() throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];
        }public void close() throws IOException{if(din==null) return;din.close();}

    }
}
