import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {

	
	static char[][] arr;
	static char[][] arr2;
	static boolean isVisited[][];
	static boolean isVisited2[][];
	static int cnt1, cnt2;
	
	static int ans, N;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		arr = new char[N][N];
		arr2 = new char[N][N];
		for(int i=0;i<N;i++) {
			arr[i] = in.readLine().toCharArray();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr2[i][j] = arr[i][j];
				if(arr2[i][j] == 'R') {
					arr2[i][j] = 'G';
				}
			}
		}
		
		isVisited = new boolean[N][N];
		isVisited2 = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!isVisited[i][j]) {
					bfs(new Node(i,j));
					cnt1++;

				}
				if(!isVisited2[i][j]) {
					bfs(new Node(i,j),true);
					cnt2++;

				}
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
	}
	
	static void bfs(Node node) {
		
		Queue<Node> queue = new LinkedList<>();
		
		isVisited[node.x][node.y] = true;
		
		queue.offer(new Node(node.x, node.y));
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			int x = temp.x;
			int y = temp.y;
			
			for(int d=0;d<4;d++) {
				int dx = x + dir[d][0];
				int dy = y + dir[d][1];
				if(dx >= 0 && dx < N && dy >= 0 && dy < N) {
					if(!isVisited[dx][dy] && arr[node.x][node.y] == arr[dx][dy]) {
							isVisited[dx][dy] = true;
							queue.offer(new Node(dx,dy));
					}
					
				}
			}
			
		}
	}
		
	static void bfs(Node node, boolean colorBlind) {
		
		Queue<Node> queue = new LinkedList<>();
		
		isVisited2[node.x][node.y] = true;
		
		queue.add(new Node(node.x, node.y));
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			int x = temp.x;
			int y = temp.y;
			
			for(int d=0;d<4;d++) {
				int dx = x + dir[d][0];
				int dy = y + dir[d][1];
				
				if(dx >= 0 && dx < N && dy >= 0 && dy < N) {
					if(colorBlind) { // 색맹일때
						if(!isVisited2[dx][dy] && arr2[node.x][node.y] == arr2[dx][dy]) {
							isVisited2[dx][dy] = true;
							queue.offer(new Node(dx,dy));
						}
					}
				}
			}
			
		}
		
		
	}

	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	
}
