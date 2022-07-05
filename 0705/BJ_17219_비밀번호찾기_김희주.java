import java.io.*;
import java.util.*;

public class BOJ_17219_비밀번호찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String,String> map = new HashMap<>(N);
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			map.put(st.nextToken(), st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++){
			sb.append(map.get(in.readLine())).append('\n');
		}
		System.out.print(sb);
	}
}
