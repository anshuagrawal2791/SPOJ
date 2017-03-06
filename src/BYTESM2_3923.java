import java.io.IOException;

/**
 * Created by anshu on 06/03/17.
 */
public class BYTESM2_3923 {
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            int n = scan.nextInt();
            int m = scan.nextInt();
            int a[][]= new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    a[i][j]=scan.nextInt();
                }
            }
            for(int i=n-2;i>=0;i--){
                for(int j=0;j<m;j++){
                    if(j==0)
                        a[i][j]+=Math.max(a[i+1][j],a[i+1][j+1]);
                    else if(j==m-1)
                        a[i][j]+=Math.max(a[i+1][j],a[i+1][j-1]);
                    else
                       a[i][j]+= Math.max(Math.max(a[i+1][j],a[i+1][j-1]),a[i+1][j+1]);


                }
            }
            int max=Integer.MIN_VALUE;
            for(int i=0;i<m;i++){
                if(a[0][i]>max)
                    max=a[0][i];
            }
            System.out.println(max);
        }
    }
}
