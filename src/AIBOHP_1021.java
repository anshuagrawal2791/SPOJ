import java.io.*;
import java.util.Map;

/**
 * Created by anshu on 14/03/17.
 */
public class AIBOHP_1021 {
    static int cache[][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String str = br.readLine();
            int n = str.length();
            cache = new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    cache[i][j]=-1;
            Integer ans = n - lcs(str.toCharArray(),
                    new StringBuffer(str).reverse().toString().toCharArray(),n-1,n-1);


            System.out.println(ans);

        }

    }

    private static int lcs(char[] s, char[] rs, int i, int j) {
        if(i<0||j<0){
            return 0;
        }
        if(cache[i][j]!=-1)
            return cache[i][j];

        if(s[i]==rs[j]){
            cache[i][j]=(1+lcs(s,rs,i-1,j-1));
            return cache[i][j];
        }else{
            cache[i][j]= Math.max(lcs(s,rs,i-1,j),lcs(s,rs,i,j-1));
            return cache[i][j];
        }
    }
}

