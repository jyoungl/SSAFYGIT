package 기타;

import java.io.*;
import java.util.*;

public class BJ_1789_수들의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		long S = Integer.parseInt(br.readLine()); // 200
		long S = Long.parseLong(br.readLine()); // 200

		// 서로 다른 N개를 구해 S가 되는 N의 최댓값을 구해야하므로 N이 최댓값이 되려면 가장 작은수들부터 최대한 많이 더해야함
		// 등차수열의 합 공식 : 첫째항 a, 항의 개수 n개일 때
		// a (a+d) (a+2d) . . . (a+(n-1)d)
		// 이 등차수열을 거꾸로 더하면
		// 2sum = (2a+(n-1)d)*n
		// sum = (2a+(n-1)d)*n/2
		// 첫째항은 1이고 공차는 1이고 합은 200이 되도록
		// sum = n(n+1)/2
		long temp = 0;
		int n = 0;
		while (true) {
			if (S < temp)
				break;
			temp = n * (n + 1) / 2;
			n++;
		}
		System.out.println(n - 2);

	}

}
