import java.io.*;
import java.util.*;

public class BOJ_4796_캠핑 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while(!(line = in.readLine()).equals("0 0 0")){
			st = new StringTokenizer(line);
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			sb.append("Case ").append(tc++).append(": ").append(V/P*L+Math.min(L,V%P)).append('\n');
		}
		System.out.print(sb);
	}
}
