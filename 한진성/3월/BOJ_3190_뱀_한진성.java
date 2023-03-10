import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_3190_뱀_한진성 {
	static int[][] dir, arr;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		arr = new int[N][N];

		int K = Integer.parseInt(in.readLine());

		StringTokenizer st;

		for (int i = 0; i < K; i++) {

			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			arr[x][y] = 1;

		}

		int L = Integer.parseInt(in.readLine());

		Map<Integer, Integer> move = new HashMap<Integer, Integer>();

		for (int i = 0; i < L; i++) {

			st = new StringTokenizer(in.readLine());
			int key = Integer.parseInt(st.nextToken());
			move.put(key, (int) st.nextToken().charAt(0));

		}
		int time = 0;

		Deque<Node> deq = new LinkedList<Node>();
		dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int d = 0;
		deq.add(new Node(0, 0));
		arr[0][0] = 2;
		// 게임 시작
		while (true) {

			time++;
			// 지렁이 이동
			Node tailTemp = deq.peekLast();
			Node head = deq.peekFirst();
			Node headTemp = new Node(head.x, head.y);
			deq.addFirst(headTemp.move(d));
			// 충돌 여부 (GameOver여부)
			if (arr[headTemp.x][headTemp.y] == 9999) {
				break;
			}else {
				deq.pollFirst();
			}
			if (deq.size() > 1) {
				for (int i = 0; i < deq.size()-1; i++) {
					Node temp = deq.pollLast();
					Node temp2 = deq.peekLast();
					deq.addFirst(temp.reload(temp2));
				}
			}
			head = deq.pollLast();
			deq.addFirst(head.move(d));

//			System.out.println("x : " + head.x + " y : " + head.y + " arr : " + arr[head.x][head.y]);
			if (arr[head.x][head.y] == 9999) {
				break;
			}
			// 먹이 여부
			if (arr[head.x][head.y] == 1) {
				arr[head.x][head.y] = 2;
				deq.addLast(new Node(tailTemp.x, tailTemp.y));
			}
			for(int i=0;i<deq.size();i++) {
				Node prin = deq.pollLast();
				deq.addFirst(prin);
				arr[prin.x][prin.y] = 2;
//				System.out.println(prin.x+":"+prin.y);
				
			}
//			for(int i=0;i<N;i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			// 방향전환 여부
			if (move.get(time) != null) {
				if (move.get(time) == 'D') {
					d++;
					if (d == 4) {
						d = 0;
					}
				} else if (move.get(time) == 'L') {
					d--;
					if (d == -1) {
						d = 3;
					}
				}
			}


		}
		System.out.println(time);
	}

	static class Node {

		int x;
		int y;

		public Node() {
		}

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Node move(int d) {
			arr[x][y] = 0;
			int dx = this.x + dir[d][0];
			int dy = this.y + dir[d][1];

			if (dx < 0 || dx >= N || dy < 0 || dy >= N || arr[dx][dy] == 2) {
				arr[x][y] = 9999;
				return this;
			}
			this.x = dx;
			this.y = dy;
			return this;
		}

		public Node reload(Node node) {
			arr[x][y] = 0;
			this.x = node.x;
			this.y = node.y;
			return this;
		}

	}
}