import java.util.Scanner;

/**
 * Created by anshu on 23/03/17.
 */
public class CANTON_302 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            int l = scan.nextInt();
            int i;
            for(i=1;;i++){
                if((i)*(i+1)>=(2*l))
                    break;

            }
            i--;
            int a = l - ((i*(i+1))/2);
            int b = i+2-a;
            if(i%2!=0)
                System.out.println("TERM "+l+" IS "+a+"/"+b);
            else
                System.out.println("TERM "+l+" IS "+b+"/"+a);

        }
    }
}
