import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HourRank18_2 {

    public static void main(String[] args) {
//        Reader scan = new Reader();
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        char[] arr = s.toCharArray();
        double count=0;
        for (int i=0; i <s.length(); i++)
        {
            // Pick ending point
            for (int j=i; j<s.length(); j++)
            {
                // Print subarray between current starting
                // and ending points
                if(s.charAt(i)!='0'||i==j){
                    String p = s.substring(i,j+1);
                    try {
                        if(((p.charAt(p.length()-1)-'0')%2)==0){

                            if(isdivbythree(p)){
//                                System.out.println(p);
                                count += 1;
                            }
//                        if (new BigInteger(p).mod(BigInteger.valueOf(6)).equals(BigInteger.ZERO)) {
//                        System.out.println(p);

                        }
                    }catch (Exception e){

                    }

                }


            }
        }
        System.out.printf("%.0f",count);


    }

    private static boolean isdivbythree(String p) {
        double sum=0;
        for(int i=0;i<p.length();i++){
            sum+=p.charAt(i)-'0';
        }
        if(sum%3==0)
            return true;
        return false;
    }
}

