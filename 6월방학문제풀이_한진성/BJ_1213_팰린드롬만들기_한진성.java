import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1213_팰린드롬만들기 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int[] alpa = new int[200];

		char[] str = in.readLine().toCharArray();

		for (int i = 0; i < str.length; i++) {
			alpa[str[i]]++;
		}

		int cnt = 0;

		for (int i = 0; i < alpa.length; i++) {
			if (alpa[i] % 2 == 1) {
				cnt++;
			}
		}

		if (cnt > 1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		if(cnt == 1 && str.length%2 == 0) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}

		char[] answer = new char[str.length];

		// 문자열이 짝수일 경우
		if (str.length % 2 == 0) {
			for(int i=0;i<str.length/2;i++) {
				for(int j=0;j<alpa.length;j++) {
					if(alpa[j] != 0 && alpa[j] %2 == 0) {
						answer[i] = (char)j;
						answer[str.length-1-i] = (char)j;
						alpa[j] -=2;
						break;
					}
				}
			}
		} else {
			for(int i=0;i<alpa.length;i++) {
				if(alpa[i] % 2 == 1) {
					answer[str.length/2] = (char)i;
					alpa[i]--;
					break;
				}
			}
			
			for(int i=0;i<str.length/2;i++) {
				
				for(int j=0;j<alpa.length;j++) {
					
					if(alpa[j] != 0 && alpa[j] %2 == 0) {
						answer[i] = (char)j;
						answer[str.length-1-i] = (char)j;
						alpa[j] -=2;
						break;
					}
					
				}
			}
		}
		
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]);
		}
		
	}

}
