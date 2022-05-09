import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		// 정수형 배열 리스트 선언 및 생성
		List<int[]> list = new ArrayList<>();

		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine(), " ");
		int check = 0;
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			check += temp;
			if (temp != 0) {
				list.add(new int[] { i, temp });
			}
		}
		//오른쪽
		int X = 0;
		//왼쪽
		int Y = 0;
		//높이
		int H = 0;

		for (int i = 0; i < list.size(); i++) {
			// 높이가 최댓값인 수
			if (H <= list.get(i)[1]) {
				X = i;
				Y = i;
				H = list.get(i)[1];
			}
		}

		int ans = 0;

		ans += list.get(X)[1];
		// 오른쪽 탐색
		while (true) {
			int secondH = 0;

			int x = 0;

			if (X + 1 >= list.size()) {
				break;
			}

			for (int i = X + 1; i < list.size(); i++) {
				if (list.get(i)[1] > secondH) {
					secondH = list.get(i)[1];
					x = i;
				}
			}
			ans += (list.get(x)[0] - list.get(X)[0]) * list.get(x)[1];
			X = x;
		}
		
		// 왼쪽 탐색
		while (true) {
			int secondH = 0;
			int y = 0;

			if (Y - 1 < 0) {
				break;
			}
			for (int i = Y - 1; i >= 0; i--) {
				if (list.get(i)[1] > secondH) {
					secondH = list.get(i)[1];
					y = i;
				}
			}
			ans += (list.get(Y)[0] - list.get(y)[0]) * list.get(y)[1];
			Y = y;
		}
		System.out.println(ans - check);
	}
}
