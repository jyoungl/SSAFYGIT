import java.io.*;
import java.util.*;

public class SW_4012_요리사 {
    static int min, N, halfN;
    static int[][] items;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            N = Integer.parseInt(in.readLine());
            halfN = N / 2;
            items = new int[N][N];

            //시너지
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    items[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            findMin(0, 0,0);

            sb.append(min).append("\n");

        }
        System.out.print(sb);
    }

    private static void findMin(int cnt, int start, int flag) {
        if (cnt == halfN) {
            int a = 0, b = 0;

            for (int i = 0; i < N - 1; i++) {
                boolean isA = (flag & 1 << i) != 0;

                for (int j = i + 1; j < N; j++) {
                    if (isA && (flag & 1 << j) != 0) a += (items[i][j] + items[j][i]); //둘다 a가 뽑음
                    else if (!isA && (flag & 1 << j) == 0) b += (items[i][j] + items[j][i]); //둘다 b가 뽑음
                }

            }

            min = Math.min(Math.abs(a - b), min);
            return;
        }

        for (int i = start; i < N; i++) {
            findMin(cnt + 1, i+1,flag | 1 << i);
        }
    }
}
