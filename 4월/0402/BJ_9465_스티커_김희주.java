import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465_스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(T-->0){
			int N  =Integer.parseInt(in.readLine());
			int[][] stickers = new int[2][N+1];
			for(int i=0;i<2;i++){
				st = new StringTokenizer(in.readLine());
				for(int j=1;j<=N;j++){
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int j=2;j<=N;j++){
				stickers[0][j] += Math.max(stickers[1][j-1],stickers[1][j-2]);
				stickers[1][j] += Math.max(stickers[0][j-1],stickers[0][j-2]);
			}

			sb.append(Math.max(stickers[0][N],stickers[1][N])).append("\n");
		}

		System.out.print(sb);
	}
}
