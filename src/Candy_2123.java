import java.util.Scanner;

/**
 * Created by anshu on 12/02/17.
 */
public class Candy_2123 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            int n = scan.nextInt();
            if(n==-1)
                return;
            int a[] = new int[n];
            int sum=0;
            for(int i=0;i<n;i++){
                a[i]=scan.nextInt();
                sum+=a[i];
            }
            if(!((double)sum/(double)n==sum/n)){
                System.out.println(-1);
            }
            else{
                sum=sum/n;
                double ans=0;
                for(int i=0;i<n;i++){
                    if(a[i]<sum)
                        ans+=sum-a[i];
                }
                System.out.printf("%.0f \n",ans);
            }

        }
    }
}
