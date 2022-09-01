import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1431_시리얼번호 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Guitar[] guitars = new Guitar[N];
		
		for(int i=0;i<N;i++) {
			guitars[i] = new Guitar(in.readLine());
		}
		
		Arrays.sort(guitars);
		
		for(int i=0;i<N;i++) {
			System.out.println(guitars[i].serial);
		}
		
	}

	static class Guitar implements Comparable<Guitar> {

		String serial;

		public Guitar(String serial) {
			this.serial = serial;
		}

		@Override
		public int compareTo(Guitar o) {

			int A = this.serial.length();
			int B = o.serial.length();

			if (A != B) {

				return A - B;

			} else {
				int sum1 = 0;
				int sum2 = 0;
				for (int i = 0; i < A; i++) {
					char temp = this.serial.charAt(i);
					if (temp >= '0' && temp <= '9') {
						sum1 += temp-'0';
					}
				}
				for (int i = 0; i < A; i++) {
					char temp = o.serial.charAt(i);
					if (temp >= '0' && temp <= '9') {
						sum2 += temp-'0';
					}
				}
				
				if(sum1 == sum2) {
					return this.serial.compareTo(o.serial);
				}
				
				return sum1 - sum2;
			}
		}

	}
}
