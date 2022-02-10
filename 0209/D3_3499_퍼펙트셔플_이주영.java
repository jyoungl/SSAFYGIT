package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<String> stack = new LinkedList<>();
		Queue<String> stack2 = new LinkedList<>();
		
		for(int tc=1;tc<=input;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			
			if(N%2 == 0) {
				for(int i=0;i<N;i++) {
					if(i <= N/2-1)
						stack.add(st.nextToken());
					else
						stack2.add(st.nextToken());
				}
			}
			
			if(N%2 == 1) {
				for(int i=0;i<N;i++) {
					if(i <= N/2)
						stack.add(st.nextToken());
					else
						stack2.add(st.nextToken());
				}
			}
			
			sb.append("#"+tc);
			for(int i=0;i<N;i++) {
				if(i%2 == 0) {
					sb.append(" "+stack.poll());
				}
				else {
					sb.append(" "+stack2.poll());
				}
			}
			sb.append("\n");
			stack.clear();
			stack2.clear();
		}
		System.out.println(sb);
	}

}


