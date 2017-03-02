import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by anshu on 28/02/17.
 */
// http://www.spoj.com/problems/PALIN/

    ///not a very good solution

public class PALIN_5 {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int t = scan.nextInt();
//        for (int p = 0; p < t; p++) {
//            BigInteger x = scan.nextBigInteger();
////            x++;
//            String s = x + "";
//            char[] a = s.toCharArray();
////            if (!isPalindrome(a)) {
//                boolean left_incremented = false;
//                if (a.length % 2 == 0) {
////                    x--;
//                    String temp = x + "";
//                    if (isPalindrome(temp.toCharArray())&&!(a[a.length/2]=='9'&&a[a.length/2-1]=='9')) {
//                        a=temp.toCharArray();
//                        a[a.length/2]++;
//                        a[a.length/2-1]++;
//                        System.out.println(a);
//                    }
//                    else {
//                        x=x.add(BigInteger.ONE);
//                        s = x+"";
//                        a=s.toCharArray();
//                        for (int i = a.length / 2 - 1; i >= 0; i--) {
//                            if (a[i] == a[a.length - 1 - i])
//                                continue;
//                            else {
//                                if (!left_incremented) {
//                                    if (a[i] < a[a.length - 1 - i]) {
//                                        a[i]++;
//                                        a[a.length - 1 - i] = a[i];
//                                        left_incremented = true;
//                                    } else {
//                                        a[a.length - 1 - i] = a[i];
//                                        left_incremented = true;
//                                    }
//
//                                } else {
//                                    a[a.length - i - 1] = a[i];
//                                }
//                            }
//                        }
//                        System.out.println(a);
//                    }
//                } else {
////                    x--;
//                    String temp = x + "";
//                    String y = temp.substring(0, temp.length() / 2).concat(temp.substring(temp.length() / 2 + 1, temp.length()));
////                    System.out.println(y);
//                    if (!isPalindrome(y.toCharArray()) || a[a.length / 2] == '9') {
//                        x=x.add(BigInteger.ONE);
//                        s = x+"";
//                        a=s.toCharArray();
//                        for (int i = a.length / 2 - 1; i >= 0; i--) {
//                            if (a[i] == a[a.length - 1 - i])
//                                continue;
//                            else {
//                                if (!left_incremented) {
//                                    if (a[i] < a[a.length - 1 - i]) {
//                                        a[i]++;
//                                        a[a.length - 1 - i] = a[i];
//                                        left_incremented = true;
//                                    } else {
//                                        a[a.length - 1 - i] = a[i];
//                                        left_incremented = true;
//                                    }
//
//                                } else {
//                                    a[a.length - i - 1] = a[i];
//                                }
//                            }
//                        }
//                        System.out.println(a);
//                    } else {
//                        a = temp.toCharArray();
//                        a[a.length / 2]++;
//                        System.out.println(a);
//                    }
//                }
//
////            } else {
////                System.out.println(x);
////            }
//        }
//    }
//
//    static boolean isPalindrome(char[] data) {
//        for (int i = 0; i < data.length / 2; i++) {
//            if (data[i] != data[data.length - 1 - i])
//                return false;
//        }
//        return true;
//    }

    //copied from TomConerly github
    static void p(Object o){ System.out.println(o);}
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int zz = sc.nextInt();
        for(int z = 0; z < zz;z++)
        {
            String s = sc.next();

            String ans = s.substring(0,s.length()/2);
            if(s.length()%2 == 1)
            {
                ans = ans + s.charAt((s.length()/2))+rev(ans);
            }else
                ans += rev(ans);
            if(larger(ans,s))
            {
                System.out.println(ans);
            }else{
                boolean done = false;
                for(int i = (s.length()-1)/2;i>=0;i--)
                {
                    if(ans.charAt(i) != '9')
                    {
                        done = true;
                        if(i == s.length()/2 && s.length()%2 == 1)
                        {
                            ans = ans.substring(0,s.length()/2)+((char)(ans.charAt(i)+1))+ans.substring(s.length()/2+1);
                        }else{
                            if(s.length()%2 == 1)
                            {
                                ans = ans.substring(0,i)+((char)(ans.charAt(i)+1))+zeros(s.length()/2 - i-1);
                                ans = ans+"0"+rev(ans);
                            }else{
                                ans = ans.substring(0,i)+((char)(ans.charAt(i)+1))+zeros(s.length()/2 - i-1);
                                ans = ans+rev(ans);
                            }
                        }
                        break;
                    }
                }
                if(done) System.out.println(ans);
                else
                {
                    ans = "1";
                    while(ans.length() < s.length())
                        ans +="0";
                    ans += "1";
                    System.out.println(ans);
                }
            }
        }
    }

    private static String zeros(int i) {
        StringBuilder z = new StringBuilder();
        for(int j = 0; j < i;j++)
            z.append("0");
        return z.toString();
    }
    private static boolean larger(String ans, String s) {
        for(int i = 0; i < ans.length();i++)
        {
            char a = ans.charAt(i);
            char b = s.charAt(i);
            if(a < b) return false;
            if(a > b) return true;
        }
        return false;
    }

    private static String rev(String ans) {
        StringBuilder st = new StringBuilder(ans);
        return st.reverse().toString();
    }
}
