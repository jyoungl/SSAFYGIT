import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {

	
	static char[][] arr;
	static boolean[][] isVisited;
	static int N,M;
	static int[][] dir = { {1,0},{-1,0},{0,1},{0,-1} };
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		isVisited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			arr[i] = in.readLine().toCharArray();
		}
		
		bfs(0,0);		
		
		
	}

	static void bfs(int x, int y) {
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[]{x,y,0});
		
		isVisited[x][y] = true;
		
		while(!queue.isEmpty()) {

			
			int[] pos = queue.poll();
			if(pos[0] == N-1 && pos[1] == M-1) {
				System.out.println(++pos[2]);
				break;
			}
			for(int d=0;d<4;d++) {
				int dx = pos[0] + dir[d][0];
				int dy = pos[1] + dir[d][1];
				if(dx >= 0 && dx < N && dy >= 0 && dy < M) {
					if(arr[dx][dy] == '1' && isVisited[dx][dy] == false) {
						isVisited[dx][dy] = true;
						queue.offer(new int[] {dx,dy,pos[2]+1});
					}
				}
			}
			
		}
		
		
		
	}
	
}
