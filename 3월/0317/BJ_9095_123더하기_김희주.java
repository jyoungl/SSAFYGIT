import java.io.*;

public class BOJ_9095_123더하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		int[] nums = new int[12];
		nums[1] = 1;
		nums[2] = 2;
		nums[3] = 4;

		while(--T>=0){
			int N = Integer.parseInt(in.readLine());

			if(nums[N]!=0) {
				sb.append(nums[N]).append("\n");
				continue;
			}

			for(int i=4;i<=N;i++){
				if(nums[i]!=0) continue;
				nums[i] = nums[i-1]+nums[i-2]+nums[i-3];
			}

			sb.append(nums[N]).append("\n");
		}
		System.out.print(sb);
	}
}
