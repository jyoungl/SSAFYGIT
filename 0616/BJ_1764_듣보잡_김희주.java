import java.io.*;
import java.util.*;

public class BOJ_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] input = new String[N];
		for(int i=0;i<N;i++) input[i] = in.readLine();
		Arrays.sort(input);
		ArrayList<String> list = new ArrayList<>();
		String name;
		for(int i=0;i<M;i++){
			name = in.readLine();
			if(Arrays.binarySearch(input,name)>=0){
				list.add(name);
			}
		}
		StringBuilder sb = new StringBuilder();
		Collections.sort(list);
		sb.append(list.size()).append('\n');
		for (String s : list) {
			sb.append(s).append('\n');
		}
		System.out.print(sb);
	}
}
