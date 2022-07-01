package 문제풀이;

import java.io.*;
import java.util.*;

public class S3_9375_패션왕신해빈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			Map<String, Integer> map = new HashMap<>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String wear = st.nextToken();
				String type = st.nextToken();
				
				if (map.containsKey(type)) map.put(type, map.get(type) + 1);
				else map.put(type, 1);

			}
			
			int ans = 1;
			
//			for (String key : map.keySet()){
//                ans *= (map.get(key) + 1);
//            }
			
			for (int val : map.values()) {
				ans *= val + 1;
			}
			
			sb.append((ans-1) + "\n");
			
		}
		
		System.out.println(sb);

	}

}
