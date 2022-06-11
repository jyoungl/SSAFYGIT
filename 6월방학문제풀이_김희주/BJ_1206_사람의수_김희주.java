import java.io.*;
import java.util.*;

public class BOJ_1206_사람의수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		double[] avg = new double[N];

		for (int i = 0; i < N; i++) {
//			avg[i] = 0.001 * Integer.parseInt(in.readLine().split("\\.")[1]);
			avg[i] = Double.parseDouble(in.readLine());
			avg[i] = avg[i] - Math.floor(avg[i]);
			avg[i] = Math.round(avg[i]*1000.0)/1000.0;
		}


		boolean flag;
		double[] cases = new double[1001];
		for (int num = 1; num <= 1000; num++) {
			for(int score=1;score<=num;score++){
				cases[score] = Math.floor(((double)score/num)*1000)/1000.0;
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
