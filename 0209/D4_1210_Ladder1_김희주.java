import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1210_Ladder1 {
    static int[][] deltas = {{0,-1},{0,1},{-1,0}};//좌,우,상

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(in.readLine()).append(" ");

            int[][] ladder = new int[100][100];
            int x = 0, y = 99; //x : 열, y: 행

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                    if (i == 99 && ladder[i][j] == 2) x = j;
                }
            }

            int nx,ny;
            while (y!=0) {
                for(int k=0;k<3;k++){
                    nx = x+deltas[k][1];
                    ny = y+deltas[k][0];
                    if(nx<0 || nx>=100 || ny<0 || ny>=100 || ladder[ny][nx]==0) continue;
                    x = nx;
                    y = ny;
                    ladder[ny][nx] = 0;
                }
            }

            sb.append(x).append("\n");
        }

        System.out.print(sb);
    }

}
