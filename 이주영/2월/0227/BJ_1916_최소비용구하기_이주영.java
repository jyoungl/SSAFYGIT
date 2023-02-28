package feb27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1916_최소비용구하기_이주영 {
    public static boolean[] visited;
    public static int N, min=Integer.MAX_VALUE;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[s][e] = c;
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        visited[start] = true;
        dfs(0, end, start, 0);
        System.out.println(min);
    }
    
    public static void dfs(int cnt, int e, int now, int sum) {
        if (now == e) {
            min = Math.min(min, sum);
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if(visited[i] || i==now || arr[now][i] == 0)
                continue;
            
            visited[i] = true;
            dfs(cnt + 1, e, i, sum + arr[now][i]);
            visited[i] = false;
        }
    }
}
