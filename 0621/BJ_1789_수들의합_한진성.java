import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1789_수들의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long S = Long.parseLong(in.readLine());
		
		long sum = 0;
		long num = 0;
		
		for(int i=1;i<S;i++) {
			sum += i;
			num++;
			if(sum > S) {
				num--;
				break;
			}
		}
		
		System.out.println(num);
		
	}

}
