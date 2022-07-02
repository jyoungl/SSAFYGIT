package 문제풀이;

import java.io.*;
import java.util.*;

public class S2_1699_제곱수의합 {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int DP[] = new int[N+1];

        for (int i = 1; i <= N; i++) {
            DP[i] = i;
            for (int j = 1; j*j <= i; j++) {
                if (DP[i] > DP[i-(j*j)] + 1) DP[i] = DP[i-(j*j)] + 1;
            }
        }
        
        System.out.println(DP[N]);
        
    }
    
}