import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11559_PuyoPuyo {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static boolean check;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		char[][] arr = new char[12][6];
		for (int i = 0; i < 12; i++) {
			arr[i] = in.readLine().toCharArray();
		}
		int chain = 0;
		while (true) {
			check = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {

					if (arr[i][j] != '.') {
						bfs(arr[i][j], new Node(i, j), arr);
					}

				}
			}
			
			if(!check) {
				System.out.println(chain);
				return;
			}else {
				chain++;
				for(int i=11;i>=0;i--) {
					for(int j=0;j<6;j++) {
						if(arr[i][j] == '.') {
							for(int k=i;k>=0;k--) {
								if(arr[k][j] != '.') {
									arr[i][j] = arr[k][j];
									arr[k][j] = '.';
									break;
								}
							}
						}
					}
				}
			}
			
//			for(int i=0;i<12;i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
		}

	}

	static void bfs(char simbol, Node node, char[][] arr) {

		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[12][6];

		queue.offer(node);
		visited[node.x][node.y] = true;
		int cnt = 1;
		while (!queue.isEmpty()) {

			Node temp = queue.poll();

			for (int d = 0; d < 4; d++) {
				int dx = temp.x + dir[d][0];
				int dy = temp.y + dir[d][1];

				if (dx < 0 || dx >= 12 || dy < 0 || dy >= 6) {
					continue;
				}

				if (arr[dx][dy] == simbol && !visited[dx][dy]) {
					visited[dx][dy] = true;
					queue.offer(new Node(dx, dy));
					cnt++;
				}

			}

		}
		if (cnt >= 4) {
			check = true;
			for (int i = 0; i < 12; i++) {
				for(int j=0;j<6;j++) {
					if(visited[i][j]) {
						arr[i][j] = '.';
					}
				}
			}
		}

	}

}
