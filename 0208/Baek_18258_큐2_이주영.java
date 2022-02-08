package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_18258 {
	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int back = 0;
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			switch (s) {
			case "push": {
				int x = Integer.parseInt(st.nextToken());
				q.add(x);
				back = x;
				break;
			}
			case "pop": {
				if (q.isEmpty())
					sb.append(-1+"\n");
				else
					sb.append(q.poll()+"\n");
				break;
			}
			
			case "size": {
				sb.append(q.size()).append("\n");
				break;
			}
			
			case "empty": {
				if (q.isEmpty()) 
					sb.append(1+"\n");
				else 
					sb.append(0+"\n");
				break;
			}
			case "front": {
				if (q.isEmpty())
					sb.append(-1+"\n");
				else 
					sb.append(q.peek()+"\n");
				break;
			}
			case "back": {
				if (q.isEmpty())
					sb.append(-1+"\n");
				else 
					sb.append(back+"\n");
				break;
			}
			default:
				break;
			}
		}
		System.out.println(sb);
	}
}