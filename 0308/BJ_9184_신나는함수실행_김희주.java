import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9184_신나는함수실행 {
	static int[][][] w = new int[21][21][21];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String line;
		while(!(line=in.readLine()).equals("-1 -1 -1")){
			st = new StringTokenizer(line);

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(funcW(a,b,c)).append("\n");
		}
		System.out.print(sb);
	}

	private static int funcW(int a, int b, int c) {
		if(a<=0 || b<=0 || c<=0) return 1;
		if(a>20 || b>20 || c>20) return funcW(20,20,20);
		if(w[a][b][c]!=0) return w[a][b][c];

		if(a<b && b<c) return w[a][b][c] = funcW(a,b,c-1)+funcW(a,b-1,c-1)-funcW(a,b-1,c);
		else return w[a][b][c] = funcW(a-1,b,c)+funcW(a-1,b-1,c)+funcW(a-1,b,c-1)-funcW(a-1,b-1,c-1);
	}
}
