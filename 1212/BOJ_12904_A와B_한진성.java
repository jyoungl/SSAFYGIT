import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12904_A와B_한진성 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder S = new StringBuilder(in.readLine());
		StringBuilder T = new StringBuilder(in.readLine());
		
		for(int i = T.length(); i>S.length();i--) {
			if(T.charAt(i-1) == 'A') {
				T.setLength(T.length()-1);
			}else {
				T.setLength(T.length()-1);
				T.reverse();
			}
		}
		
		if(T.toString().equals(S.toString())) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

}
