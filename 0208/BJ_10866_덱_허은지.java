package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/*
 * .addFirst(1) : 1을 덱의 앞에 추가 push_front X
 * .addLast(1) : 1을 덱의 뒤에 push_back X
 * .removeFirst() : 반환하고 제거 pop_front(없으면 -1)
 * .removeLast() : 제거 pop_back (없으면 -1)
 * .size(): 크기 size
 * .isEmpty() : 비어 있는지 확인 empty(비어 있으면 1, 아니면 0)
 * .peekFirst() : 첫번째 값 참조 front (없으면 -1)
 * .peekLast() : 마지막 값 참조 back(없으면 -1)
 */
public class lv19_10866_덱 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
			
		for(int i = 0; i < N; i++) {
			String key = br.readLine();
			
			if (key.contains("push_front")) {
				String[] k = key.split(" ");
				int num = Integer.parseInt(k[1]);
				deque.addFirst(num);
			}
			
			if (key.contains("push_back")) {
				String[] k = key.split(" ");
				int num = Integer.parseInt(k[1]);
				deque.addLast(num);
			}
			
			switch(key) {
			case "pop_front":
				if(deque.isEmpty()) sb.append("-1\n");
				else sb.append(deque.removeFirst() + "\n");
				break;
			case "pop_back":
				if(deque.isEmpty()) sb.append("-1\n");
				else sb.append(deque.removeLast() + "\n");
				break;
			case "size":
				sb.append(deque.size() + "\n");
				break;
			case "empty":
				if(deque.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "front":
				if(deque.isEmpty()) sb.append("-1\n");
				else sb.append(deque.getFirst() + "\n");
				break;
			case "back":
				if(deque.isEmpty()) sb.append("-1\n");
				else sb.append(deque.getLast() + "\n");
				break;
			}	
		}
		
		System.out.println(sb);
		
	}
}
