import java.util.Scanner;

/**
 * Created by anshu on 12/02/17.
 */
public class WhatsNext_7974 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            double a = scan.nextDouble();
            double b = scan.nextDouble();
            double c = scan.nextDouble();
            if(a==0&&b==0&&c==0)
                return;
            else{
                if(b-a==c-b)
                    System.out.println("AP "+(int)(c-b+c));
                else if((c/b)==(b/a))
                    System.out.println("GP "+(int)((c)*(b/a)));
            }

        }
    }
}
