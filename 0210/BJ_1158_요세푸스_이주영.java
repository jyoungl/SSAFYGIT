import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BQJ_1158_요세푸스 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Queue<Integer> que = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++)
			que.add(i+1);

		int cnt = 0;
		sb.append("<");
		while(que.size() > 1) {
			
			if(cnt < M-1) {
				que.add(que.poll());
				cnt++;
			}
			else {
				sb.append(que.poll()+", ");
				cnt = 0;
			}
		}
		sb.append(que.poll()+">");
		System.out.println(sb);
	}

}
