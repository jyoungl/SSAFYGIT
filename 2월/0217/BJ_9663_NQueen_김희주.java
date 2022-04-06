import java.util.Scanner;

public class BOJ_9663_NQueen2 {
    static int N, result;
    static boolean[] col, diagonalR, diagonalL;

    public static void main(String[] args) {
        N = new Scanner(System.in).nextInt();
        col = new boolean[N];
        diagonalR = new boolean[2 * N - 1];
        diagonalL = new boolean[2 * N - 1];
        setQueen(0);
        System.out.println(result);

    }

    private static void setQueen(int j) {
        if (j >= N) {
            ++result;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (col[i] || diagonalR[j + i] || diagonalL[j - i + N - 1]) continue;

            col[i] = true;
            diagonalR[j + i] = true;
            diagonalL[j - i + N - 1] = true;

            setQueen(j + 1);

            col[i] = false;
            diagonalR[j + i] = false;
            diagonalL[j - i + N - 1] = false;

        }
    }

}
