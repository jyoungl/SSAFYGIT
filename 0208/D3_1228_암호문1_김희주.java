import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class D3_1228_암호문1 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=10;tc++) {
			sb.append("#").append(tc).append(" ");
			
			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			Deque<Integer> result = new ArrayDeque<>();
			Deque<Integer> tmp = null;
			
			for(int i=0;i<N;i++) {
				result.offer(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(in.readLine());//명령어 개수
			st = new StringTokenizer(in.readLine(),"I| ");
			for(int i=0;i<M;i++) {
				tmp = new ArrayDeque<>();
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				for(int j=0;j<x;j++) {
					tmp.offer(result.poll());
				}
				
				for(int j=0;j<y;j++) {
					tmp.offer(Integer.parseInt(st.nextToken()));
				}

				tmp.addAll(result);
				result = tmp;
				
			}
			
			for(int i=0;i<10;i++) {
				sb.append(result.poll()).append(" ");
			}
			sb.append("\n");
			
		}
		
		System.out.println(sb);
	}
}
