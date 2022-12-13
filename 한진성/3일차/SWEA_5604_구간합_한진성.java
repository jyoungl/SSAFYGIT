import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5604_구간합_한진성{

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			long answer = 0;
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			long A = Long.parseLong(st.nextToken());
			
			long B = Long.parseLong(st.nextToken());
			long[] count = new long[10];
			long current = 1;
			
			if(A == 0) {
				A = 1;
			}
			
			while(A <= B) {
				while(A%10 != 0 && A <= B) {
					for(long i = A; i > 0 ; i /= 10) {
						String str = Long.toString(i);
						int temp = str.charAt(str.length()-1)-'0';
						count[temp] += current;
					}
					A++;
				}
				
				if(A > B) break;
				
				while(B%10 != 9 && A <= B) {
					for(long i = B; i > 0 ; i /= 10) {
						String str = Long.toString(i);
						int temp = str.charAt(str.length()-1)-'0';
						count[temp] += current;
					}
					B--;
				}
				long dif = B/10 - A/10 +1;
				for(int i=0;i<10;i++) {
					count[i] += dif*current;
				}
				current*=10;
				B /= 10;
				A /= 10;
			}
			
			for(int i=1; i<10; i++) {
				answer += (i*count[i]);
			}
			
			
			
			System.out.println("#"+tc+ answer);
		}
			
	}

}
