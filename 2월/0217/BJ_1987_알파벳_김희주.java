import java.io.*;
import java.util.*;

public class BOJ_1987_알파벳 {
    static int R, C, result;
    static char[][] board;
    static char[] check;
    static int[][] deltas = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};//상-좌-하-우

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int r = 0; r < R; r++) {
            String line = in.readLine();
            for (int c = 0; c < C; c++) {
                board[r][c] = line.charAt(c);
            }
        }

        //함수 호출하기
        check = new char[26];
        move(0, 0, 0);

        //출력하기
        System.out.println(result);
    }

    private static void move(int cnt, int r, int c) {
        check[cnt] = board[r][c];
        result = Math.max(result, cnt + 1);

        for (int d = 0; d < 4; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];

            if (isAvailable(cnt, nr, nc)) move(cnt + 1, nr, nc);
        }

    }

    private static boolean isAvailable(int cnt, int nr, int nc) {
        if (nr < 0 || nr >= R) return false;
        if (nc < 0 || nc >= C) return false;

        for (int i = 0; i <= cnt; i++) {
            if (check[i] == board[nr][nc]) return false;
        }

        return true;
    }
}
