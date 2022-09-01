import java.io.*;
import java.util.*;

public class BOJ_1926_그림 {
	static int N,M;
	static int[][] map;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		int max = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(map[i][j]==1){
					count++;
					max = Math.max(max,dfs(i,j));
				}
			}
		}
		System.out.println(count+"\n"+max);
	}

	private static int dfs(int i, int j) {
		int sum = 1;
		map[i][j] = 0;
		for(int d=0;d<4;d++){
			int ni = i+deltas[d][0];
			int nj = j+deltas[d][1];
			if(ni>=0 && ni<N && nj>=0 && nj<M && map[ni][nj]==1) sum += dfs(ni,nj);
		}
		return sum;
	}
}
