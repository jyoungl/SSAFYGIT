package jun15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_10845_큐_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<>();
		int end = -1;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			switch(s) {
			case "push":
				end = Integer.parseInt(st.nextToken());
				que.offer(end);
				break;
			case "pop":
				if(que.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(que.poll()).append("\n");
				break;
			case "size":
				sb.append(que.size()).append("\n");
				break;
			case "empty":
				if(que.isEmpty())
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
				break;
			case "front":
				if(que.isEmpty())
					sb.append("-1").append("\n");
				else {
					sb.append(que.peek()).append("\n");
				}
				break;
			case "back":
				if(que.isEmpty())
					sb.append("-1").append("\n");
				sb.append(end).append("\n");
				break;
			}
			
		}
		
		System.out.println(sb);
	}

}
