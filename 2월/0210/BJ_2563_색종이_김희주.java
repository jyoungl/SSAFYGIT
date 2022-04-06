import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st;

        boolean[][] papers = new boolean[101][101];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());

            int left = Integer.parseInt(st.nextToken());
            int bottom = Integer.parseInt(st.nextToken());

            for(int x = left;x<left+10;x++){
                for(int y=bottom;y<bottom+10;y++){
                    if(!papers[y][x]){
                        papers[y][x] = true;
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);

    }
}