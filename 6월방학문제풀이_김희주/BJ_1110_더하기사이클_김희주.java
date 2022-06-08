import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1110_더하기사이클 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		int prev=N;
		int tmp;
		int count = 0;
		while(true){
			if(prev<10) tmp = prev*10+prev;
			else tmp = prev%10*10+(prev/10+prev%10)%10;
			prev = tmp;
			count++;
			if(N==tmp){
				break;
			}
		}

		System.out.println(count);
	}
}
