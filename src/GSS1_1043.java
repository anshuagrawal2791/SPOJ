import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by anshu on 02/03/17.
 */
public class GSS1_1043 {
    static int a[];
    static class SegmentTree{
        int[] tree;

        public SegmentTree(int n) {
//            int x = (int)(Math.log(n)/Math.log(2));
            int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
            x =2*(int)Math.pow(2,x) -1;
//            System.out.println(x);
            tree = new int[x];
            createST(0,n-1,0);
//            for(int i=0;i<x;i++)
//                System.out.print(tree[i]+" ");

        }

        private void createST(int ss, int se, int si) {
//            for(int i=0;i<tree.length;i++)
//                System.out.print(tree[i]+" ");
//            System.out.println(ss+" "+se+" "+si);
            if(ss==se){
                tree[si]=a[ss];

            }else{
            int mid = (ss+se)/2;
            createST(ss,mid,2*si+1);
            createST(mid+1,se,2*si+2);
            tree[si]= Math.max(tree[2*si+1],tree[2*si+2]);}
        }

        private int rangeMinQuery(int ss,int se,int qs,int qe,int si){
            if(ss>=qs&&se<=qe){
                return tree[si];
            }
            if(ss>qe||se<qs)
                return Integer.MIN_VALUE;
            int mid = (ss+se)/2;
            return Math.max(rangeMinQuery(ss,mid,qs,qe,2*si+1),rangeMinQuery(mid+1,se,qs,qe,2*si+2));

        }


    }
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        int n = scan.nextInt();
        a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=scan.nextInt();
        SegmentTree tree = new SegmentTree(n);

        int q = scan.nextInt();
        for(int i=0;i<q;i++)
            System.out.println(tree.rangeMinQuery(0,n-1,scan.nextInt()-1,scan.nextInt()-1,0));
    }

    static class Reader {
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
