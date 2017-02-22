import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by anshu on 22/02/17.
 */
public class COINS_346 {
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        double a[] = new double[1000001];
        a[0]=0;
        a[1]=1;
        for(int i=1;i<a.length;i++){
            a[i]=Math.max(i,a[i/2]+a[i/3]+a[i/4]);
        }



        int n;
            while(true){
                try{
                    String s = stdin.readLine();
                   n = Integer.parseInt(s);
                }
                catch(Exception e)
                {
                    break;

                }

                System.out.printf("%.0f \n",for_gre(a,n));



            }

    }

    private static double for_gre(double[] a, int n) {
        if(n==0)
            return 0;
        else if(n<=1000000)
            return a[n];
        else
            return Math.max(n,for_gre(a,n/2)+for_gre(a,n/3)+for_gre(a,n/4));

    }
}
