import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1735_분수합 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int A1 = Integer.parseInt(st.nextToken());
		int B1 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		
		int A2 = Integer.parseInt(st.nextToken());
		int B2 = Integer.parseInt(st.nextToken());
		
		int A = A1*B2 + A2*B1;
		
		int B = B1 * B2;
		
//		System.out.println(A+" "+B);
		
		int min = Math.min(A, B);
		int gcd = 0;
		for(int i=1;i<=min;i++) {
			if(A % i == 0 && B % i == 0) {				
				gcd = i;
			}
			
		}
		
		System.out.println(A/gcd +" "+B/gcd);
		
	}

}
