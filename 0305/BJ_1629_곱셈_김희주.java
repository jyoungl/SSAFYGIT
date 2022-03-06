import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈 {
	static int C;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		System.out.println(pow(A%C,B));

	}

	private static long pow(int A, int B){	//리턴값이 long이 아니면 오버플로우. 2147483646 3 2147483647
		if(B==1) return A;

		long result = pow(A,B/2);
		result = result*result%C;
		return B%2!=0? result*A%C:result;

	}
}
