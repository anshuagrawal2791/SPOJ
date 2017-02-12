import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by anshu on 12/02/17.
 */
public class FashionShows_1025 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            int n = scan.nextInt();
            ArrayList<Integer> men = new ArrayList<>();
            ArrayList<Integer> women = new ArrayList<>();
            for(int i=0;i<n;i++)
                men.add(scan.nextInt());
            for(int i=0;i<n;i++)
                women.add(scan.nextInt());
            Collections.sort(men);
            Collections.sort(women);
            double sum=0;
            for(int i=0;i<n;i++)
                sum+=(double)men.get(i)*(double)women.get(i);
            System.out.printf("%.0f \n",sum);
        }
    }
}
