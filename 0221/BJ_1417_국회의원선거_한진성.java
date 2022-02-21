import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1417_국회의원선거 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(in.readLine());
		
		int arr[] = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		int cnt = 0;
		// 다솜이 최댓값이 될때까지 반복
		while(true) {
			int max = 0;
			int maxIndex = 0;
			for(int i=0;i<N;i++) {
				// 표 중에 최댓값을 구한다. index도 같이 저장한다.
				if(max <= arr[i]) {
					max = arr[i];
					maxIndex = i;
				}
			}
			// 최댓값이 다솜이라면
			if(maxIndex == 0) {
				break;
			}
			arr[maxIndex]--;
			arr[0]++;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
