package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3060_욕심쟁이돼지_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		int[] res = new int[6];
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			
			String[] str = br.readLine().split(" ");
			//첫 날 먹은 사료
			for(int i=0;i<6;i++) {
				arr[i] = Integer.parseInt(str[i]);
				res[i] = arr[i];
				cnt += arr[i];
			}
			int day = 1;
			
			if(cnt > N) {
				sb.append(day+"\n");
				continue;
			}
			
			while(cnt <= N) {
				day++;
//				int x = res[1] + res[5] + res[3];
//				int y = res[0] + res[2] + res[4];
//				res[0] += x;
//				res[1] += y;
//				res[2] += x;
//				res[3] += y;
//				res[4] += x;
//				res[5] += y;
				cnt *= 4;
	
			}
			
		sb.append(day+"\n");	
		}
		System.out.println(sb);
		

	}

}
