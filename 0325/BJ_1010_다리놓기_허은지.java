package A형대비;

import java.io.*;
import java.util.*;

//조합의 개수
public class s5_1010_다리놓기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N==M) {
				sb.append(1).append("\n");
				continue;
			}
			
			int arr = 1;
			
			for(int i = 0; i<M-N; i++) {
				arr = arr * (M-i) / (i+1);
			}
			
			sb.append(arr).append("\n");
			
		}
		
		System.out.println(sb);

	}

}
