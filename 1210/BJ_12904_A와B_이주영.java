package dec10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_12904_A와B_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		char[] T = br.readLine().toCharArray();
		ArrayList<Character> t = new ArrayList<>();
		
		for(int i=0;i<T.length;i++)
			t.add(T[i]);
		
		while(t.size() > s.length) {
			if(t.get(t.size()-1) == 'A') {
				//t.remove(t.get(t.size()-1));
				t.remove(t.size()-1);
			}
			else if(t.get(t.size()-1) == 'B') {
				t.remove(t.size()-1);
				Collections.reverse(t);
			}
		}
		
		for(int i=0;i<t.size();i++) {
			if(s[i] != t.get(i)) {
				System.out.println("0");
				return;
			}
		}
		
		System.out.println("1");
			
	}

}
