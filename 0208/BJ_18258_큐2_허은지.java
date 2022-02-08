package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/*
 * .add(1) : 1 추가(공간이 없으면 exception 반환)
 * .offer(1) : 1 추가
 * .poll() : 반환하고 제거
 * .remove() : 제거
 * .clear() : 초기화
 * .peek() : 첫번째 값 참조
 * .peekLast() : 마지막 값 참조 >> Deque
 */
public class lv19_18258_큐2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//Queue<Integer> queue = new LinkedList<>();
		Deque<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
			
		for(int i = 0; i < N; i++) {
			String key = br.readLine();
			
			if (key.contains("push")) {
				String[] k = key.split(" ");
				int num = Integer.parseInt(k[1]);
				queue.add(num);
			}
			
			switch(key) {
			case "pop":
				if(queue.isEmpty()) sb.append("-1\n");
				else sb.append(queue.poll() + "\n");
				break;
			case "size":
				sb.append(queue.size() + "\n");
				break;
			case "empty":
				if(queue.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "front":
				if(queue.isEmpty()) sb.append("-1\n");
				else sb.append(queue.peek() + "\n");
				break;
			case "back":
				if(queue.isEmpty()) sb.append("-1\n");
				else sb.append(queue.peekLast() + "\n");
				break;
//				for(int j = 0; j < queue.size()-1; j++) {
//					queue.add(queue.poll());
//				}
//				System.out.println(queue.peek());
//				queue.add(queue.poll());
			}	
		}
		System.out.println(sb);
	}
}
