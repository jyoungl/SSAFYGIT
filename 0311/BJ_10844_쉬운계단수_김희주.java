import java.io.*;

public class BOJ_10844_쉬운계단수 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int DIV = 1000000000;

		int[][] nums = new int[N][10];
		nums[0] = new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				nums[i][j] += ((j > 0 ? nums[i - 1][j - 1] : 0) + (j < 9 ? nums[i - 1][j + 1] : 0)) % DIV;
			}
		}

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (sum + nums[N - 1][i]) % DIV; 	//절대 sum += nums[N-1][i]%DIV 하면 안됨. nums[N-1][i]만 DIV연산이 들어가기 때문(필요없는 연산..)
		}

		System.out.println(sum);
	}
}
