import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1251_단어나누기 {
	static ArrayList<String> list = new ArrayList<>();
	static int N, R;
	static int[] numbers;
	static String str;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		str = in.readLine();
		N = str.length() - 1;
		R = 2;
		// 1부터 길이-2까지 중에서 2개 숫자 고르기 중복은 같은거니까 조합으로
		numbers = new int[2];
		comb(1, 0);

		Collections.sort(list);
		
//		System.out.println(list);
		
		System.out.println(list.get(0));
		
	}

	static void comb(int start, int cnt) {

		if (cnt == R) {
//			System.out.println(Arrays.toString(numbers));
			String temp1 = str.substring(0, numbers[0]);
			String temp2 = str.substring(numbers[0], numbers[1]);
			String temp3 = str.substring(numbers[1]);
			
//			System.out.println(temp1);
//			System.out.println(temp2);
//			System.out.println(temp3);
//			System.out.println("======================");
			
			StringBuilder sb = new StringBuilder(temp1);
			temp1 = sb.reverse().toString();

			sb = new StringBuilder(temp2);
			temp2 = sb.reverse().toString();

			sb = new StringBuilder(temp3);
			temp3 = sb.reverse().toString();
			
			list.add(temp1+temp2+temp3);
			
			return;
		}

		for (int i = start; i <= N; i++) {

			numbers[cnt] = i;
			comb(i + 1, cnt + 1);

		}

	}

}
