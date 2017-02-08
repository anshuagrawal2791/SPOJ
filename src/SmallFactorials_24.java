import java.util.Scanner;

/**
 * Created by anshu on 08/02/17.
 */
public class SmallFactorials_24 {
    public static int[] a;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            int n = scan.nextInt();
            findFactorial(n);
        }
    }

    private static void findFactorial(int n) {
        a = new int[160];
        a[0]=1;
        int size=1;
        for(int i=2;i<=n;i++){
            size = multiply(a,i,size);
        }
//        System.out.println(a[0]);
        for(int i=size-1;i>=0;i--)
            System.out.print(a[i]);
        System.out.println();
    }

    private static int multiply(int[] a, int multiplier, int size) {
        int carry=0;
        for(int i=0;i<size;i++){
            int prod = a[i]*multiplier+carry;
            carry = prod/10;
            a[i]=prod%10;
        }
        while(carry>0){
            a[size]=carry%10;
            carry=carry/10;
            size++;
        }
        return size;
    }
}
