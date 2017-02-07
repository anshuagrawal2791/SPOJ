import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by anshu on 06/02/17.
 */

//very inefficient
public class PrimeGenerator_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            //first find primes till root(b) by sieve of eratosthenes

            int rootb = (int)Math.sqrt(b);
            ArrayList<Integer> primes = new ArrayList<>();
            boolean [] aux = new boolean[rootb];
            for(int i=1;i<rootb;i++){
                if(!aux[i]){
                    primes.add(i+1);
                    for(int j=2*(i+1)-1;j<rootb;j+=i+1){
                        aux[j]=true;
                    }
                }

            }
            ArrayList<Integer> aux2 = new ArrayList<>();
            for(int i=a;i<=b;i++)
                if(i!=1)
                aux2.add(i);
//            System.out.println(primes);
            for(int i = 0;i<primes.size();i++){
                for(int j=0;j<aux2.size();j++){
                    if(aux2.get(j)%primes.get(i)==0)
                    {
                        aux2.remove(j);
                        j--;
                    }
                }
                if(primes.get(i)>=a&&primes.get(i)<=b)
                    aux2.add(primes.get(i));
            }
            Collections.sort(aux2);
            for(int i=0;i<aux2.size();i++)
                System.out.println(aux2.get(i));

                System.out.println();




        }
    }
}
