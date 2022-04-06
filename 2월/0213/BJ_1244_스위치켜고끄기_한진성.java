import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		int[] arr = new int[N + 1];

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int S = Integer.parseInt(in.readLine());

		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			// 남자일때
			if (gender == 1) {
				for (int j = 1; j <= N; j++) {
					if (j % num == 0) {
						arr[j] = (arr[j] + 1) % 2;
					}
				}
				// 여자일때
			} else {
//				arr[num] = (arr[num] + 1) % 2;
				int x = num;
				int y = num;
				
				while (true) {
					if (x > 0 && y <= N && arr[x] == arr[y]) {
						x--;
						y++;
					} else {
						break;
					}
				}
				x++;
				y--;
				for(int j=x;j<=y;j++) {
					arr[j] = (arr[j]+1)%2;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[1]).append(" ");
		for (int i = 2; i <= N; i++) {
			if (i % 20 == 1) {
				sb.setLength(sb.length() - 1);
				sb.append("\n");
			}
			sb.append(arr[i]).append(" ");
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}

}
