import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String num = br.readLine();

		// 30배수는 항상 3의 배수이면서 10의 배수이다
		// 3의 배수는 각자리의 수의 합 또한 3의 배수다
		// 10의 배수는 항상 끝자리가 0이다
		int sum = 0;
		boolean zeroExist = false;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < num.length(); i++) {
			int c = num.charAt(i) - '0';
			sum += c;
			if (c == 0)
				zeroExist = true;
			pq.add(c);
		}

		if (sum % 3 == 0 && zeroExist == true) {
			while (!pq.isEmpty()) {
				sb.append(pq.poll());
			}
		} else {
			System.out.println(-1);
		}

		System.out.println(sb.toString().trim());
	}

}
