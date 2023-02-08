package feb08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1138_한줄로서기_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		//첫번째 먼저 집어넣음
		int x = Integer.parseInt(st.nextToken());
		arr[x] = 1;
		
		for(int i=1;i<N;i++) {
			int y = Integer.parseInt(st.nextToken());
			int cnt = 0;
			for(int j=0;j<N;j++) {
				if(cnt == y) {
					while(true) {
						if(arr[j] == 0) {
							arr[j] = i+1;
							break;
						}
						else
							j++;
					}
					break;
				}
				
				if(arr[j] == 0)
					cnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++)
			sb.append(arr[i]+" ");
		System.out.println(sb);
	}

}
