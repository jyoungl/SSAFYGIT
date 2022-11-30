import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_26069_붙임성좋은총총이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Map<String, Boolean> map = new HashMap<>();
		map.put("ChongChong", true);
		
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String name1 = st.nextToken();
			String name2 = st.nextToken();
			
			if((map.get(name1) != null && map.get(name1)) || (map.get(name2) != null && map.get(name2))) {
				map.put(name1, true);
				map.put(name2, true);
			}
			
		}
		
		System.out.println(map.size());
	}

}
