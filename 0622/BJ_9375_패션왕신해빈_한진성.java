import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕신해빈 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(in.readLine());
		
		
		
		for(int tc=0;tc<T;tc++) {
			
			int N = Integer.parseInt(in.readLine());
			Map<String, Integer> map = new HashMap<>();
			
			for(int i=0;i<N;i++) {
				StringTokenizer st= new StringTokenizer(in.readLine());
				st.nextToken();
				String temp = st.nextToken();
				if(map.containsKey(temp)) {
					map.put(temp, map.get(temp)+1);
				}else {
					map.put(temp, 1);
				}
			}
			
			int ans = 1;
			
			for(String key : map.keySet()) {
				
				ans *= (map.get(key)+1);
				
			}
			
			ans--;
			
			System.out.println(ans);
			
			
		}
	}

}
