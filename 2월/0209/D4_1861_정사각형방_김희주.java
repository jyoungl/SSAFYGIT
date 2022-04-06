import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1861_정사각형방 {
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//상,하,좌,우 (행-열 순서)
    static int[][] rooms;
    static int N;

    static int maxRoom;
    static int maxMove;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            N = Integer.parseInt(in.readLine());
            rooms = new int[N][N];
            maxRoom = 0;
            maxMove = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    rooms[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    moveRoom(i, j, 1);
                }
            }
            sb.append(maxRoom).append(" ").append(maxMove).append("\n");
        }
        System.out.print(sb);
    }

    private static int moveRoom(int i, int j, int cnt) {
        for (int d = 0; d < 4; d++) {
            int ni = i + deltas[d][0];
            int nj = j + deltas[d][1];

            if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
            else if (rooms[i][j] + 1 != rooms[ni][nj]) continue;

            cnt = moveRoom(ni, nj, cnt + 1);

            if (maxMove < cnt) {
                maxMove = cnt;
                maxRoom = rooms[i][j];
            } else if (maxMove == cnt && maxRoom > rooms[i][j]) {
                maxRoom = rooms[i][j];
            }

            break;  //방에 있는 번호는 서로 다름
        }

        return cnt;

    }
}