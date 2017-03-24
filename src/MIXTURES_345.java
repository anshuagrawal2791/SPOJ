import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anshu on 23/03/17.
 */
/*
The first thing to notice here is that, if we mix mixtures i…j into a single mixture,
irrespective of the steps taken to achieve this, the final colour of the mixture is the
 same, equal to csum(i,j) = sum(colour(i…j)) mod 100.
 */
public class MIXTURES_345 {
    static int n;
    static int a[];
    static long dp[][];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder string = new StringBuilder();

        while (in.hasNext()) {
            n = in.nextInt();
            a = new int[n];
            dp = new long[n+1][n+1];

            for (long[] row : dp) {
                Arrays.fill(row, -1);
            }

            for (int i = 0; i <n; i++) {
                a[i] = in.nextInt();
            }

            System.out.print(MCM2(0,n-1) + "\n");
        }

        System.out.print(string);
    }

    private static long MCM2(int i, int j) {
        if(dp[i][j]!=-1)
            return dp[i][j];
        else if(i==j){
            dp[i][j]= 0;
        }
        else{
        long min = Long.MAX_VALUE;
        for(int k=i;k<j;k++){
            min = Math.min(min,MCM2(i,k)+MCM2(k+1,j)+csum(i,k)*csum(k+1,j));
        }
        dp[i][j]=min;}
        return dp[i][j];
    }

    private static int csum(int i, int k) {
        int sum=0;
        for(int j=i;j<=k;j++)
            sum+=a[j];
        return sum%100;
    }

}
