import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
				
		long M = Long.parseLong(st.nextToken());
		
		long arr[] = new long[N];
		
		st = new StringTokenizer(in.readLine()," ");
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		long max = 0;
		for(int i=0;i<N;i++) {
			max = Math.max(max, arr[i]);
		}
		long start = 0;

		while(start <= max) {
			long half = (start + max)/2;
			long sum = 0;
			for(int i=0;i<N;i++) {
				long temp = arr[i] - half;
				sum += (temp>0) ? temp: 0;
			}
//			System.out.println(sum);
			if(sum >= M) {
				start = half+1;
			}else{
				max = half-1;
			}
		}
		System.out.println(max);
		
	}

}
