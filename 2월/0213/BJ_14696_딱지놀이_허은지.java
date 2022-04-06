package im형필수문제;

import java.io.*;
import java.util.*;

/*
 * 1. 총 라운드 수 N
 * 2. 어린이 A가 내는 딱지에 나온 그림의 총 개수 a 어린이가 낸 그림(1 세모 2 네모 3 동그라미 4 별)
 * 3. >> 만약 두 딱지의 별의 개수가 다르다면, 별이 많은 쪽의 딱지가 이긴다.
		별의 개수가 같고 동그라미의 개수가 다르다면, 동그라미가 많은 쪽의 딱지가 이긴다.
		별, 동그라미의 개수가 각각 같고 네모의 개수가 다르다면, 네모가 많은 쪽의 딱지가 이긴다.
		별, 동그라미, 네모의 개수가 각각 같고 세모의 개수가 다르다면, 세모가 많은 쪽의 딱지가 이긴다.
		별, 동그라미, 네모, 세모의 개수가 각각 모두 같다면 무승부이다.
 * 출력: 이긴 어린이 이름(A, B), 비기면(D)
 * 
 * >> if, else if문 쓰기 >> for(if) 쓰기
 * >> 배열에 1234 넣어서 비교하기
 */
public class b1_14696_딱지놀이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		outer: for(int n = 0; n<N; n++) {
			int[] a = new int[4];
			int[] b = new int[4];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int aCard = Integer.parseInt(st.nextToken());
			for(int i = 0; i < aCard; i++) {
				int card = Integer.parseInt(st.nextToken());
				a[card-1]++; //해당되는 그림의 카드가 몇 개 들어있는지 입력
			}
			
			st = new StringTokenizer(br.readLine());
			int bCard = Integer.parseInt(st.nextToken());
			for(int i = 0; i < bCard; i++) {
				int card = Integer.parseInt(st.nextToken());
				b[card-1]++;
			}
			
			for(int i = 3; i>=0; i--) {
				if(a[i] != b[i]) { 			//i번째 그림이 같지 않고
					if(a[i] > b[i]) {		//A가 더 많으면 A 출력
						sb.append("A\n");
						continue outer;
					} else {				//B가 더 많으면 B 출력
						sb.append("B\n");
						continue outer;
					}
				}
			}
			sb.append("D\n");
		}
		System.out.println(sb);
	}
}
