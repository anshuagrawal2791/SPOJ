import java.util.Scanner;

/**
 * Created by anshu on 02/03/17.
 */
public class HourRank18_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m =scan.nextInt();
        int n = scan.nextInt();
        int current =m;
        for(int i=0;i<n;i++ ){
            int a =scan.nextInt();
            int b = scan.nextInt();
            if(a==current||b==current){
                if(a==current)
                    current=b;
                else
                    current=a;
            }
        }
        System.out.println(current);
    }
}
