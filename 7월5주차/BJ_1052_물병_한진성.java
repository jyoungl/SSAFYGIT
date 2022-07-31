import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1052_물병 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        int K = Integer.parseInt(st.nextToken());
        
        if(N <= K) {
        	System.out.println(0);
        	return;
        }
        int answer = 0;
        while(true) {
        	int cnt = 0;
        	int mul = N;
        	while(mul > 0) {
        		if(mul % 2 == 1) {
        			cnt++;
        		}
        		mul/=2;
        	}
        	if(cnt <= K)break;
        	answer++;
        	N++;
        }
        
        System.out.println(answer);
	}

}
