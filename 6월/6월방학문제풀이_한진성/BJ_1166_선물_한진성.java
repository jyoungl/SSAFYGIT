import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1166_선물 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		

		long O1 = L*W*H;
		
		double start = 0;
		double end = Math.max(L, Math.max(W, H));
		
		
		for(int i=0;i<10000;i++) {
			
			double half = (start+end)/2;
			if((long)(L/half)*(long)(W/half)*(long)(H/half) >= N) {
				start = half;
			}else {
				end = half;
			
			}
		}
		
		System.out.printf("%.14f",end);
	}

}
