import java.io.*;

public class BOJ_2839_설탕배달 {
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int result = 0;
        while(N>=0){
            if(N%5==0){
                result += N/5;
                break;
            }
            N-=3;
            ++result;
        }

        if(N<0) System.out.println(-1);
        else System.out.println(result);


//
//        int[] result = new int[2];
//        int sum;
//
//        result[0] = N / 5;
//        result[1] = (N - result[0] * 5) / 3;
//
//        while (true) {
//            sum = result[0] * 5 + result[1] * 3;
//
//            if (sum != N && result[0] == 0) break;
//            else if (sum == N) break;
//
//            --result[0];
//            result[1] = (N - result[0] * 5) / 3;
//
//        }
//
//        if (sum == N) System.out.println(result[0] + result[1]);
//        else System.out.println(-1);
    }
}
