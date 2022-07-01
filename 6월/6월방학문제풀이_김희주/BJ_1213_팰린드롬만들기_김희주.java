import java.io.*;

public class BOJ_1213_팰린드롬만들기 {
	public static void main(String[] args) throws Exception {
		char[] input = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		int[] count = new int[26];
		for (char c : input) {
			count[c - 'A']++;
		}

		char odd = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<26;i++){
			for(int j=0;j<count[i]/2;j++){
				sb.append((char)(i+'A'));
			}
			if(count[i]%2==1) {
				if(odd != 0){
					System.out.println("I'm Sorry Hansoo");
					return;
				}
				odd = (char) (i+'A');
			}
		}

		StringBuilder result = new StringBuilder(sb);
		if(odd != 0) result.append(odd);
		result.append(sb.reverse());
		System.out.println(result);
	}
}
