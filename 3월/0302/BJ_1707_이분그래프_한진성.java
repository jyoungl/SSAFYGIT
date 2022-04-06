import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

	int num;
	Node link;

	public Node(int num, Node link) {
		super();
		this.num = num;
		this.link = link;
	}

	@Override
	public String toString() {
		return "Node [num=" + num + ", link=" + link + "]";
	}

}

public class BOJ_1707_이분그래프1 {

	// BFS로 풀어보기
	static int V, E;
	static Node[] nodes;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			V = Integer.parseInt(st.nextToken());

			nodes = new Node[V + 1];

			E = Integer.parseInt(st.nextToken());

			for (int i = 0; i < E; i++) {

				st = new StringTokenizer(in.readLine(), " ");
				int n = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				nodes[n] = new Node(to, nodes[n]);
				nodes[to] = new Node(n,nodes[to]);
			}

			System.out.println(bfs(new int[V + 1]));

		}

	}

	static String bfs(int[] visited) {

		Queue<Integer> queue = new LinkedList<>();
		// 1, 2 = 2분 구분하는 수
		for (int i = 1; i <= V; i++) {
			if (visited[i] == 0) {
				visited[i] = 1;
				queue.add(i);
			}

			while (!queue.isEmpty()) {

				int current = queue.poll();

				for (Node temp = nodes[current]; temp != null; temp = temp.link) {
					if (visited[temp.num] == visited[current]) {
						return "NO";
					}
					if (visited[temp.num] == 0) {
						if (visited[current] == 1) {
							visited[temp.num] = 2;
						} else {
							visited[temp.num] = 1;
						}
						queue.offer(temp.num);
					}
				}
			}
		}
		return "YES";
	}

}
