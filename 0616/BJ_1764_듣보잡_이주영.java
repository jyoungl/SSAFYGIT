import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<String> hs = new HashSet<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<String> str = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			hs.add(s);
		}
		
		for(int i=0;i<M;i++) {
			String s = br.readLine();
			if(hs.contains(s)) {
				str.add(s);
			}
		}
		Collections.sort(str);
		int cnt = str.size();
		System.out.println(cnt);
		
		for(int i=0;i<cnt;i++) {
			System.out.println(str.get(i));
		}
	}

}
