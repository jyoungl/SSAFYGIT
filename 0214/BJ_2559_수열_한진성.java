import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(st.nextToken());
		
		
		int arr[] = new int[N];
		st = new StringTokenizer(in.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			if(i+K > N) {
				break;
			}
			int sum = 0;
			for(int j=i;j<i+K;j++) {
				sum += arr[j];
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

}
