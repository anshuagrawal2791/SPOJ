import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by anshu on 23/02/17.
 */
// http://www.spoj.com/problems/ACODE/     //

public class ACODE_394 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            String s = scan.next();
            if(s.equals("0"))
                return;
            HashMap<String,Double> map = new HashMap<>();
            for(int i=s.length()-1;i>=0;i--){
                String curr = s.substring(i,s.length());
                double x=0;
                if(Integer.parseInt(curr.substring(0,1))==0){
                    map.put(curr,(double)0);
                    continue;
                }
                if(curr.length()==1){
                    map.put(curr,(double)1);
                    continue;
                }
                else{
                    if(curr.length()==2){
                        double y = Double.parseDouble(curr);
                        if(y<=26)
                            x+=1;
                        x+=map.get(curr.substring(1,curr.length()));
                        map.put(curr,x);
                    }
                    else{
                        double y = Double.parseDouble(curr.substring(0,2));
                        if(y<=26)
                            x+=map.get(curr.substring(2,curr.length()));
                        x+=map.get(curr.substring(1,curr.length()));
                        map.put(curr,x);
                    }
                }
            }
            System.out.printf("%.0f \n",map.get(s));
        }
    }
}
