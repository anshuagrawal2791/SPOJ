import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by anshu on 03/03/17.
 */
public class HORRIBLE_8002 {
    static int a[];

    static class ST{
        double st[];
        double lazy[];

        public ST(int n) {
            int x = (int)(Math.ceil(Math.log(n)/Math.log(2)));
            x = 2*(int)Math.pow(2,x)-1;
            st = new double[x];
            lazy = new double[x];
            createST(0,n-1,0);

        }

        private void createST(int ss, int se, int si) {
            if(ss==se){
                st[si]=a[ss];
            }
            else{
                int mid = (ss+se)/2;
                createST(ss,mid,2*si+1);
                createST(mid+1,se,2*si+2);
                st[si]= st[2*si+1]+st[2*si+2];
            }


        }
        private double getSum(int ss,int se,int qs,int qe,int si){
            if(lazy[si]!=0){
                st[si]+=(se-ss+1)*lazy[si];
                if(ss!=se){
                    lazy[2*si+1]+=lazy[si];
                    lazy[2*si+2]+=lazy[si];
                }
                lazy[si]=0;
            }

            if(ss>=qs&&se<=qe){
                return st[si];
            }
            if(qs>se||qe<ss||ss>se)
                return 0;
            int mid = (ss+se)/2;
            return getSum(ss,mid,qs,qe,2*si+1)+getSum(mid+1,se,qs,qe,2*si+2);
        }
        private void update(int ss,int se,int qs,int qe,int si,double v){
//            System.out.println("-----"+ss+" "+se+" "+qs+" "+qe+" "+se+" "+v);
//            print();
            if(lazy[si]!=0){
                st[si]+=(se-ss+1)*lazy[si];
                if(ss!=se){
                    lazy[2*si+1]+=lazy[si];
                    lazy[2*si+2]+=lazy[si];
                }
                lazy[si]=0;
            }
            if(qs>se||qe<ss||ss>se)
                return;
            if(ss>=qs&&se<=qe){
//                System.out.println("here");
                st[si]+=(se-ss+1)*v;
                if(ss!=se){
                    lazy[2*si+1]+=v;
                    lazy[2*si+2]+=v;
                }
                return;
            }
                int mid = (ss+se)/2;
                update(ss,mid,qs,qe,2*si+1,v);
                update(mid+1,se,qs,qe,2*si+2,v);
                st[si]=st[2*si+1]+st[2*si+2];


        }

        public void print() {
            for(int i=0;i<st.length;i++)
                System.out.print(st[i]+" ");
            System.out.println();
            for(int i=0;i<lazy.length;i++)
                System.out.print(" "+lazy[i]+" ");
            System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        int t = scan.nextInt();
        for(int p=0;p<t;p++) {
            int n = scan.nextInt();
            a = new int[n];
//            for(int i=0;i<a.length;i++)
//                System.out.print(a[i]);
            ST tree = new ST(n);
//            tree.print();

            int q = scan.nextInt();
            for (int i = 0; i < q; i++) {
                int l = scan.nextInt();
                if (l == 0) {
                    tree.update(0, n - 1, scan.nextInt() - 1, scan.nextInt() - 1, 0, scan.nextDouble());
//                    tree.print();
                } else {
                    System.out.printf("%.0f\n", tree.getSum(0, n - 1, scan.nextInt() - 1, scan.nextInt() - 1, 0));
                }
            }


        }


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
