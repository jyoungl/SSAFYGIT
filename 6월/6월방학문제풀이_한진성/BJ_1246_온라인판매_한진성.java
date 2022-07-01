import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1246_온라인판매 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		int arr[] = new int[M];

		int max = 0;
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			max = Math.max(max, arr[i]);
		}

		Arrays.sort(arr);
		int answerNum = 0;
		int answerBenefit = 0;
		for (int l = max; l >= 0; l--) {
			int temp = N;
			int benefit = 0;
			for (int i = arr.length - 1; i >= 0; i--) {
				if(arr[i] >= l) {
					if(temp == 0) {
						break;
					}
					temp--;
					benefit += l;
				}else {
					break;
				}
			}
			if(answerBenefit < benefit) {
				answerNum = l;
				answerBenefit = benefit;
			}
		}

		System.out.println(answerNum+" "+answerBenefit);
		
	}

}
