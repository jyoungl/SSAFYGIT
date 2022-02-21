package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2840_행운의바퀴_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //바퀴 칸 수
		int K = Integer.parseInt(st.nextToken()); //바퀴 돌리는 횟수
		String[][] arr = new String[K][2];
		
		String[] res = new String[N];
		int [] b = new int[26];
		
		for(int i=0;i<N;i++)
			res[i] = "?";
		
		int idx = 0;
		int cnt = 0;
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String y = st.nextToken();
			
			idx = (idx + x)%N;
			
			if(res[idx] != "?" && !res[idx].equals(y) || res[idx] == "?" && b[y.charAt(0)-65]==-1) {
				System.out.println("!");
				return;
			}
			
			res[idx] = y;
			int t = y.charAt(0)-65;
			b[t] = -1;
			cnt = idx;
		}
		
		StringBuilder sb = new StringBuilder();
		
		int k=0;
		while(k<=N) {
			if(cnt >= 0)
				sb.append(res[cnt--]);
			else {
				cnt = res.length-1;
			}
			k++;
		}
			System.out.println(sb);
	}

}
