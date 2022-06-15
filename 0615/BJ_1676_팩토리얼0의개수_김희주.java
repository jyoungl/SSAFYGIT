import java.io.*;

public class BOJ_1676_팩토리얼0의개수 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		int cnt2 = 0;
		int cnt5 = 0;

		int num;
		for(int i=2;i<=N;i++){
			num = i;
			while(num%2==0){
				cnt2++;
				num/=2;
			}
			while(num%5==0){
				cnt5++;
				num/=5;
			}
		}

		System.out.println(Math.min(cnt2,cnt5));
	}
}
