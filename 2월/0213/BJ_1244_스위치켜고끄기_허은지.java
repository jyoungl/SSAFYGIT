package im형필수문제;

import java.io.*;
import java.util.*;

/*
 * 1. 스위치 개수 N
 * 2. 각 스위치의 상태(켜져 있으면 1, 꺼져 있으면 0)
 * 3. 학생 수 M
 * 4. 학생의 성별(남자 1 여자 2) 학생이 받은 스위치 수
 * 5. 남학생: 스위치 번호가 자기가 받은 수의 배수이면, 스위치의 상태를 바꾼다(3을 받았으면 3, 6을 바꾼다)
 * 6. 여학생: 스위치 번호를 중심으로 좌우가 대칭인 구간을 전부 바꾼다
 * 7. 출력: 스위치의 마지막 상태(20줄씩 끊기)
 */
public class s3_1244_스위치켜고끄기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] sw = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		outer: for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(s == 1) { //남학생일 경우
				for(int j = 0; j<N; j++) {
					if((j+1)%num == 0 && sw[j] == 0) sw[j] = 1;
					else if((j+1)%num == 0 && sw[j] == 1) sw[j] = 0;
				}
			} // 남학생 
			
			else if(s == 2) { //여학생일 경우
				num--;
				if(sw[num] == 0) sw[num]=1;
				else if(sw[num] == 1) sw[num]=0;
				
				if(num == 0 || num == N-1) continue outer;
				
				int tmp = 1;
				while(true) {
					if(num-tmp < 0 || num+tmp >= N) continue outer;
					
					if(sw[num+tmp] == sw[num-tmp]) {
						if(sw[num+tmp] == 0) {
							sw[num+tmp]=1;
							sw[num-tmp]=1;
						}
						else if(sw[num+tmp] == 1) {
							sw[num+tmp]=0;
							sw[num-tmp]=0;
						}
						tmp++;
					} else continue outer;
				}
			} //여학생

		} //스위치 바꾸기 for
		
		if(N>20) {
			for(int i = 0; i<N/20; i++) {
				for(int j = 0; j < 20; j++) {
					System.out.print(sw[j+(20*i)] + " ");
				}
				System.out.println();
			}
		}
		for(int i = 0; i<N%20; i++) {
			System.out.print(sw[i+(N/20)*20] + " ");
		}

	} //main
} //class
