import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		for(int i=1;i<=N;i++) {
			String str = in.readLine();
			map.put(str, String.valueOf(i));
			map2.put(String.valueOf(i), str);
			
		}
		StringBuilder sb =new StringBuilder();
		for(int i=0;i<M;i++) {
			String str = in.readLine();
			if(map.get(str) != null) {
				sb.append(map.get(str)).append('\n');
			}else if(map2.get(str)!= null) {
				sb.append(map2.get(str)).append('\n');
			}
			
		}
		
		System.out.println(sb);

	}

}
