import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1059_좋은구간 {

	static int[] numbers;
	static int N, answer;
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());

		int[] arr = new int[L];

		for (int i = 0; i < L; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		N = Integer.parseInt(in.readLine());
		int start = 0;
		int end = 0;
		for (int i = 0; i < L; i++) {
			if (arr[i] > N) {
				end = arr[i]-1;
				if (i == 0) {
					start = 1;
				} else {
					start = arr[i - 1]+1;
				}
				break;
			}
		}
		int term = 0;
		numbers = new int[2];
		comb(start, end, 0);
		System.out.println(answer);
		
	}
	static void comb(int start,int end, int cnt) {

		if(cnt == 2) {
			if(numbers[0] < numbers[1]) {
				if(N >= numbers[0] && N <= numbers[1]) {
					answer++;
				}
			}
			return;
		}
		
		for(int i=start;i<=end;i++) {
			numbers[cnt] = i;
			comb(i,end,cnt+1);
		}
		
	}
}
