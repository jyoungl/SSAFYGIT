import java.io.*;

//그냥 외우기...
//{{1,1},{1,0}} n-1 제곱하면 [0][0]자리에 피보나치 n번째 수가 나옴
//[0][0], [1][0]에는 Fn, Fn-1이 있고 [0][1], [1][1]에는 Fn-1, Fn-2가 있음
//따로 피보나치 행렬을 저장하지 않아도 항상 2*2로 따라다님--> 그래서 빠름
public class BOJ_11444_피보나치수6 {
	static final int DIV = 1000000007;

	public static void main(String[] args) throws IOException {
		long N = Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine());
		System.out.println(fibonacci(N));
	}

	private static long fibonacci(long n) {
		if (n <= 2) return 1;//자연수라서 0인 경우 생각x
		long[][] matrix = {{1,1},{1,0}};

		return pow(matrix,n-1)[0][0];
	}

	private static long[][] multiply(long[][] A, long[][] B){
		long[][] result = new long[2][2];
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				int elem = 0;
				for(int k=0;k<2;k++){
					elem+=A[i][k]*B[k][j]%DIV;
				}
				result[i][j] = elem%DIV;
			}
		}
		return result;
	}

	private static long[][] pow(long[][] A, long B){
		if(B==1) return A;

		long[][] result = pow(A,B/2);
		result = multiply(result,result);
		return B%2!=0? multiply(result,A):result;
	}
}
