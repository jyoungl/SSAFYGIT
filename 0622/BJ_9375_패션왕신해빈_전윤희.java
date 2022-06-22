package 기타;

import java.io.*;
import java.util.*;

// 구글링
public class BJ_9375_패션왕신해빈_해시맵 {
	static String[][] costume;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int clothes = Integer.parseInt(br.readLine());		
			HashMap<String, Integer> hm = new HashMap<>();
			for (int i = 0; i < clothes; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String name = st.nextToken();
				String type = st.nextToken();
				
				// 맵에서 키나 값이 있는지 확인하는 함수로 containsKey와 containsValue 가 존재 (boolean)
				if(hm.containsKey(type)==true) {
					hm.put(type, hm.get(type)+1);
				} else {
					hm.put(type, 1);
				}
			}
			
			int ans = 1;
			// .values() : map의 value 목록을 Collection 형태로 리턴
			for (int val : hm.values()) {
				// 안입는 경우를 고려하여(NULL) +1
				ans = ans * (val+1);
			}
			// 알몸으로 나가는 경우 -1
			sb.append(ans-1).append("\n");
		} // 테스트케이스 end
		
		System.out.println(sb);
	}
}
