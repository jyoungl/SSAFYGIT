import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수2 {
	static int[] fib = new int[41];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		fib[0] = 0;
		fib[1] = 1;

		while(--T>=0){
			int N = Integer.parseInt(in.readLine());

			if(N==0) {
				sb.append("1 0\n");
				continue;
			}

			fibonacci(N);
			sb.append(fib[N-1]).append(" ").append(fib[N]).append("\n");
		}
		System.out.print(sb);
	}

	private static void fibonacci(int n) {
		if(n<2 || fib[n]!=0) return;

		fibonacci(n-1);
		fib[n] = fib[n-1]+fib[n-2];
	}
}
