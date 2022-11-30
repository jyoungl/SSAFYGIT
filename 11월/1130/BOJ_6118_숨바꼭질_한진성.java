import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int vertex;
	Node pre;
	Node link;
	int depth = 0;

	public Node(int vertex, Node link) {
		super();
		this.vertex = vertex;
		this.link = link;
	}
	@Override
	public String toString() {
		return "Node [vertex=" + vertex + ", link=" + link + "]";
	}
}

public class BOJ_6118_숨바꼭질 {

	static int N, M;
	static Node arr[];
	static int ans1, ans2, ans3;
	static boolean[] isVisited;
	static int dist[];

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new Node[N + 1];
		dist = new int[N + 1];
		// 인접행렬 만들기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			arr[A] = new Node(B, arr[A]);
			arr[B] = new Node(A, arr[B]);

		}
		isVisited = new boolean[N + 1];
		Arrays.fill(dist, 99999999);
		bfs(1);
		dist[1] = 0;
		for (int i = 1; i <= N; i++) {
			if (ans2 < dist[i]) {
				ans2 = dist[i];
				ans1 = i;
				ans3 = 1;
			} else if (ans2 == dist[i]) {
				ans3++;
			}
		}
		System.out.println(ans1 + " " + ans2 + " " + ans3);
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(start);
		isVisited[start] = true;
		arr[start].pre = arr[start];
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (Node temp = arr[current]; temp != null; temp = temp.link) {
				if (!isVisited[temp.vertex]) {
					arr[temp.vertex].depth = arr[current].depth + 1;
					queue.offer(temp.vertex);
					isVisited[temp.vertex] = true;
					dist[temp.vertex] = arr[temp.vertex].depth;
				}
			}
		}
	}

}
