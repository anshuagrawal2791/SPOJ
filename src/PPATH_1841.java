import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by anshu on 17/03/17.
 */
public class PPATH_1841 {
    static boolean check[] = new boolean[10009];
    static void sieve(){
        for(int i=2;i<=100;i++)
        {
            if(!check[i])
            {
                for(int j=i*i;j<=10000;j+=i)
                    check[j] = true;
            }
        }
    }
//    static class node{
//        int number,level;
//
//        public node(int number, int level) {
//            this.number = number;
//            this.level = level;
//        }
//    }
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        int t = scan.nextInt();
        sieve();
        for(int p=0;p<t;p++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            bfs(a,b);
        }
    }

    private static void bfs(int source, int b) {
        Queue<Integer> q = new LinkedList<>();
        int distance[] = new int[10009];
        Arrays.fill(distance,-1);
        q.add(source);
        distance[source]=0;
        while(!q.isEmpty()){
            int currInt = q.poll();
            int currLevel = distance[currInt];
//            System.out.println(currInt);
            if(currInt==b){
                System.out.println(currLevel);
                return;
            }
            for(int i=0;i<4;i++){
                if(i!=0){
                    for(int j=0;j<=9;j++){
                        char number[] = (currInt+"").toCharArray();
                        number[i]=(char)(j+'0') ;
                        int newInt=Integer.parseInt(new String(number));
                        if(!check[newInt]&&distance[newInt]==-1){
                            q.add(newInt);
                            distance[newInt]=currLevel+1;
                        }
                    }
                }
                else{
                    for(int j=1;j<=9;j++){
                        char number[] = (currInt+"").toCharArray();
                        number[i]=(char)(j+'0') ;
                        int newInt=Integer.parseInt(new String(number));
                        if(!check[newInt]&&distance[newInt]==-1){
                            q.add(newInt);
                            distance[newInt]=currLevel+1;
                        }
                    }
                }
            }
        }
        System.out.println("Impossible");
        return;

    }

    private static boolean isPrime(int n) {
        if (n <= 1)  return false;
        if (n <= 3)  return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n%2 == 0 || n%3 == 0) return false;

        for (int i=5; i*i<=n; i=i+6)
            if (n%i == 0 || n%(i+2) == 0)
                return false;

        return true;
    }
}
