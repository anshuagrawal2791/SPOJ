import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by anshu on 15/03/17.
 */
class BITMAP_206 {
    static class Point{
        int i,j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static int xmove[] = new int[]{0,0,1,-1};
    static int ymove[] = new int[]{1,-1,0,0};


    static int a[][];
    static int dist[][];
    static int n,m;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int p=0;p<t;p++){
            n = scan.nextInt();
            m = scan.nextInt();
             a = new int[n][m];
            dist = new int[n][m];
            for(int i=0;i<n;i++){
                String s = scan.next();
                for(int j=0;j<m;j++){
                    a[i][j]=s.charAt(j)-48;
                    if(a[i][j]==0)
                        dist[i][j]=Integer.MAX_VALUE;
                    else
                        dist[i][j]=0;
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(a[i][j]==1){
                        bfs(new Point(i,j));
                    }
                }
            }

//            for(int i=0;i<n;i++){
//                for(int j=0;j<m;j++){
//                    System.out.print(a[i][j]+" ");
//                }
//                System.out.println();
//            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    System.out.print(dist[i][j]+" ");
                }
                System.out.println();
            }

        }
    }

    private static void bfs(Point source) {
        boolean visited[][] = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        q.add(source);
        visited[source.i][source.j]=true;
        dist[source.i][source.j]=0;
        while(!q.isEmpty()){
            Point curr = q.poll();
            for(int i=0;i<4;i++){
                if(isvalid(curr.i+ymove[i],curr.j+xmove[i])){
                    if(!visited[curr.i+ymove[i]][curr.j+xmove[i]]&&a[curr.i+ymove[i]][curr.j+xmove[i]]!=1&&dist[curr.i+ymove[i]][curr.j+xmove[i]]>dist[curr.i][curr.j]+1){
                        dist[curr.i+ymove[i]][curr.j+xmove[i]]=dist[curr.i][curr.j]+1;
                        q.add(new Point(curr.i+ymove[i],curr.j+xmove[i]));
                        visited[curr.i+ymove[i]][curr.j+xmove[i]]=true;
                    }
                }
            }
        }
    }

    private static boolean isvalid(int i, int j) {
        if(i>=0&&i<n&&j>=0&&j<m)
            return true;
        return false;
    }
}

