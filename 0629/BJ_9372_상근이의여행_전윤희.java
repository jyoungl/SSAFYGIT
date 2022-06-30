package 기타;

import java.io.*;
import java.util.*;

public class BJ_9372_상근이의여행_간선의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 여행 국가 수
			int P = Integer.parseInt(st.nextToken()); // 비행기 종류
			for (int i = 0; i < P; i++) {
				br.readLine();
			}
			// 주어지는 비행 스케줄은 항상 연결 그래프를 이룸
			// 따라서 간선의 개수만 출력
			System.out.println(N-1);
		}

	}

}
