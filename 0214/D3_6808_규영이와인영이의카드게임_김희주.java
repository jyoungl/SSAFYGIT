import java.io.*;
import java.util.*;

public class D3_6808_규영이와인영이의카드게임 {
    static int lose, win;
    static boolean[] isSelected;
    static int[] inputCards;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(in.readLine());

            lose = 0;
            win = 0;
            inputCards = new int[9];
            isSelected = new boolean[19];

            for (int i = 0; i < 9; i++) {
                inputCards[i] = Integer.parseInt(st.nextToken());
                isSelected[inputCards[i]] = true;
            }

            pickCard(0, 0);

            sb.append(win).append(" ").append(lose).append("\n");
        }

        System.out.print(sb);
    }

    private static void pickCard(int cnt, int sumWin) {
        if (cnt == 9) {
            if (sumWin > 171 - sumWin) ++win;
            else if (sumWin < 171 - sumWin) ++lose;
            return;
        }

        for (int i = 1; i <= 18; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;

            if (inputCards[cnt] > i) pickCard(cnt + 1, sumWin + i + inputCards[cnt]);
            else pickCard(cnt + 1, sumWin);

            isSelected[i] = false;

        }

    }
}
