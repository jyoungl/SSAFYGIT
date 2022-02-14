package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2559_수열_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //전체 온도 측정 날짜
		int K = Integer.parseInt(st.nextToken()); //연속날짜 수
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N]; // 날짜 온도를 저장할 배열
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int max = Integer.MIN_VALUE; //가장 큰 온도합 저장
		int cnt = 0; //계산 결과 저장
		//연속 K일 동안의 온도합 구함
		for(int i=0;i<N-K+1;i++) {
			for(int j=i;j<i+K;j++) {
				cnt += arr[j];
			}
			max = Math.max(max, cnt);
			cnt = 0;
		}
		
		System.out.println(max);
	}

}
