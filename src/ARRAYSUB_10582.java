import java.io.IOException;

/**
 * Created by anshu on 18/03/17.
 */
public class ARRAYSUB_10582 {
    static int a[];
    static class ST{
        int st[];

        public ST(int n) {
            int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
            x =2*(int)Math.pow(2,x) -1;
            st = new int[x];
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
                st[si]=Math.max(st[2*si+1],st[2*si+2]);
            }
        }
        private int RangeMaxQuery(int ss,int se,int qs,int qe,int si){
            if(ss>=qs&&se<=qe){
                return st[si];
            }else if(ss>qe||se<qs){
                return Integer.MIN_VALUE;
            }else{
                int mid = (ss+se)/2;
                return Math.max(RangeMaxQuery(ss,mid,qs,qe,2*si+1),RangeMaxQuery(mid+1,se,qs,qe,2*si+2));
            }
        }


    }
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        int n = scan.nextInt();
        a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=scan.nextInt();
        }
        int k=scan.nextInt();
        ST segTree = new ST(n);
        for(int i=0;i<=n-k;i++){
            System.out.print(segTree.RangeMaxQuery(0,n-1,i,i+k-1,0)+" ");
        }

    }
}
