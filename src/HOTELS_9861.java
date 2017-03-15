import java.io.IOException;

/**
 * Created by anshu on 14/03/17.
 */
public class HOTELS_9861 {
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        int n = scan.nextInt();
        int m = scan.nextInt();
        double sum=0;
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i]=scan.nextInt();
        int i=0;
        while(i<n){
            if(a[i]<m)
                break;
            else i++;
        }
        int j=i+1;
        sum+=a[i];
        double global =sum;
        while(j<n&&i<n){
//            System.out.println(i+" "+j+" "+sum+" "+global);
            if(sum+a[j]<=m){
                sum+=a[j++];
                global=Math.max(sum,global);
            }
            else{
                sum-=a[i++];
            }
        }
        System.out.printf("%.0f",global);
    }
}
