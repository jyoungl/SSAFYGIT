import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2004_조합0의개수 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long N = Long.parseLong(st.nextToken());
		
		long M = Long.parseLong(st.nextToken());

		long cnt1 = 0;
		long cnt2 = 0;
		
		// N!
		for(long i=2;i<=N;i*=2) {
			cnt1 += N/i;
		}
		for(long i=5;i<=N;i*=5) {
			cnt2 += N/i;
		}
			
		long cnt3 = 0;
		long cnt4 = 0;
		
		// M1
		for(long i=2;i<=M;i*=2) {
			cnt3 += M/i;
		}
		for(long i=5;i<=M;i*=5) {
			cnt4 += M/i;
		}
		
		// (N-M)!
		
		long cnt5 = 0;
		long cnt6 = 0;
		for(long i=2;i<=N-M;i*=2) {
			cnt5 += (N-M)/i;
		}
		for(long i=5;i<=N-M;i*=5) {
			cnt6 += (N-M)/i;
		}
		
		long two = cnt1 - cnt3 -cnt5;
		long five = cnt2 - cnt4 - cnt6;
		
		System.out.println(Math.min(two, five));
		
	}

}
