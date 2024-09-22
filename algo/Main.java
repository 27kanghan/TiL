import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
//
public class Main {
    public static class Point {
        int x;
        int y;
        

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int dr[] = {0,1,0,-1};
    static int dc[] = {1,0,-1,0};
    static int n,m;

    static int map[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();


        if(visited[n-1][m-1]){
            sb.append(1);
        }else{
            sb.append(0);
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();



    }

    private static void bfs(){
        Queue<Point> q = new ArrayDeque<>();

        Point start = new Point(0,0);
        q.add(start);

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int d = 0; d < 4; d++) {
                int nr = p.x + dr[d];
                int nc = p.y + dc[d];

                if(canGo(nr,nc)){
                    q.add(new Point(nr,nc));
                    visited[nr][nc] = true;
                }

            }



        }
    }

    private static boolean canGo(int nr, int nc) {

        if(!inRange(nr,nc)) return false;

        if(map[nr][nc] == 0 || visited[nr][nc]) return false;

        return true;
    }

    private static boolean inRange(int nr, int nc){
        return nr >= 0 && nr < n && nc >= 0 && nc <n;
    }
}
