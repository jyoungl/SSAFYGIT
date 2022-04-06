package lv15_동적계획법1;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 정수 a, b, c
 * 2. 입력의 마지막은 -1, -1, -1
 * 출력
 * 1. w(a, b, c)
 * 조건
 * 1. 하나라도 0보다 작으면 리턴 1
 * 2. 하나라도 20보다 크면 리턴 w(20, 20, 20)
 * 3. a<b<c이면 리턴 w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
 * 4. 그 외는 w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) + w(a-1, b-1, c-1)
 * 
 * >> 이미 지나간 번호는 바로 리턴
 */
public class s2_9184_신나는함수실행 {
	static int[][][] num = new int[21][21][21];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==-1 && b==-1 && c==-1) break;
			
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a,b,c)).append("\n");
		}
		
		System.out.println(sb);

	}

	private static int w(int a, int b, int c) {
		//조건 1
		if(a<=0 || b<=0 || c<=0) return 1;
		
		//조건 2
		if(a>20 || b>20 || c>20) return num[20][20][20] = w(20, 20, 20);
		
		//이미 구한 값은 바로 리턴
		if(num[a][b][c] != 0) return num[a][b][c];
		
		//조건 3
		if(a<b && b<c) return num[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		
		//조건 4
		return num[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		
		
	}

}
