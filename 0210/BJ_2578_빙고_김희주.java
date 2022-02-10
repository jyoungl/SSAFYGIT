import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2578_빙고 {
    static int[][] bingo;
    static int bingoCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력
        bingo = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 5; j++) {
                if (removeBingo(Integer.parseInt(st.nextToken()))) {
                    System.out.println(i * 5 + j + 1);
                    return;
                }
            }
        }
    }

    private static boolean removeBingo(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == num) {
                    bingo[i][j] = 0;
                    checkBingo(i, j);
                    return bingoCnt >= 3;
                }
            }
        }

        return false;
    }

    private static void checkBingo(int x, int y) {
        //세로 -> y를 0으로 설정
        //가로 -> x를 0으로 설정
        //대각선 -> y를 0으로, x를 0으로
        //다른 대각선 -> y를 0으로, x를 4로

        int row = 0, col = 0, diagonal_r = 0, diagonal_l = 0;

        for (int i = 0; i < 5; i++) {
            if (bingo[i][y] == 0) ++row;
            if (bingo[x][i] == 0) ++col;
            if (x == y && bingo[i][i] == 0) ++diagonal_l;
            if (x == 4 - y && bingo[i][4 - i] == 0) ++diagonal_r;
        }

        if(row==5) ++bingoCnt;
        if(col==5) ++bingoCnt;
        if(diagonal_r==5) ++bingoCnt;
        if(diagonal_l==5) ++bingoCnt;

    }


}
