package feb13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class BJ_1339_단어수학_이주영_x {
	static boolean[] visited = new boolean[10];
	static HashMap<Character,Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<char[]> list = new ArrayList<>();
		for(int i=0;i<N;i++)
			list.add(br.readLine().toCharArray());
		
		list.sort(new Comparator<char[]>() {
			@Override
			public int compare(char[] o1, char[] o2) {
				// TODO Auto-generated method stub
				return o2.length- o1.length;
			}
		});
		
		long ans = 0;
		for(int i=0;i<list.size();i++) {
			ans += func(list.get(i));
		}
		
		System.out.println(ans);
	}

	public static int func(char[] word) {
		String s = "";
		
		for(int i=0;i<word.length;i++) {
			char c = word[i];
			if(map.containsKey(c)) {
				s += String.valueOf(map.get(c));
			}
			else {
				for(int j=9;j>=0;j--) {
					if(!visited[j]) {
						map.put(c, j);
						visited[j] = true;
						s += String.valueOf(j);
						break;
					}
				}
			}
		}
		return Integer.parseInt(s);
	}
}
