import java.io.*;
import java.util.*;

public class BOJ_2206_벽부수고이동하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] origin = new char[N][M];
		int[][][] depth = new int[N][M][2];

		for (int n = 0; n < N; n++) origin[n] = in.readLine().toCharArray();

		int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
		Queue<int[]> queue = new LinkedList<>();
		int[] first = {0,0,0};
		queue.offer(first);

		depth[0][0][0] = 1;

		while(!queue.isEmpty()){
			first = queue.poll();
			int n = first[0];
			int m = first[1];
			int cnt = first[2];

			for(int d=0;d<4;d++){
				int nn = n+deltas[d][0];
				int nm = m+deltas[d][1];
				if(nn<0 || nn>=N || nm<0 || nm>=M) continue;
				if(origin[nn][nm]=='1' && cnt>0) continue;

				int cntN = origin[nn][nm]=='1'? cnt+1:cnt;
				if(depth[nn][nm][cntN] > 0) continue;

				depth[nn][nm][cntN] = depth[n][m][cnt]+1;
				queue.offer(new int[]{nn,nm,cntN});
			}

		}

		if(depth[N-1][M-1][1]!=0) System.out.println(depth[N-1][M-1][1]);
		else if(depth[N-1][M-1][0]!=0) System.out.println(depth[N-1][M-1][0]);
		else System.out.println(-1);
//		System.out.println(depth[N-1][M-1][1]!=0? depth[N-1][M-1][1]:depth[N-1][M-1][0]!=0?depth[N-1][M-1][0]:-1);
	}
}
