import java.io.*;

public class BOJ_1670_정상회담2 {
	public static void main(String[] args) throws Exception{
		int DIV = 987654321;
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		long[] result = new long[N+3];
		result[0] = 1;
		result[2] = 1;

		for(int i=4;i<=N;i+=2){
			long tmp = 0;
			for (int j = 0; j < i; j+=2) {
				tmp = (tmp + (result[i - 2 - j] * result[j])%DIV)%DIV;
			}
			result[i] = tmp;
		}

		System.out.println(result[N]);
	}
}
