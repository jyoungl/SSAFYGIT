package dec09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15486_퇴사2_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] t = new int[N+2];
		int[] p = new int[N+2];
		int[] dp = new int[N+2];
		int max = Integer.MIN_VALUE;
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N+1;i++) {
			max = Math.max(max, dp[i]);
			if(t[i]+i <= N+1) //i날 상담 시작 시 끝나는 날짜가 퇴직 전이면
				//상담 끝날 시 받는 최대 금액 = max(현재최대액+정산금 or 앞서 계산된 그 날짜에 받을 수 있는 최대금액(혹은 0))
				dp[t[i]+i] = Math.max(max+p[i], dp[t[i]+i]);
		}
		System.out.println(max);
	}

}
