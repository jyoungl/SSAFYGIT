import java.io.*;
import java.util.*;

public class BOJ_13565_침투 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		Queue<int[]> queue= new ArrayDeque<>();
		char[][] map = new char[M][N];
		for(int i=0;i<M;i++){
			map[i] = in.readLine().toCharArray();
		}
		for(int j=0;j<N;j++){
			if(map[0][j]=='0') {
				queue.offer(new int[]{0,j});
				map[0][j] = '1';
			}
		}

		int[] pos;
		int[][] deltas = {{1,0},{-1,0},{0,-1},{0,1}};
		while(!queue.isEmpty()){
			pos = queue.poll();
			if(pos[0] == M-1){
				System.out.println("YES");
				return;
			}

			for(int d=0;d<4;d++){
				int ni = pos[0]+deltas[d][0];
				int nj = pos[1]+deltas[d][1];
				if(ni>=0 && ni<M && nj>=0 && nj<N && map[ni][nj]=='0'){
					map[ni][nj]='1';
					queue.offer(new int[]{ni,nj});
				}
			}
		}

		System.out.println("NO");
	}
}
