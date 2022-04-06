import java.io.*;
import java.util.*;

public class BOJ_2961_도영이가만든맛있는음식 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        int[][] items = new int[N][2];//0 신맛 1 쓴맛
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < 1 << N; i++) {//2^N--> 모든 경우의 수
            int S = 1, B = 0;
            for (int j = 0; j < N; j++) { // 0001 0010 0100 1000
                if ((i & 1 << j) != 0) {
                    S *= items[j][0];
                    B += items[j][1];
                }
            }
            diff = Math.min(diff, Math.abs(S - B));
        }

        System.out.println(diff);

    }

}
