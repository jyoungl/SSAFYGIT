package 기타;

import java.util.*;
import java.io.*;

public class BJ_10845_큐 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Deque<Integer> dq = new ArrayDeque<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			switch (command) {
			case "push":
				dq.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(dq.isEmpty() ? -1 : dq.poll()).append("\n");
//				if (dq.isEmpty())
//					sb.append("-1").append("\n");
//				sb.append(dq.poll()).append("\n");
				break;
			case "size":
				sb.append(dq.size()).append("\n");
				break;
			case "empty":
				sb.append(dq.isEmpty() ? 1 : 0).append("\n");
//				if (dq.isEmpty()) {
//					sb.append("-1").append("\n");
//				} else {
//					sb.append("0").append("\n");
//				}
				break;
			case "front":
				sb.append(dq.isEmpty() ? -1 : dq.peek()).append("\n");
//				if (dq.isEmpty())
//					sb.append("-1").append("\n");
//				sb.append(dq.pollLast()).append("\n");
				break;
			case "back":
				sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
//				if (dq.isEmpty())
//					sb.append("-1").append("\n");
//				sb.append(dq.poll()).append("\n");
				break;
			}

		}
		System.out.println(sb);
	}

}
