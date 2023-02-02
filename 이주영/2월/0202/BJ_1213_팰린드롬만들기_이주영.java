package feb02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class BJ_1213_팰린드롬만들기_이주영 {
	public static class Name {
		char c;
		int num;
		
		public Name(char c, int num) {
			this.c = c;
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] name = br.readLine().toCharArray();
		int len = name.length;
		int[] alpha = new int[26];
		HashMap<Character, Integer> map = new HashMap<>();
		ArrayList<Name> list = new ArrayList<>();
		
		for(int i=0;i<len;i++) {
			char c = name[i];
			if(map.containsKey(c))
				map.put(c, map.get(c)+1);
			else
				map.put(c, 1);
		}
			
		//팰린드롬이 가능한지 체크
		int b = 0;
		char middle = 0;
		for(Character c : map.keySet()) {
			int cnt = map.get(c);
			if(cnt%2==1) {
				b++;
				middle = c;
			}
			
			if(b>=2) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
			
			list.add(new Name(c, cnt));
		}
		
		list.sort(new Comparator<Name>() {
			@Override
			public int compare(Name o1, Name o2) {
				return o1.c - o2.c;
			}
		});

		char[] answer = new char[len];
		int idx = 0;
		for(int i=0;i<list.size();i++) {
			Name n = list.get(i);
			if(n.num%2 == 1)
				answer[len/2] = middle;
			
			for(int j=0;j<n.num/2;j++) {
				answer[idx] = n.c;
				answer[len-idx-1] = n.c;
				idx++;
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<len;i++)
			sb.append(answer[i]);
		
		System.out.println(sb);
	}

}
