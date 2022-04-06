import java.io.*;
import java.util.*;

public class BOJ_3109_빵집 {
    static int R, C;
    static char[][] map;
    static int result;
    static int[] dr = {-1, 0, 1}; // 왜 0, -1, 1은 안되지???????????????? --> 가지치기 & 위에서부터 내려오니까

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int r = 0; r < R; r++) {
            String line = in.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
            }
        }

        for(int r=0;r<R;r++){
            setPipeline(r, 0);
        }

        System.out.println(result);
    }

    private static boolean setPipeline(int rowNo, int colNo) {
        if (colNo == C - 1) {
            ++result;
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nr = rowNo + dr[i];
            if (nr >= 0 && nr < R && map[nr][colNo + 1] == '.') {
                map[nr][colNo+1] = '-';
                if(setPipeline(nr, colNo + 1)) return true;
            }
        }

        return false;

    }

}
