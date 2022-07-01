import java.io.*;
import java.util.*;

public class BOJ_11051_이항계수2 {
	static int mod = 10007;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] fac = new int[N+1];
		fac[0] = fac[1] = 1;
		for(int i=2;i<=N;i++){
			fac[i] = fac[i-1]*i%mod;
		}

		int a = fac[N];
		int b = fac[K]*fac[N-K]%mod;
		b = pow(b,mod-2)%mod;
		System.out.println((a*b)%mod);

	}
	private static int pow(int a, int n){
		if(n==0) return 1;
		if(n==1) return a;
		int res = pow(a,n/2);
		res = res*res%mod;
		return n%2==0?res:res*a%mod;
	}
}
