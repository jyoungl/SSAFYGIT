package 문제풀이;

import java.util.*;
import java.io.*;

public class S4_10845_큐 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

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
			}	
		}
        System.out.println(sb);
	}
}
