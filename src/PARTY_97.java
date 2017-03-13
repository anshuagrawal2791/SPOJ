import java.io.IOException;

/**
 * Created by anshu on 13/03/17.
 */
public class PARTY_97 {
    static int max_value,max_weight;
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        while(true){
            int W = scan.nextInt();
            int n = scan.nextInt();
            if(W==0&&n==0)
                return;
            int weights[] = new int[n];
            int values[]=new int[n];
            for(int i=0;i<n;i++){
                weights[i]=scan.nextInt();
                values[i]=scan.nextInt();
            }
            max_value=0;
            max_weight=W;
            knapsack(weights,values,n,W);
            System.out.println(max_weight+" "+max_value);
        }
    }

    private static void knapsack(int[] weights, int[] values, int n, int w) {
        int a[][] = new int[w+1][n+1];
        for(int i=0;i<w+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0||j==0) {
                    a[i][j] = 0;
                }
                else if(i>=weights[j-1]){
                    a[i][j]=Math.max(values[j-1]+a[i-weights[j-1]][j-1],a[i][j-1]);

                }
                else{
                    a[i][j]=a[i][j-1];
                }
            }
        }

        for(int i=w-1;i>=0;i--){
            if(a[i][n]==a[w][n])
                max_weight--;
        }
//        System.out.println("DP Matrix");
//        for(int i=0;i<w+1;i++){
//            for(int j=0;j<n+1;j++){
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }


        max_value= a[w][n];
//        max_weight=b[w][n];


    }
}
