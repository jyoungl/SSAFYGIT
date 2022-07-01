import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1302_베스트셀러_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		int max = 0;
		String res = "";
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			
			if(!map.containsKey(s)) {
				map.put(s, 1);
			}
			else {
				map.put(s, map.get(s)+1);
			}
		}
		
		for(String s : map.keySet()) {
			int x = map.get(s);
			if(x == max) {
				if(res.compareTo(s) > 0)
					res = s;
			}
			else if(x > max) {
				max = x;
				res = s;
			}
		}
		
		System.out.println(res);
	}

}
