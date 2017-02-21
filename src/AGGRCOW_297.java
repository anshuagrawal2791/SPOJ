import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by anshu on 21/02/17.
 */
public class AGGRCOW_297 {
    static ArrayList<Integer> list;
    static int k;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            int n = scan.nextInt();
            k = scan.nextInt();
            list = new ArrayList<>();
            for(int i=0;i<n;i++)
                list.add(scan.nextInt());
            Collections.sort(list);
            binarysearch();
        }
    }

    private static void binarysearch() {
        int l=0;
        int h=list.get(list.size()-1)-list.get(0);
        while(l<h){
            int mid = (h+l)/2;
            if(check(mid))
                l=mid+1;
            else
                h=mid;
        }
        System.out.println(l-1);


    }

    private static boolean check(int mid) {
        int prev = list.get(0);
        int temp=1;

        for(int i=1;i<list.size();i++){
            if(list.get(i)-prev>=mid){
                temp++;
                if(temp==k)
                    return true;
                prev=list.get(i);
            }

        }
        return false;


    }
}
