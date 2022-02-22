import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	static int N,M;
	static int[][] farm;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};//우좌하상, yx순
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		while(--T>=0){
			StringTokenizer st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			farm = new int[N][M];

			for(int k=0;k<K;k++){
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				farm[y][x] = 1;
			}

			int cnt = 0;
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(farm[i][j]==1) {
						bfs(new int[]{i,j});
						++cnt;
					}
				}
			}

			sb.append(cnt).append("\n");

		}

		System.out.print(sb);
	}

	private static void bfs(int[] cabbage){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(cabbage);

		farm[cabbage[0]][cabbage[1]] = 0;

		while(!queue.isEmpty()){
			cabbage = queue.poll();

			for(int d=0;d<4;d++){
				int ni = cabbage[0]+deltas[d][0];
				int nj = cabbage[1]+deltas[d][1];
				if(ni>=0 && ni<N && nj>=0 && nj<M && farm[ni][nj]==1){
					queue.offer(new int[]{ni,nj});
					farm[ni][nj] = 0;
				}
			}

		}
	}
}
