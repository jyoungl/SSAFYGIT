import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18111_마인크래프트_이주영 {
    static int B, res, N, M;
    static long total;
    static int[][] map;
    //static int[][] copymap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken()); // 인벤토리 블록 수
        map = new int[N][M];
        //copymap = new int[N][M];
        total = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        total = (total+B)/(N*M);
        if(total > 256)
            total = 256;

        int minRes = Integer.MAX_VALUE;
        int height = 0;
        for(int i=0;i<=total;i++){
            res = 0;
            minecraft(i);
            if(minRes >= res){
                height = i;
                minRes = res;
            }
        }

        System.out.println(minRes + " " + height);
    }
    static void minecraft(int h){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] < h){ // 목표 높이보다 낮아 채워야함
                    //b -= (h - map[i][j]);
                    res += (h - map[i][j]);
                }
                else if(map[i][j] > h){ // 목표 높이보다 높음
                    res += (map[i][j] - h)*2;
                    //b += (map[i][j] - h);
                }
            }
        }
    }
}
