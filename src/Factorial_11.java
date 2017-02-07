import java.util.Scanner;

/**
 * Created by anshu on 08/02/17.
 */
public class Factorial_11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            int n =scan.nextInt();
            int ans =0;
            int poweroffive=5;
            while(n>0){
                ans+=n/poweroffive;
                n/=poweroffive;
            }
            System.out.println(ans);
        }
    }
}
