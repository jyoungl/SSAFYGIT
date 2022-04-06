import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> nums;

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(in.readLine()).append(" ");

			st = new StringTokenizer(in.readLine());
			nums = new LinkedList<>();

			for (int i = 0; i < 8; i++) {
				nums.offer(Integer.parseInt(st.nextToken()));
			}

			int minus = 1;
			while (nums.peek() - minus > 0) {
				nums.offer(nums.poll() - minus);
				minus = minus == 5 ? 1 : minus + 1;
			}

			nums.poll();
			nums.offer(0);

			// 출력
			for (int i = 0; i < 8; i++) {
				sb.append(nums.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
