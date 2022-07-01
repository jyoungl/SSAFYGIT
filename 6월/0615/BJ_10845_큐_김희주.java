import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10845_큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		Deque<Integer> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			switch(st.nextToken()){
				case "push":
					deque.offer(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if(deque.isEmpty()) sb.append("-1\n");
					else sb.append(deque.poll()).append("\n");
					break;
				case "size":
					sb.append(deque.size()).append("\n");
					break;
				case "empty":
					if(deque.isEmpty()) sb.append("1\n");
					else sb.append("0\n");
					break;
				case "front":
					if(deque.isEmpty()) sb.append("-1\n");
					else sb.append(deque.peek()).append("\n");
					break;
				case "back":
					if(deque.isEmpty()) sb.append("-1\n");
					else sb.append(deque.peekLast()).append("\n");
					break;
			}
		}

		System.out.print(sb);
	}
}
