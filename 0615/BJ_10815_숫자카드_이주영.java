package jun15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_10815_숫자카드_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> hs = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(st.nextToken());
			hs.add(x);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<M;i++) {
			int x = Integer.parseInt(st.nextToken());
			if(hs.contains(x))
				sb.append("1 ");
			else
				sb.append("0 ");
		}
		System.out.println(sb);		
	}
	
}
