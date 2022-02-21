import java.io.*;
import java.util.*;
 
public class BJ_15683_감시_이주영 {
    static int n,m;
    static int[][] map;
    static int[] tx = {0, 0, 1, -1};
    static int[] ty = {1, -1, 0, 0};
    static int min = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
 
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(reader.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, -1);
        System.out.println(min);
    }
 
    static void dfs(int idx, int cnt) {
        if(idx == n * m) { //배열의 끝까지 도착
            min = Math.min(min, count());
            return;
        }
        
        int r = idx / m;
        int c = idx % m;
        
        if(map[r][c] == 1) { //0, 1, 2, 3
            for(int i=0; i<4; i++) {
                monitor(idx, i, 0, cnt);
                dfs(idx+1, cnt-1);
                monitor(idx, i, cnt, 0);
            }
        } else if(map[r][c] == 2) { //01, 23
            for(int i=0; i<4; i+=2) {
                monitor(idx, i, 0, cnt);
                monitor(idx, i+1, 0, cnt);
                dfs(idx+1, cnt-1);
                monitor(idx, i, cnt, 0);
                monitor(idx, i+1, cnt, 0);
            }
        } else if(map[r][c] == 3) { //02, 03, 12, 13
            for(int i=0; i<2; i++) {
                monitor(idx, i, 0, cnt);
                for(int j=2; j<4; j++) {
                    monitor(idx, j, 0, cnt);
                    dfs(idx+1, cnt-1);
                    monitor(idx, j, cnt, 0);
                }
                monitor(idx, i, cnt, 0);
            }
        } else if(map[r][c] == 4) { //012, 013, 023, 123
            for(int i=3; i>=0; i--) {
                for(int j=0; j<4; j++) {
                    if(i==j) continue;
                    monitor(idx, j, 0, cnt);
                }
                dfs(idx+1, cnt-1);
                for(int j=0; j<4; j++) {
                    if(i==j) continue;
                    monitor(idx, j, cnt, 0);
                }
            }
        } else if(map[r][c] == 5) { //0123
            for(int i=0; i<4; i++) {
                monitor(idx, i, 0, cnt);
            }
            dfs(idx+1, cnt-1);
            for(int i=0; i<4; i++) {
                monitor(idx, i, cnt, 0);
            }
        } else dfs(idx+1, cnt-1); //1~5까지 수가 아닐 때 다음 수로 호출
    }
    
    static void monitor(int idx, int dir, int orignal, int change) { //한가지 방향만 채워줌
        int r = idx / m;
        int c = idx % m;
        while(true) {
            r += tx[dir];
            c += ty[dir];
            if(r>=0 && r<n && c>=0 && c<m) {
                if(map[r][c] == 6) break;
                if(map[r][c] == orignal) map[r][c] = change;
            } else {
                break;
            }
        }
    }
    
    static int count() {
        int cnt = 0;
        for(int[] temp : map) {
            for(int v : temp) {
                if(v==0) cnt++;
            }
        }
        return cnt;
    }
}