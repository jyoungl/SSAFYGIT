package feb15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2098_외판원순회_이주영 {
    static int N;
    static final int notcycle = 17 * 1000000 + 1;
    static final int min = notcycle * 2;
    static int[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        //N개의 도시 방문현황의 최대값: 11111..(2) = 1<<N
        dp = new int[N][(1<<N)];
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                arr[i][j] = x;
            }
            Arrays.fill(dp[i], min);
        }

        dp[0][0] = 0;
        System.out.println(visit(0, 0));
    }

    //city: 현재 위치한 도시, mask: 지금까지 방문한 도시를 2진수로 나타냄
    public static int visit(int city, int mask) {
        mask = mask | (1 << city); //방문 처리

        if (mask == (1 << N) - 1) {//모든 도시 방문
            if (arr[city][0] == 0) {//처음으로 갈 수 없음
                return notcycle;
            }
            //처음 도시로 돌아감
            return arr[city][0];
        }
        
        if (dp[city][mask] != min)
            return dp[city][mask];

        for (int i = 0; i < N; i++) {
            //i로 갈 수 있음
            if (arr[city][i] != 0) {
                //아직 i 도시 방문 안함
                if ((mask & (1 << i)) == 0) {
                    //현재 상황에서 남은 노드들을 방문하는 최소값
                    int tmp = visit(i, mask) + arr[city][i];
                    
                    //tmp(도시 i에서 남은 노드들을 방문하는 경우)가 원래 저장되어 있는 값보다 작으면
                    //갱신 필요
                    if(dp[city][mask] > tmp)
                        dp[city][mask] = tmp;
                }
            }
        }
        
        return dp[city][mask];
    }
}
