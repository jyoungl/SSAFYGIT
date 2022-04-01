package mar30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11052_카드구매하기_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] res = new int[N+1];
		res[1] = card[1];
		
		for(int i=2;i<=N;i++) {
			for(int j=1;j<=i;j++) {
				res[i] = Math.max(card[j] + res[i-j], res[i]);
			}
		}
		
		System.out.println(res[N]);
	}

}
