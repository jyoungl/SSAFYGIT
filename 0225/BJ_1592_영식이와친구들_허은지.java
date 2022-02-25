package im형필수문제;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 사람 수 N 한 명당 공 던지는 횟수 M 몇 번째에 던질지 L
 * 출력
 * 1. 총 공을 몇 번 던지는지
 * 조건
 * 1. 현재 공을 받은 횟수가 홀수면 시계 방향, 짝수면 반시계 방향
 *
 * >> 배열에 현재 받은 수 추가하기
 */
public class b2_1592_영식이와친구들 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] chair = new int[N+1];
		int total = 0;
		
		//가지고 있는 사람 번호
		int num = 1;
		
		//1번 사람이 먼저 받고 시작함
		chair[1] = 1;
		
		while(true) {
			for(int i = 1; i<=N; i++) {
				//받은 횟수가 M이면 종료
				if(chair[i]==M) {
					System.out.println(total);
					System.exit(0);
				}
			}	
			//가지고 있는 사람의 번호가 홀수일 때
			if(chair[num]%2==1) {
				//오른쪽으로 돌리기
				num = num+L;
				//배열을 벗어나면 -N
				if(num>N) num -= N;
			}
			//가지고 있는 사람의 번호가 짝수일 때
			else {
				//왼쪽으로 돌리기
				num = num-L;
				//배열을 벗어나면 +N
				if(num<=0) num += N;
			}
			
			//받은 횟수 추가
			chair[num]++;
			//총 횟수 추가
			total++;
		}
		
	}

}
