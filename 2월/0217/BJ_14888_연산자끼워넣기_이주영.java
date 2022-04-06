package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888_연산자끼워넣기_이주영 {
	static int N;
	static int[] arr;
	static int[] op;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	public static void calc(int cnt, int val) {
		if(cnt == N) {
			max = Math.max(max, val);
			min = Math.min(min, val);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(op[i] > 0) {
				op[i]--;
				
				switch(i) {
				case 0: //더하기
					calc(cnt+1, val+arr[cnt]);
					break;
				case 1: //빼기
					calc(cnt+1, val-arr[cnt]);
					break;
				case 2:
					calc(cnt+1, val*arr[cnt]);
					break;
				case 3:
					calc(cnt+1, val/arr[cnt]);
					break;
				}
				op[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		op = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++)
			op[i] = Integer.parseInt(st.nextToken());
		
		calc(1, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}

}
