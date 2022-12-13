import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963_소수경로_한진성 {

	static class Num {
		String num;
		int depth;

		public Num(String num, int depth) {
			super();
			this.num = num;
			this.depth = depth;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		// 4자리 소수 모아두기
		boolean arr[] = new boolean[10000];

		for (int i = 2; i <= 9999; i++) {
			for (int j = i; j <= 9999; j += i) {
				if (j != i) {
					arr[j] = true;
				}
			}
		}
		go:for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			String A = st.nextToken();

			String B = st.nextToken();

			// BFS
			Queue<Num> queue = new LinkedList<>();

			queue.offer(new Num(A, 0));

			boolean[] visited = new boolean[10000];

			while (!queue.isEmpty()) {

				Num temp = queue.poll();
				if(temp.num.equals(B)) {
					System.out.println(temp.depth);
					continue go;
				}
				
				int a = temp.num.charAt(0) - '0';
				int b = temp.num.charAt(1) - '0';
				int c = temp.num.charAt(2) - '0';
				int d = temp.num.charAt(3) - '0';
				// 숫자 바꾸기 1번째
				for (int j = 1; j <= 9; j++) {
					String str = String.valueOf(j) + String.valueOf(b) + String.valueOf(c) + String.valueOf(d);
					if (!arr[Integer.parseInt(str)] && !visited[Integer.parseInt(str)]) {
						queue.offer(new Num(str, temp.depth + 1));
						visited[Integer.parseInt(str)] = true;
					}
				}
				// 숫자 바꾸기 2번째
				for (int j = 0; j <= 9; j++) {
					String str = String.valueOf(a) + String.valueOf(j) + String.valueOf(c) + String.valueOf(d);
					if (!arr[Integer.parseInt(str)] && !visited[Integer.parseInt(str)]) {
						queue.offer(new Num(str, temp.depth + 1));
						visited[Integer.parseInt(str)] = true;
					}
				}
				// 숫자 바꾸기 3번째
				for (int j = 0; j <= 9; j++) {
					String str = String.valueOf(a) + String.valueOf(b) + String.valueOf(j) + String.valueOf(d);
					if (!arr[Integer.parseInt(str)] && !visited[Integer.parseInt(str)]) {
						queue.offer(new Num(str, temp.depth + 1));
						visited[Integer.parseInt(str)] = true;
					}
				}
				// 숫자 바꾸기 4번째
				for (int j = 0; j <= 9; j++) {
					String str = String.valueOf(a) + String.valueOf(b) + String.valueOf(c) + String.valueOf(j);
					if (!arr[Integer.parseInt(str)] && !visited[Integer.parseInt(str)]) {
						queue.offer(new Num(str, temp.depth + 1));
						visited[Integer.parseInt(str)] = true;
					}
				}

			}
			
			System.out.println("Impossible");
			
		}
	}

}
