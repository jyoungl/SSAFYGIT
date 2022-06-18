import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1764_듣보잡 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String,Integer> map =  new HashMap<>();
		
		for(int i=0;i<N;i++) {
			map.put(in.readLine(), 1);
		}
		
		List<String> list = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			String temp = in.readLine();
			if(map.containsKey(temp)) {
				list.add(temp);
			}
		}
		Collections.sort(list);
		int size = list.size();
		System.out.println(size);
		for(int i=0;i<size;i++) {
			System.out.println(list.get(i));
		}
		
	}

}
