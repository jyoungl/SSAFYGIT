import java.io.*;
import java.util.*;

public class BOJ_2583_영역구하기 {
	static int M,N,K;
	static boolean[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[M][N];

		int x1,y1,x2,y2;
		for(int i=0;i<K;i++){
			st = new StringTokenizer(in.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			for(int x=x1;x<x2;x++){
				for(int y=y1;y<y2;y++){
					map[y][x] = true;
				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for(int y=0;y<M;y++){
			for(int x=0;x<N;x++){
				if(!map[y][x]){
					list.add(dfs(y,x));
				}
			}
		}

		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append('\n');
		for(int li:list){
			sb.append(li).append(' ');
		}
		System.out.print(sb);
	}

	private static int dfs(int y, int x) {
		int cnt = 1;
		map[y][x] = true;
		for(int d=0;d<4;d++){
			int ny = y+deltas[d][0];
			int nx = x+deltas[d][1];
			if(ny>=0 && ny<M && nx >=0 && nx<N && !map[ny][nx]){
				cnt += dfs(ny,nx);
			}
		}
		return cnt;
	}
}
