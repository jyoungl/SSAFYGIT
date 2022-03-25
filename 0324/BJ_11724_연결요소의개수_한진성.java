import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

	int ver;
	Node link;

	public Node(int ver, Node link) {
		this.ver = ver;
		this.link = link;

	}

	@Override
	public String toString() {
		return "Node [ver=" + ver + ", link=" + link + "]";
	}
}

public class BOJ_11724_연결요소의개수 {

	static int N, M, cnt;
	static Node[] arr;
	static boolean[] totalvisit;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());
		totalvisit = new boolean[N + 1];
		arr = new Node[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			arr[from] = new Node(to, arr[from]);
			arr[to] = new Node(from, arr[to]);

		}

		for (int i = 1; i <= N; i++) {
			if (arr[i] == null) {
				cnt++;
			}
			if (dfs(i, totalvisit) != 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static int dfs(int vertex, boolean[] visited) {
		visited[vertex] = true;
		int count = 0;
		for (Node node = arr[vertex]; node != null; node = node.link) {
			if (!visited[node.ver]) {
				dfs(node.ver, visited);
				count++;
			}
		}

		return count;

	}

}
