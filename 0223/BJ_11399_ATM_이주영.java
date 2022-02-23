package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_12399_ATM_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int[] res = new int[N];
		res[0] = arr[0];
		
		for(int i=1;i<N;i++) {
			res[i] = res[i-1] + arr[i];
		}
		
		int cnt = 0;
		for(int i=0;i<N;i++)
			cnt += res[i];
		
		System.out.println(cnt);
	}

}
