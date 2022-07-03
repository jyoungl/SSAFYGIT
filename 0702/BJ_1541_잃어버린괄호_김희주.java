import java.io.*;
import java.util.*;

public class BOJ_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
		int idx = input.indexOf('-');
		int result = 0;

		StringTokenizer st = new StringTokenizer(input.substring(0,idx<0?input.length():idx),"+,-");
		for(int count = st.countTokens();count>0;count--) result += Integer.parseInt(st.nextToken());

		if(idx>=0) {
			st = new StringTokenizer(input.substring(idx), "+,-");
			for (int count = st.countTokens(); count > 0; count--) result -= Integer.parseInt(st.nextToken());
		}

		System.out.println(result);
	}
}
