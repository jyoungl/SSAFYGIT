import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16926_배열돌리기1 {
    static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};//아래, 오른쪽, 위, 왼쪽
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < R; r++) {
            for (int i = 0; ; i++) {
                if (i >= N / 2 || i >= M / 2) break;
                turnArr(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void turnArr(int i) {
        int y = i, x = i;
        int d = 0;//방향
        int num = arr[y][x];

        while (true) {
            if (d == 4) break;

            int tmpy = y + deltas[d][0];
            int tmpx = x + deltas[d][1];

            if (tmpx < i || tmpx >= M-i || tmpy < i || tmpy >= N-i) {
                ++d;
                continue;
            }

            int n = num;
            num = arr[tmpy][tmpx];
            arr[tmpy][tmpx] = n;

            y = tmpy;
            x = tmpx;
        }
    }
}
