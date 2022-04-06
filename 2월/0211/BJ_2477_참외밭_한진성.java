import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭 {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[7][2];
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0) {
					arr[6][j] =arr[i][j];
				}
			}
		}
		int xMax = 0;
		int yMax = 0;
		for (int i = 0; i < 6; i++) {
			if (arr[i][0] == 3 || arr[i][0] == 4) {
				xMax = Math.max(xMax, arr[i][1]);
			}
			if (arr[i][0] == 1 || arr[i][0] == 2) {
				yMax = Math.max(yMax, arr[i][1]);
			}
		}
		int xMin = 0;
		int yMin = 0;
		// 연속해서 3131 2323 1414 4242가 나왔을 때, 2번째와 3번째가 작은 사각형이다.
		for (int i = 0; i < 7; i++) {
			if (i + 3 > 7) {
				continue;
			}
			// 313, 131
			if (arr[i][0] == 3 && arr[i + 1][0] == 1 && arr[i + 2][0] == 3) {
				xMin = arr[i + 1][1];
				yMin = arr[i + 2][1];
				break;
			} else if(arr[i][0] == 1 && arr[i+1][0]==3 && arr[i+2][0] == 1){
				xMin = arr[i][1];
				yMin = arr[i+1][1];
			}
			// 232, 323
			if (arr[i][0] == 2 && arr[i + 1][0] == 3 && arr[i + 2][0] == 2) {
				xMin = arr[i + 1][1];
				yMin = arr[i + 2][1];
				break;
			}else if(arr[i][0] == 3 && arr[i+1][0]==2 && arr[i+2][0] == 3){
				xMin = arr[i][1];
				yMin = arr[i+1][1];
			}
			// 141, 414
			if (arr[i][0] == 1 && arr[i + 1][0] == 4 && arr[i + 2][0] == 1) {
				xMin = arr[i + 1][1];
				yMin = arr[i + 2][1];
				break;
			}else if(arr[i][0] == 4 && arr[i+1][0]==1 && arr[i+2][0] == 4){
				xMin = arr[i][1];
				yMin = arr[i+1][1];
			}
			// 424, 242
			if (arr[i][0] == 4 && arr[i + 1][0] == 2 && arr[i + 2][0] == 4) {
				xMin = arr[i + 1][1];
				yMin = arr[i + 2][1];
				break;
			}else if(arr[i][0] == 2 && arr[i+1][0]==4 && arr[i+2][0] == 2){
				xMin = arr[i][1];
				yMin = arr[i+1][1];
			}
		}
		int ans = xMax * yMax - xMin * yMin;
		System.out.println(N * ans);
	}

}
