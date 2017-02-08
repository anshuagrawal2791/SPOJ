import java.util.Scanner;

/**
 * Created by anshu on 09/02/17.
 */
public class NumberSteps_1112 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            int x = scan.nextInt();
            int y=scan.nextInt();
            if(y==x){
                if(x%2==0){
                    System.out.println((2*x));
                }
                else
                    System.out.println((2*x)-1);
            }
            else if(y==(x-2)){
                if(y%2==0)
                    System.out.println(2*(y+1));
                else
                    System.out.println((2*y)+1);
            }
            else{
                System.out.println("No Number");
            }
        }
    }
}
