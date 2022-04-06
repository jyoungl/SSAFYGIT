import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	public static void main(String[] args) throws IOException {
		int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String line;
		while(!(line=in.readLine()).equals("0 0")){
			st = new StringTokenizer(line);

			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int[][] maps = new int[H][W];

			for(int i=0;i<H;i++){
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<W;j++){
					maps[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for(int i=0;i<H;i++){
				for(int j=0;j<W;j++){
					if(maps[i][j]!=1) continue;
					count++;

					//bfs
					int[] land = {i,j};
					Queue<int[]> queue = new ArrayDeque<>();
					queue.offer(land);
					maps[i][j] = 0;
					while(!queue.isEmpty()){
						land = queue.poll();
						for(int d=0;d<8;d++){
							int ni = land[0]+deltas[d][0];
							int nj = land[1]+deltas[d][1];
							if(ni<0 || ni>=H || nj<0 || nj>=W || maps[ni][nj]==0) continue;
							queue.offer(new int[]{ni,nj});
							maps[ni][nj] = 0;
						}
					}
				}
			}

			sb.append(count).append("\n");
		}

		System.out.print(sb);
	}
}
