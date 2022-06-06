import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1124_언더프라임 {
	public static void main(String[] args) throws IOException {
		boolean[] prime = new boolean[100001];
		int[] count = new int[100001];
		prime[0] = prime[1] = true;
		for(int i=2;i<100001;i++){
			if(prime[i]) continue;
			for(int j=i+i;j<100001;j+=i){
				prime[j] = true;
				int tmp = j;
				while(tmp%i==0){
					tmp/=i;
					count[j]++;
				}
			}
		}
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int res = 0;
		for(int i=A;i<=B;i++){
			if(!prime[count[i]]) res++;
		}

		System.out.println(res);
	}
}
