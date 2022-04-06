import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		// 봉지의 개수를 저장할 변수 B
		int B = 0;
		while(true) {
			// 키로수가 5로 나누어 떨어지면 
			if(N%5 == 0) {
				// 봉지수에 키로수/5(나누어 떨어지는 봉지 수)하여 더해주고 출력한 후 종료.
				B = B + N/5;
				System.out.println(B);
				return;
			}
			// 나누어 떨어지지 않으면 3키로봉지를 한 번 빼보고 다시 비교한다.
			// 키로 수 에서 3 빼고, 봉지개수 1 증가
			N = N-3;
			B++;
			// 만약 N에서 3을 뺐는데, 그 수가 음수라면 만들수 없는 상태
			if(N < 0) {
				// -1을 출력하고 종료한다.
				System.out.println(-1);
				return;
			}
		}
		
		
	}

}
