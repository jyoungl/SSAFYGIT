import java.io.*;
import java.util.*;

public class BOJ_1057_토너먼트 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int N = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());

		int count = 1;
		while(true){
			//더 작은 쪽이 홀수면서 1차이가 나야함
			//둘 중 하나라도 0 이하라면 끝내버림
			if((kim<lim && kim%2==1 && lim-kim==1)||(lim<kim && lim%2==1 && kim-lim==1)){
				System.out.println(count);
				break;
			}
			else if(kim<=0 || lim<=0){
				System.out.println(-1);
				break;
			}
			if(kim%2==1) kim++;
			if(lim%2==1) lim++;
			kim/=2;
			lim/=2;
			count++;
		}
	}
}
