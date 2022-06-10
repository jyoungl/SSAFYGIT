import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1206_사람의수 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(in.readLine());
		
		double arr[] = new double[N];
		
		// 값을 읽어오고 정수부는 빼준다.
		// 5.864 - 5.0을 하니까 5.86399999999가 나온다 ㅋㅋ... 반올림 함수로 소수점 넷째자리에서 반올림해준다.
		for(int i=0;i<N;i++) {
			arr[i] = Double.parseDouble(in.readLine());
			if(arr[i] > 1) {

				arr[i] = arr[i] - Math.floor(arr[i]);
				arr[i] = Math.round(arr[i]*1000.0)/1000.0;
			}
		}
		
		// 소수점 셋째자리에서 반올림하기 때문에 가능한 경우의 수는 1~1000까지 인 것을 예상할 수있다.
		// 만약 1000명이라면 0.001부터 0.999까지 모든 소수점을 커버할 수 있기 때문
		// 1부터 1000까지 가능한 분수의 경우의 수를 브루트포스로 탐색한다.
		for(int i=1;i<=1000;i++) {
			double[] nums = new double[i+1];
			
			// 경우의 수 저장하는 부분
			// 1인 경우 0/1, 1/1
			// 2인 경우 0/2, 1/2, 2/2
			// 3인 경우 0/3, 1/3, 2/3, 3/3
			// ... 1000까지 소수점 셋째자리에서 끊어서 배열에 저장한다.
			for(int j=0;j<=i;j++) {
				nums[j] = Math.floor((1.0*j/i)*1000.0)/1000.0;
			}
			
			int cnt = 0;
			
			// 문항의 평균 수만큼 배열의 값과 비교
			// 모든 문항의 평균 값의 소수점이 배열에 있는 값이라면 그 인원수가 정답이다. 
			// 각 문항의 평균이 위에서 저장한 소수점 배열에 있다면 카운팅한다.
			for(int j=0;j<N;j++) {
				
				for(int k=0;k<nums.length;k++) {
					if(arr[j] == nums[k]) {
						cnt++;
					}
				}
				
			}
			// 모든 문항에 대해 만족하는 경우 해당 인원수가정답이므로 i를 출력하고 리턴
			if(cnt == N) {
				System.out.println(i);
				break;
			}
		}
		

		
	}

}
