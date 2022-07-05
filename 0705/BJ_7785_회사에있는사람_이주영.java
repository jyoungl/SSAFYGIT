package jul05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_7785_회사에있는사람_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Boolean> map = new HashMap<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String visit = st.nextToken();
			
			if(visit.equals("enter"))
				map.put(name, true);
			else if(visit.equals("leave"))
				map.replace(name, true, false);
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(String key : map.keySet()) {
			boolean visit = map.get(key);
			
			if(visit)
				list.add(key);
		}
		Collections.sort(list);
		for(int i=list.size()-1;i>=0;i--)
			sb.append(list.get(i)+"\n");
		System.out.println(sb);
	}

}
