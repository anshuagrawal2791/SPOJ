import java.io.IOException;
import java.util.Stack;

/**
 * Created by anshu on 08/03/17.
 */
public class STPAR_95 {
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        while(true){
            int n = scan.nextInt();
            if(n==0)
                return;
            int a[] = new int[n];
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<n;i++){
                a[i]=scan.nextInt();
            }
            int counter =1;
            int i=0;
            boolean state=true;
            for(i=0;i<a.length;i++){
                while(!stack.isEmpty()&&stack.peek()==counter){
                    counter++;
                    stack.pop();
                }
                if(a[i]==counter){
                    counter++;
                }
                else if(!stack.isEmpty()&&stack.peek()<a[i]){
                    state=false;
                    break;
                }
                else{
                    stack.push(a[i]);
                }
            }

            if(state)
                System.out.println("yes");
            else
                 System.out.println("no");
        }
    }
}

