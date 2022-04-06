import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		int[][] dir = { { -2, -1 }, { -1, -2 }, { -2, 1 }, { -1, 2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 } };

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(in.readLine());

			StringTokenizer st = new StringTokenizer(in.readLine()," ");

			Node knight = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

			st = new StringTokenizer(in.readLine(), " ");

			int endX = Integer.parseInt(st.nextToken());

			int endY = Integer.parseInt(st.nextToken());

			boolean[][] visited = new boolean[N][N];
			
			Queue<Node> queue = new LinkedList<>();

			queue.offer(knight);
			visited[knight.x][knight.y] = true;
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				
				if(node.x == endX && node.y == endY) {
					System.out.println(node.depth);
					break;
				}
				
				for(int d=0;d<8;d++) {
					int dx = node.x + dir[d][0];
					int dy = node.y + dir[d][1];
					
					if(dx >= 0 && dx < N && dy >= 0 && dy < N && !visited[dx][dy]) {
						visited[dx][dy] = true;
						queue.offer(new Node(dx,dy,node.depth+1));
					}
				}
			}
		}

	}

}

class Node {

	int x;
	int y;
	int depth;

	public Node(int x, int y, int depth) {
		super();
		this.x = x;
		this.y = y;
		this.depth = depth;
	}

}
