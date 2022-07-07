import java.io.*;
import java.util.*;

public class BOJ_1743_음식물피하기 {
	static int N,M;
	static boolean[][] map;
	static int[][] deltas = {{1,0},{-1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];
		for(int k=0;k<K;k++){
			st = new StringTokenizer(in.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
		}

		int max = 0;
		for(int r=0;r<N;r++){
			for(int c=0;c<M;c++){
				if(map[r][c]) max = Math.max(max,dfs(r,c));
			}
		}
		System.out.println(max);
	}
	private static int dfs(int r, int c){
		int count = 1;
		map[r][c] = false;
		for(int d=0;d<4;d++){
			int nr = r+deltas[d][0];
			int nc = c+deltas[d][1];
			if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]) count += dfs(nr,nc);
		}
		return count;
	}
}
