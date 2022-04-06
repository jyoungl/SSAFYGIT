import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3234_준환이의양팔저울 {
    private static int N, result;
    private static int[] weights;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            result = 0;
            int total = 0;

            N = Integer.parseInt(in.readLine());
            weights = new int[N];

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
                total += weights[i];
            }

            measure(0, 0, 0, total, 0);

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    private static void measure(int cnt, int left, int right, int stock, int flag) {
        int[] pow = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
        int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        //왼쪽 저울에 올라갈 순열을 찾음
        //다 찾으면 (인덱스=끝) +1하고, 찾다가 중간에 이미 left가 나머지보다 더 크면 +(나머지)!*(2^나머지)하고 리턴

        if (cnt == N) {
            ++result;
            return;
        }

        if (left >= stock + right) {
            result += factorial[N - cnt] * pow[N - cnt];
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((flag & 1 << i) != 0) continue;
            measure(cnt + 1, left + weights[i], right, stock - weights[i], flag | 1 << i);
            if (left >= right + weights[i]) {
                measure(cnt + 1, left, right + weights[i], stock - weights[i], flag | 1 << i);
            }
        }
    }
}
