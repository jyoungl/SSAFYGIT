import java.io.*;
import java.util.*;

public class BOJ_9375_패션왕신해빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N;
		String type;
		Map<String,Integer> map;
		for(int tc=0;tc<T;tc++){
			N = Integer.parseInt(in.readLine());
			map = new HashMap<>();
			for(int i=0;i<N;i++){
				st = new StringTokenizer(in.readLine());
				st.nextToken();
				type = st.nextToken();
				map.put(type,map.getOrDefault(type,0)+1);
			}

			int result = 1;
			for(Map.Entry<String,Integer> entry:map.entrySet()){
				result *= (entry.getValue()+1);//가짓수 + 안뽑히는경우
			}

			sb.append(result-1).append('\n');//모두 안뽑히는 경우는 뺌
		}
		System.out.print(sb);
	}
}
