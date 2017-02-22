import java.util.Scanner;

/**
 * Created by anshu on 22/02/17.
 */
public class INVCNT_6256 {
//    static int[] a;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        for(int p=0;p<t;p++){
            scan.nextLine();
            int n = Integer.parseInt(scan.nextLine());
            int [] a = new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(scan.nextLine());
            System.out.println(countinversions(a,0,a.length-1));
        }
    }

    private static int countinversions(int [] a,int low,int high) {
        int inv=0;
        if(low<high){
            int mid = (low+high)/2;
            inv = countinversions(a,low,mid);
            inv+=countinversions(a,mid+1,high);
            inv+=merge(a,low,mid+1,high);
        }
        return inv;
    }

    private static int merge(int[] a, int low, int mid, int high) {

        int temp[] = new int[a.length];
        int i,j,k,inversions=0;
        i=low;
        j=mid;
        k=low;
        while(i<mid&&j<=high){
            if(a[i]<a[j]){
                temp[k++]=a[i];
                i++;
            }else{
                temp[k++]=a[j];
                j++;
                inversions+=mid-i;
            }

        }

        while(i<mid)
            temp[k++]=a[i++];
        while(j<=high)
            temp[k++]=a[j++];

        for(int r=low;r<=high;r++)
            a[r]=temp[r];


        return inversions;

    }
}
