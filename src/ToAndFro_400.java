import java.util.Scanner;

/**
 * Created by anshu on 12/02/17.
 */
public class ToAndFro_400 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            int n = scanner.nextInt();
            if(n==0)
                return;
            String s = scanner.next();
            char[] string = s.toCharArray();
            int lenght = s.length();
            int step = lenght/n;
            char a[][] = new char [step][n];
            int counter=0;
            for(int i=0;i<step;i++){
                if(i%2==0){
                    for(int j=0;j<n;j++,counter++){
                        a[i][j]=string[counter];
                    }
                }
                else{
                    for(int j=n-1;j>=0;j--,counter++){
                        a[i][j]=string[counter];
                    }
                }

            }
            for(int i=0;i<n;i++){
                for(int j=0;j<step;j++){
                    System.out.print(a[j][i]);
                }
            }
            System.out.println();
        }
    }
}
