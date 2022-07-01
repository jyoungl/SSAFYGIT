import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1676_팩토리얼0의개수 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		
		int cnt1 = 0;
		int cnt2 = 0;
		for(int i=N;i>0;i--) {
			
			int temp = i;
			while(temp % 2 == 0) {
				temp /= 2;
				cnt1++;
			}
			
			while(temp % 5 == 0) {
				temp /= 5;
				cnt2++;
			}
			
		}
		
		System.out.println(Math.min(cnt1, cnt2));
		
	}

}
