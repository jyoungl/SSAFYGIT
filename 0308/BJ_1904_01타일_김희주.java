import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1904_01타일 {
	static long[] fib;
	static int DIV = 15746;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		fib = new long[N+1];
		fib[0] = 1;
		fib[1] = 1;
		System.out.println(findFib(N));
	}

	private static long findFib(int n) {
		if(fib[n]!=0) return fib[n];

		return fib[n] = (findFib(n-1)+findFib(n-2))%DIV;
	}
}
