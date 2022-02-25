import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	static int N, K, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(st.nextToken());

		bfs(new boolean[100001]);
		System.out.println(cnt);

	}

	static void bfs(boolean[] visited) {

		Queue<Node2> queue = new LinkedList<>();

		queue.offer(new Node2(N, 0));
		visited[N] = true;
		while (!queue.isEmpty()) {

			Node2 node = queue.poll();

			if (node.x == K) {
				cnt = node.depth;
				return;
			}


			int[] next = { node.x -1, node.x + 1, node.x*2 };

			for (int i = 0; i < 3; i++) {
				// 범위 체크 확실히 하자
				if (next[i] <= 100000 && next[i] >= 0 && !visited[next[i]]) {
					visited[next[i]] = true;
					queue.offer(new Node2(next[i], node.depth + 1));
				}
			}
		}
	}
}

class Node2 {

	int x;
	int depth;

	public Node2(int x, int depth) {
		super();
		this.x = x;
		this.depth = depth;
	}
}


// 경우의수 따지기 실패
//while(N != K) {
//	// N이 K보다 크면 N--
//	if(N > K) {
//		N--;
//	}
//	// N*2배가 K보다 작으면 무조건 2배
//	else if(N*2 < K ) {
//		N = N *2;
//	//	N*2가  K까지의 거리보다 크면서 N*2보다 N+1에서 K까지의 거리가 더 멀 때
//	}else if(N*2 > K) {
//		int M = N*2-K;
//		int temp = N;
//		int incnt = 0;
//		while(true) {
//			if(temp*2 - K > 2) {
//				temp--;
//				incnt++;
//			}else {
//				if(incnt < M) {
//					cnt = cnt + incnt;
//					N = temp;
//				}else {
//					N = N*2;
//				}
//				break;
//			}
//		}
//		N = N * 2;
// N*2가 K까지 거리보다 크지만 N+1에서 K까지의 거리가 더 가까울때

//	System.out.println(N);
