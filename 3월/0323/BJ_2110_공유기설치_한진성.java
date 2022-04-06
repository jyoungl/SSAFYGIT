import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int C = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(arr);
		
		int start = 1; // 최소거리
		int max = arr[N-1]-arr[0]; // 최대거리
		int answer = 0;
		while(start <= max) {
			// 공유기 수
			int cnt = 1;
			// 간격 정하기
			int half = (start + max)/2;
			// 가장 처음위치에 설치한다. 처음 집과 뺄셈하여 비교한다
			int current = arr[0];
			for(int i=1;i<N;i++) {
				// 이전 집의 위치 - 현재위치 = 거리차이 거리차이가 half보다 크거나 같아야지만 설치 가능
				if(arr[i] - current >= half) { 
					// 설치한 공유기 수 증가.
					cnt++;
					current = arr[i];
				}
			}
			
			// 공유기 설치의 개수가 C보다 더 많은 경우 간격을 넓힌다.
			if(cnt >= C) {
					start = half+1;
					answer = half;
				}else{
					max = half-1;
				}
		}
		
		System.out.println(answer);
				
	}

}
