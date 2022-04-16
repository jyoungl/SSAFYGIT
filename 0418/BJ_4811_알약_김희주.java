import java.io.*;
import java.util.*;

public class BOJ_4811_알약 {
	public static void main(String[] args) throws IOException {
		long[] arr = new long[31];
		arr[0] = 1;

		for (int i = 1; i <= 30; i++) {
			long tmp = 0;
			for (int j = 0; j < i; j++) {
				tmp += arr[i - 1 - j] * arr[j];
			}
			arr[i] = tmp;
		}

		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while(!(line = in.readLine()).equals("0")){
			sb.append(arr[Integer.parseInt(line)]).append('\n');
		}

		System.out.print(sb);
	}
}
