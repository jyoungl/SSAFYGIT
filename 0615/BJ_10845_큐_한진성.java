import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Deque;
import java.util.LinkedList;


public class BOJ_10845_큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deq = new LinkedList<Integer>();
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String[] str = in.readLine().split(" ");
			switch(str[0]) {
			case "push":
				deq.offer(Integer.parseInt(str[1]));
				break;
			case "pop":
				Integer k = deq.poll();
				if(k == null) {
					sb.append(-1).append('\n');
				}else {
					sb.append(k).append('\n');
				}
				break;
			case "size":
				// 큐의 사이즈 출력
				sb.append(deq.size()).append('\n');
				break;
			case "empty":
				if(deq.isEmpty()) {
					sb.append(1).append('\n');
				}else{
					sb.append(0).append('\n');
				}
				break;
			case "front":
				Integer k1 = deq.peek();
				if(k1 == null) {
					sb.append(-1).append('\n');
				}else{
					sb.append(k1).append('\n');
				}
				break;
			case "back":
				Integer k11 = deq.peekLast();
				if(k11 == null) {
					sb.append(-1).append('\n');
				}else{
					sb.append(k11).append('\n');
				}
				break;
			}
		}
		System.out.print(sb);
	}
	
}
