import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by anshu on 23/03/17.
 */
public class ACODE_394_2 {
    static int cache[];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            String s = scan.next();
            if(s.equals("0"))
                return;
            int n = s.length();
            cache= new int[n];
            Arrays.fill(cache,-1);
//            double t0 = System.nanoTime();
//            System.out.println(check(s,0,n-1)+"");
//            double t1 = System.nanoTime();
//            System.out.println("time: "+(t1-t0));
//            t0 = System.nanoTime();
            System.out.println(check2(s,0,n-1)+"");
//            t1 = System.nanoTime();
//            System.out.println("time: "+(t1-t0));

        }
    }

    private static int check2(String s, int i, int n) {
        if(cache[i]!=-1)
            return cache[i];
        if(i>n)
            cache[i]= 0;
        else if(s.charAt(i)=='0')
            cache[i]= 0;
        else if(i==n)
            cache[i]= 1;
        else if(i==n-1) {
            if (Integer.parseInt(s.substring(i, n + 1)) <= 26){
                if(s.charAt(n)!='0')
                    cache[i]=2;
                else cache[i]=1;
            }
            else{
                if(s.charAt(n)!='0')
                    cache[i]=1;
                else cache[i]=0;
            }

        }
        else if(Integer.parseInt(s.substring(i,i+2))<=26)
            cache[i]= check2(s,i+2,n)+check2(s,i+1,n);
        else cache[i]= check2(s,i+1,n);
        return cache[i];
    }

    private static int check(String s, int i, int n) {
        if(i>n)
            return 0;
        if(s.charAt(i)=='0')
            return 0;
        if(i==n)
            return 1;
        if(i==n-1) {
            if (Integer.parseInt(s.substring(i, n + 1)) <= 26&&s.charAt(n)!='0')
                return 2;
            else if (Integer.parseInt(s.substring(i, n + 1)) <= 26)
                return 1;
            else return 0;
        }
        if(Integer.parseInt(s.substring(i,i+2))<=26)
            return check(s,i+2,n)+check(s,i+1,n);
        else return check(s,i+1,n);

    }
}
