package bqj;

import java.util.Scanner;

public class BJ_1417_국회의원선거_이주영 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		int cnt = 0;
		
		for(int i=0;i<N;i++) {
			arr[i] = in.nextInt();
		}
		
		while(true) {
			int vote = 0;
			for(int i=0;i<N;i++) {
				if(arr[i] >= arr[vote])
					vote = i;
			}
			
			if(vote == 0)
				break;
			
			arr[0]++;
			arr[vote]--;
			cnt++;
		}
		
		System.out.println(cnt);

	}

}
