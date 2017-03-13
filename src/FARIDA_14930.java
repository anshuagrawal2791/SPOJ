import java.io.IOException;

/**
 * Created by anshu on 13/03/17.
 */
public class FARIDA_14930 {
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        int t = scan.nextInt();
        for(int p=1;p<=t;p++){
            int n = scan.nextInt();
            double exc = 0;
            double a[] = new double [n];
            double inc=0;
            if(n!=0){
                a[0]=scan.nextDouble();
                inc =a[0];}
            for(int i=1;i<n;i++){
                a[i]=scan.nextDouble();
                double temp = inc;
                inc=a[i]+exc;
                exc=Math.max(temp,exc);
            }
            System.out.printf("Case %d: %.0f\n",p,Math.max(inc,exc));
        }
    }
}
