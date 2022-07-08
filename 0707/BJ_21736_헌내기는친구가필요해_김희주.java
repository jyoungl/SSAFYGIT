import java.io.*;
import java.util.*;

public class BOJ_21736_헌내기는친구가필요해 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][];
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0;i<N;i++) {
			map[i] = in.readLine().toCharArray();
			if(queue.isEmpty()){
				for(int j=0;j<M;j++) if(map[i][j]=='I') queue.offer(new int[]{i,j});
			}
		}

		int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};
		int[] pos;
		int ni,nj;
		int count = 0;
		while(!queue.isEmpty()){
			pos = queue.poll();
			for(int d=0;d<4;d++){
				ni = pos[0]+deltas[d][0];
				nj = pos[1]+deltas[d][1];
				if(ni<0 || ni>=N || nj<0 || nj>=M || map[ni][nj]=='X' || map[ni][nj]=='I') continue;
				else if(map[ni][nj]=='P') count++;
				map[ni][nj] = 'X';
				queue.offer(new int[]{ni,nj});
			}
		}
		if(count>0) System.out.println(count);
		else System.out.println("TT");
	}
}
