package jun24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_9613_GCD합_이주영 {
	static ArrayList<Integer> list;
	static int[] arr;
	static int sum;
	public static void combi(int cnt, int start, int M) {
		if(cnt == M) {
			for(int i=arr[0];i>=1;i--) {
				if(arr[1]%i==0 && arr[0]%i==0) {
					sum += i;
					break;
				}
			}
			return;
		}
		
		for(int i=start;i<list.size();i++) {
			arr[cnt] = list.get(i);
			combi(cnt+1, i+1, M);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc=1;tc<=t;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			arr = new int[2];
			sum = 0;
			
			for(int i=0;i<n;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			if(list.size() == 1) {
				sb.append(1+"\n");
				continue;
			}
			else {
				Collections.sort(list);
				combi(0,0,2);
				sb.append(sum+"\n");
			}
		}
		System.out.println(sb);
	}

}
