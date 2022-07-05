package jul05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_17219_비밀번호찾기_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); //사이트 주소 수
		int M = Integer.parseInt(st.nextToken()); //비번 찾으려는 주소 수
		HashMap<String, String> map = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String email = st.nextToken();
			String pw = st.nextToken();
			map.put(email, pw);
		}
		
		for(int i=0;i<M;i++) {
			String email = new StringTokenizer(br.readLine()).nextToken();
			sb.append(map.get(email)+"\n");
		}
		System.out.println(sb);
	}

}
