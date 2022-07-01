import java.io.*;
import java.util.*;

public class BOJ_1476_날짜계산 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int E = Integer.parseInt(st.nextToken())-1;
		int S = Integer.parseInt(st.nextToken())-1;
		int M = Integer.parseInt(st.nextToken())-1;

		int e=0,s=0,m=0;
		for(int i=1;;i++){
			if(e==E && s==S && m==M){
				System.out.println(i);
				break;
			}
			e = (e+1)%15;
			s = (s+1)%28;
			m = (m+1)%19;
		}
	}
}
