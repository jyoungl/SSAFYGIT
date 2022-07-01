import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10610_30 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] chars = in.readLine().toCharArray();
		
		Arrays.sort(chars);
		
		StringBuilder sb = new StringBuilder();
		if((chars[0]-'0') != 0) {
			System.out.println(-1);
			return;
		}
		int sum = 0;
		for(int i=chars.length-1;i>=0;i--) {
			
			sum = sum + (chars[i]-'0');
			
			sb.append(chars[i]);
			
		}
		
		if(sum%3 == 0) {
			System.out.println(sb);
		}else {
			System.out.println(-1);
		}
	}

}
