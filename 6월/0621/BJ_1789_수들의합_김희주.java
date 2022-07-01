import java.io.*;

public class BOJ_1789_수들의합 {
	public static void main(String[] args) throws IOException {
		long S = Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine());

		for(int i=1;;i++){
			S-=i;
			if(S<0){
				System.out.println(i-1);
				return;
			}else if(S==0){
				System.out.println(i);
				return;
			}

		}
	}
}
