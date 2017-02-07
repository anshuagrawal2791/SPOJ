import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by anshu on 06/02/17.
 */
public class PRINT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rootb = (int)Math.sqrt(Integer.MAX_VALUE);
//        int [] primes  = new int [rootb];
        boolean [] primes_till_root_max = new boolean[rootb];
        ArrayList<Integer> primes = new ArrayList<>();
        boolean flag = false;

        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            //first find primes till root(b) by sieve of eratosthenes
            if(!flag){
                for(int i=1;i<rootb;i++){
                    if(!primes_till_root_max[i]){
                        primes.add(i+1);
                        for(int j=2*(i+1)-1;j<rootb;j+=i+1){
                            primes_till_root_max[j]=true;
                        }
                    }
                }
                flag=true;
            }
            if(b<=rootb){

                for(int i=a;i<=b;i++){
                    if(primes.contains(i))
                        System.out.println(i);
                }
//                System.out.println();

            }
            else if(a<rootb){
//                System.out.println("case2");
                for(int i=a;i<=rootb;i++)
                    if(primes.contains(i))
                        System.out.println(i);

                a=rootb;
                ArrayList<Integer> aux2 = new ArrayList<>();
                for(int i=a;i<=b;i++)
                    if(i!=1)
                        aux2.add(i);

                int ha = (int)Math.sqrt(b);
                for(int i=0;i<primes.size()&&primes.get(i)<=ha;i++){
                    for(int j=0;j<aux2.size();j++){
                        if(aux2.get(j)%primes.get(i)==0){
                            aux2.remove(j);
                            j--;
                        }
                    }
                }
                for(int i=0;i<aux2.size();i++)
                System.out.println(aux2.get(i));


            }
            else{
                System.out.println("case3");
                ArrayList<Integer> aux2 = new ArrayList<>();
                for(int i=a;i<=b;i++)
                    if(i!=1)
                        aux2.add(i);
                System.out.println(aux2);
                int ha = (int)Math.sqrt(b);
                for(int i=0;i<primes.size()&&primes.get(i)<=ha;i++){
                    for(int j=0;j<aux2.size();j++){
                        if(aux2.get(j)%primes.get(i)==0){
                            aux2.remove(j);
                            j--;
                        }
//                        System.out.println(aux2);
                    }

                }
                for(int i=0;i<aux2.size();i++)
                    System.out.println(aux2.get(i));
            }

//            ArrayList<Integer> aux2 = new ArrayList<>();
//            for(int i=a;i<=b;i++)
//                if(i!=1)
//                    aux2.add(i);
////            System.out.println(primes);
//            for(int i = 0;i<primes.size();i++){
//                for(int j=0;j<aux2.size();j++){
//                    if(aux2.get(j)%primes.get(i)==0)
//                    {
//                        aux2.remove(j);
//                        j--;
//                    }
//                }
//                if(primes.get(i)>=a&&primes.get(i)<=b)
//                    aux2.add(primes.get(i));
//            }
//            Collections.sort(aux2);
//            for(int i=0;i<aux2.size();i++)
//                System.out.println(aux2.get(i));
//
//            System.out.println();




        }
    }
}
