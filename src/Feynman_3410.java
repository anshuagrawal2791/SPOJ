import java.util.Scanner;

/**
 * Created by anshu on 09/02/17.
 */
public class Feynman_3410 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double n = scan.nextDouble();
        while(n>0){
            System.out.printf("%.0f \n",(n*(n+1)*(2*n+1)/6));
            n = scan.nextDouble();
        }
    }
}
