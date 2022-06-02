import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1024_수열의합 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int num = Integer.parseInt(st.nextToken());
		int split = Integer.parseInt(st.nextToken());

		int divide;
		int start;
		StringBuilder sb = new StringBuilder();
		while(true){
			divide = num/split;
			start = split%2==0? divide-split/2+1:divide-split/2;
			if(split>100 || start<0){
				sb.append("-1\n");
				break;
			}
			else if((split%2==0 && (double)num/split-divide==0.5)|| (split%2==1 && (double)num/split-divide==0)){
				for(int i=0;i<split;i++){
					sb.append(start+i).append(' ');
				}
				break;
			}
			split++;
		}
		System.out.print(sb);
	}
}
