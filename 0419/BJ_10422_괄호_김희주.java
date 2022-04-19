import java.io.*;

public class BOJ_10422_괄호 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long DIV = 1000000007;
		long[] result = new long[5001];
		result[0] = 1;
		result[2] = 1;

		for(int i=4;i<=5000;i+=2){
			long tmp = 0;
			for (int j = 0; j < i; j+=2) {
				tmp = (tmp + (result[i - 2 - j] * result[j])%DIV)%DIV;
			}
			result[i] = tmp;
		}

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int i=0;i<T;i++) sb.append(result[Integer.parseInt(in.readLine())]).append('\n');
		System.out.print(sb);
	}
}
