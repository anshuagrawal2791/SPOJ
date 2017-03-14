import java.io.IOException;

/**
 * Created by anshu on 14/03/17.
 */

// useful resource https://www.quora.com/Are-there-any-good-resources-or-tutorials-for-dynamic-programming-besides-the-TopCoder-tutorial/answer/Michal-Danilák
public class TRT_740 {
    static int n;
    static int[][] cache;
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        n = scan.nextInt();
        int a[] = new int[n];
        cache = new int[n][n];

        for(int i=0;i<n;i++)
            a[i]=scan.nextInt();

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                cache[i][j]=-1;
        System.out.println(recur(a,0,n-1));
    }

    private static int recur(int[] a, int l, int r) {
        int age = n-(r-l+1)+1;
        if(cache[l][r]!=-1)
            return cache[l][r];
        if(l==r)
            return a[l]*age;

        cache[l][r]=Math.max(age*a[l]+recur(a,l+1,r),age*a[r]+recur(a,l,r-1));
        return cache[l][r];
    }
}
