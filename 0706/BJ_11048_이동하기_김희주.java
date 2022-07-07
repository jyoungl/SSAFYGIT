import java.io.*;
import java.util.*;

public class BOJ_11048_이동하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M+1];
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=1;j<=M;j++){
				//항상 대각선 경로보다 두 개를 거쳐서 오는 경로가 사탕이 더 많다.
				map[i][j] = Math.max(map[i-1][j],map[i][j-1])+Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(map[N][M]);
	}
}
