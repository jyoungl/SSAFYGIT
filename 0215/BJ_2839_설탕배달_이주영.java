import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2839_설탕배달_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int x=0, y=0; //3킬로, 5킬로 봉지 수
		
		int i= N/5; //최대 5킬로 봉지수부터 시작
		while(true) {
			int temp = N;
			y = i;
			temp -= (5*i);
			
			if(temp%3 == 0) {
				x = temp/3;
				break;
			}
			i--;
			
			if(i < 0) {
				System.out.println("-1");
				return;
			}
		}

		System.out.println(x+y);
	}

}
