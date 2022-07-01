package 문제풀이;

import java.io.*;
import java.util.*;

public class S4_1049_기타줄 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int pkg = Integer.MAX_VALUE;
		int piece = Integer.MAX_VALUE;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			pkg = Math.min(pkg, Integer.parseInt(st.nextToken()));
			piece = Math.min(piece, Integer.parseInt(st.nextToken()));
		}
		
		int price = N*piece;
		if(N%6 == 0) price = Math.min(price, N/6*pkg);
		else {
			price = Math.min(price, (N/6+1)*pkg);
			price = Math.min(price, (N/6*pkg)+(N%6*piece));
		}
		
		System.out.println(price);

	}

}
