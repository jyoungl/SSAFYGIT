import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1110_더하기사이클 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String N = in.readLine();
		String origin = N.toString();
		if(origin.length() == 1) {
			origin = origin + "0";
		}
		int cnt = 0;
		while (true) {
			cnt++;
			if (N.length() == 1) {
				N = N + "0";
			}

			int A = N.charAt(0) - '0';
			int B = N.charAt(1) - '0';
			int C = A + B;
			if(C >= 10) {
				C = C - 10;
			}
			N = N.charAt(1)+String.format("%d",C) ;
			
//			System.out.println("N: "+N);
//			System.out.println("ori:"+origin);		
			if(N.equals(origin)) {
				break;
			}

		}
		
		
		System.out.println(cnt);
	}

}
