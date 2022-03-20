package mar19;

import java.util.Scanner;

public class BJ_2193_이친수_이주영 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		long[][] res = new long[N+1][2];
		res[1][1] = 1;
		
		if(N>=2)
			res[2][0] = 1;
		
		for(int i=3;i<=N;i++) {
			res[i][0] = res[i-1][0] + res[i-1][1];
			res[i][1] = res[i-1][0];
		}
		
		System.out.println(res[N][0] + res[N][1]);
		
//		Scanner in = new Scanner(System.in);
//		int N = in.nextInt();
//		
//		long[] res = new long[N+1];
//		
//		res[1] = 1;
//		
//		for(int i=2;i<=N;i++) {
//			res[i] = res[i-1] + res[i-2];
//		}
//		
//		System.out.println(res[N]);
	}

}
