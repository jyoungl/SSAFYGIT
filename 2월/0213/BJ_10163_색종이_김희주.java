import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] paper = new int[1001][1001];

        int N = Integer.parseInt(in.readLine());


        for(int n=1;n<=N;n++){
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = 1000-Integer.parseInt(st.nextToken());

            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            for(int i=x;i<x+width;i++){
                for(int j=y;j>y-height;j--){
                    paper[j][i] = n;
                }
            }
        }

        int[] area = new int[N+1];

        for(int i=0;i<1001;i++){
            for(int j=0;j<1001;j++){
                area[paper[i][j]]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            sb.append(area[i]).append("\n");
        }

        System.out.print(sb);
    }
}
