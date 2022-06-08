package jun_vac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1057_토너먼트_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int round = 1;
		
		int kr = k/2 + k%2;
		int mr = m/2 + m%2;
		
		while(kr != mr) {
			kr = kr%2 + kr/2;
			mr = mr%2 + mr/2;
			round++;
		}
		
		System.out.println(round);
		
	}

}
