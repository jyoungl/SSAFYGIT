import java.util.Scanner;

public class D3_3499_퍼펙트셔플 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            int N = in.nextInt();
            String[] cards = new String[N];

            //입력
            int idx = 0;
            for (int i = 0; i < N; i++) {
                cards[idx] = in.next();
                idx += 2;

                if (idx >= N) idx = 1;
            }

            //출력
            for (int i = 0; i < N; i++) {
                sb.append(cards[i]).append(" ");
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
