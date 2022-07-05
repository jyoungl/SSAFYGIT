package 문제풀이;

import java.io.*;
import java.util.*;

public class S4_17219_비밀번호찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String pw = st.nextToken();
			map.put(site, pw);
		}
		
		for (int i = 0; i < M; i++) {
			String find = br.readLine();
			bw.write(map.get(find) + "\n");
		}
		
		bw.flush();
		bw.close();

	}

}
