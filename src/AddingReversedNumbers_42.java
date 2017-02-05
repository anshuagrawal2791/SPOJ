import java.util.Scanner;



/**
 * Created by anshu on 05/02/17.
 */
public class AddingReversedNumbers_42 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            System.out.println(reverse(reverse(a)+reverse(b)));

        }
    }
    static int reverse(int a ){
        int x = 0;
        while(a>0){
            x=(x*10)+(a%10);
            a/=10;
        }
        return x;
    }


}
