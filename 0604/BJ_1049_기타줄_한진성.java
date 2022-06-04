import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1049_기타줄 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[M][2];
		int min = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=0;j<2;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			if(arr[i][0] < min) {
				min = arr[i][0];
			}
			if(arr[i][1] < min2) {
				min2 = arr[i][1];
			}
		} 
		
		if(min2*6 < min) {
			System.out.println(min2*N);
			return;
		}
		int answer = 0;
		while(true) {

			
			if(N - 6 < 0) {
				if(min2*N < min) {
					answer = answer + min2*N;
				}else {
					answer = answer + min;
				}
				break;
			}
			N = N - 6;
			answer = answer + min;
		}
		System.out.println(answer);
		
		
	}

}
