package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 후보의 수 N
 * 2. 뽑으려는 사람의 수
 * 출력
 * 다솜이가 매수해야 하는 사람의 최솟값
 * 
 * >> 다솜이는 기호 1번
 * >> 다른 모든 사람의 득표수보다 많은 득표수 ==> 다른 후보보다 1명씩만 많아도 당선
 * >> 정렬, while if 쓰기
 */
public class s5_1417_국회의원선거 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int dasom = Integer.parseInt(br.readLine());
		int[] person = new int[N-1]; //나머지 후보
		int count = 0;
		
		if(N==1) {
			System.out.println(0);
			System.exit(0);
		}
		
		for(int i = 0; i<N-1; i++) {
			person[i] = Integer.parseInt(br.readLine());
		}
		
		while(true) {
			Arrays.sort(person); //오름차순 정렬
			if(dasom>person[N-2]) break; //다솜이 제일 큰 사람보다 높으면 break
			dasom++; //아니면 제일 큰 값을 다솜에게 줌
			person[N-2]--;
			count++;
		}
		
		System.out.println(count);

	}

}
