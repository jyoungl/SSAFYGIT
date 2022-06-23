package 문제풀이;

import java.io.*;
import java.util.*;

public class S5_11004_K번째수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
//		int[] A = new int[N];
//		List<Integer> A = new LinkedList<>();
		List<Integer> A = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(A);
		
		System.out.println(A.get(K-1));

	}

}
