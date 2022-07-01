package jun21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1620_나는야포켓몬마스터이다솜_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> map = new HashMap<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] str = new String[N+1];
		
		for(int tc=1;tc<=N;tc++) {
			String s = br.readLine();
			map.put(s, tc);
			str[tc] = s;
		}
		
		for(int tc=1;tc<=M;tc++) {
			String s = br.readLine();
			if(map.containsKey(s)) {
				sb.append(map.get(s)).append("\n");;
				continue;
			}
			else {
				int i = Integer.parseInt(s);
				sb.append(str[i]).append("\n");
			}
		}
		System.out.println(sb);
	}

}
