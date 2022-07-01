package jun27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1790_수이어쓰기2_이주영 {
	public static long calc(int N) {// 1~N까지의 길이
		long cnt = 0;
		int d = 1; //1~9 1개, 10~99 2개, 100~999 3개.. 나타냄
		
		for(int start=1;start<=N;start*=10) {
			int end = start * 10 -1;
			if(N<end)
				end = N;
			cnt += (end - start +1)*d; 
			d++;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if(calc(N)<K) {
			System.out.println(-1);
			return;
		}
		
		int l = 1;
		int r = N;
		int res = 0;
		
		while(l<=r) {
			int mid = (l+r)/2;
			long len = calc(mid);
			
			if(K>len)
				l = mid + 1;
			else {
				res = mid;
				r = mid - 1;
			}
		}
		
		//System.out.println(res);
		String s = String.valueOf(res);
		long tmp = calc(res);
		int leng = (int) (s.length() - (tmp-K) -1);
		System.out.println(s.charAt(leng));
	}

}
