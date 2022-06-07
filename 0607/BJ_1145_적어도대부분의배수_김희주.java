import java.io.*;
import java.util.*;

public class BOJ_1145_적어도대부분의배수 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

		int[] num = new int[5];
		for(int i=0;i<5;i++) num[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(num);

		int count;
		for(int i=num[0];;i++){
			count = 0;
			for(int j=0;j<5;j++){
				if(i<num[j]) break;
				if(i%num[j]==0) count++;
			}
			if(count>=3){
				System.out.println(i);
				break;
			}
		}
	}
}
