import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157_자리배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(in.readLine());

        if(K>C*R){
            System.out.println(0);
            return;
        }

        //시작인덱스 (R-1,0)
        int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}}; //위, 오른쪽, 아래, 왼쪽

        int[][] hall = new int[R][C];

        int x = 0, y = R-1;
        int d=0;
        for(int num=1;num<=C*R;num++){
            hall[y][x] = num;

            if(num==K){
                System.out.println((x+1)+" "+(R-y));
                return;
            }

            int nx = x+deltas[d][1];
            int ny = y+deltas[d][0];

            if(nx<0 || nx>=C || ny<0 || ny>=R || hall[ny][nx]!=0) {
                d = (d+1)%4;
                --num;
                continue;
            }

            x = nx;
            y = ny;
        }
    }
}
