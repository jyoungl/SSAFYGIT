import java.io.*;

public class BOJ_2193_이친수 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		long[] fib = new long[90];
		fib[0] = fib[1] = 1;
		for(int i=2;i<N;i++) fib[i] = fib[i-1]+fib[i-2];
		System.out.println(fib[N-1]);
	}
}
