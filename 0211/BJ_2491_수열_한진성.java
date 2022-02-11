import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491_수열 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		
		int cnt = 1;
		int max1 = 1;
		int first = Integer.parseInt(st.nextToken());
		int second = first;
		int[] arr = new int[N];
		for(int i=1;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<N;i++) {
			int K = arr[i];
			
			if(K >= first) {
				cnt++;
				first = K;
			}else {
				cnt = 1;
				first = K;
			}
			max1 = Math.max(cnt, max1);
		}
		int cnt2 = 1;
		int max2 = 1;		
		for(int i=1;i<N;i++) {
			int K = arr[i];
			
			if(K <= second) {
				cnt2++;
				second = K;
			}else {
				cnt2 = 1;
				second = K;
			}
			max2 = Math.max(cnt2, max2);
		}
		System.out.println(Math.max(max1, max2));
	}

}
