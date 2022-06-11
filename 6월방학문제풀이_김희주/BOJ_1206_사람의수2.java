import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ_1206_사람의수2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		BigDecimal[] avg = new BigDecimal[N];

		for (int i = 0; i < N; i++) {
			avg[i] = new BigDecimal("0."+in.readLine().split("\\.")[1]);
		}

		boolean flag;
		BigDecimal[] cases = new BigDecimal[1001];
		for (int num = 1; num <= 1000; num++) {
			for(int score=0;score<=num;score++){
				cases[score] = BigDecimal.valueOf(score).divide(BigDecimal.valueOf(num),3, RoundingMode.DOWN);
			}
			flag = true;
			for(int j=0;j<N;j++){
				if(Arrays.binarySearch(cases, 0, num+1, avg[j]) <0){
					flag = false;
					break;
				}
			}
			if(flag){
				System.out.println(num);
				return;
			}
		}

	}

}
