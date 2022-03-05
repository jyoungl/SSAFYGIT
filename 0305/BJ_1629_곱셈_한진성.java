import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		long A = Long.parseLong(st.nextToken());
		
		long B = Long.parseLong(st.nextToken());
		
		long C = Long.parseLong(st.nextToken());
		
		long answer = fpow(A,B,C);
		
		System.out.println(answer);
	}
	
	public static long fpow(long a, long b, long c) {
		
		if(b == 0) {
			return 1;
		}
		
		long X = fpow(a,b/2, c);
		
		if(b%2==0) {
			return X*X%c;
		}else {
			return (X*X%c)*a%c;
		}
		
	}

}
