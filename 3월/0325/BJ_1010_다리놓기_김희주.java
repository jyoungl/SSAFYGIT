import java.io.*;
import java.util.*;
 
public class BOJ_1010_다리놓기 {
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
 
      int T = Integer.parseInt(in.readLine());
      StringBuilder sb = new StringBuilder();
 
      int[][] dp = new int[31][31];//m,n
      dp[0][0] = dp[1][0] = dp[1][1] = 1;
      for(int i=1;i<31;i++){
         dp[i][0] = 1;
         dp[i][1] = i;
         for(int j=2;j<31;j++){
            dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
         }
      }
 
      while(--T>=0){
         st = new StringTokenizer(in.readLine());
         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());
 
         sb.append(dp[M][N]).append('\n');
      }
 
      System.out.print(sb);
   }
}
