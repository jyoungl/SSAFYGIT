import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_5215_햄버거다이어트 {
    static int N, L;
    static int[][] ingredients;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            //입력
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            ingredients = new int[N][2]; //0 :  맛 점수, 1 : 칼로리

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(in.readLine());
                ingredients[n][0] = Integer.parseInt(st.nextToken());
                ingredients[n][1] = Integer.parseInt(st.nextToken());
            }

            //탐색+출력
            sb.append(calcTaste(0, 0, 0)).append("\n");
        }

        System.out.print(sb);
    }


    public static int calcTaste(int score, int cal, int n) {
        if (score > L) return 0;
        if (n == N) return cal;

        return Math.max(calcTaste(score + ingredients[n][1], cal + ingredients[n][0], n + 1),
                calcTaste(score, cal, n + 1));
    }
}
