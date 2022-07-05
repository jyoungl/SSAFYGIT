import java.io.*;
import java.util.*;

public class BOJ_7785_회사에있는사람 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		Map<String,Integer> map = new HashMap<>();
		String name;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			name = st.nextToken();
			if(map.get(name) != null) map.remove(name);
			else map.put(name,1);
		}

		PriorityQueue<String> queue = new PriorityQueue<>((o1,o2)->o2.compareTo(o1));
		for(String key:map.keySet()){
			queue.offer(key);
		}

		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) sb.append(queue.poll()).append('\n');

		System.out.print(sb);
	}
}
