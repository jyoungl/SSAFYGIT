import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8320_직사각형을만드는방법 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		/*
		1일때 1개
		2일때 1,2 2개
		3일때 1,2,3, 3개
		4일때 1,2,3,4,4, 5개
		5일때 1,2,3,4,4,5 6개
		6일때 1,2,3,4,4,5,6,6 8개
		7일때 1,2,3,4,4,5,6,6,7 9개
		8일때 1,2,3,4,4,5,6,6,7,8,8,8 12개
		9일때 1 2 3 4 4 5 6 6 7 8 8 8 9 9 14개*/
		
		// 개수로는 규칙이 없다.
		// 힌트보면 6일때
		// 1줄짜리 6개 1*1 1*2 1*3 1*4 1*5 1*6
		// 2줄짜리 2개 2*1 2*2 2*3인데, 2*1 == 1*2이므로 스킵
		// 해서 총 8개
		// 9라면
		// 1줄짜리 9개 1*1 1*2 1*3 1*4 1*5 1*6 1*7 1*8 1*9
		// 2줄짜리 4개 2*1 2*2 2*3 2*4
		// 3줄짜리 1개 3*1 3*2 3*3 // 3*2, 3*1 스킵
		// 14개
		// N개 뽑기?
		
		int cnt = 0;
		int N = Integer.parseInt(in.readLine());
		for(int i=1;i<=N;i++) {
			for(int j=i;j<=N;j++) {
				if(i*j <= N) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	
	}
}
