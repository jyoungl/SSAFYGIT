package programmers;

import java.io.*;
import java.util.*;

public class k진수에서소수개수구하기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int ans = solution(n, k);
		
		System.out.println(ans);

	}

	public static int solution(int n, int k) {
        int answer = 0;
    
        String str = "";

        while(n > 0) {
            str = (n%k) + str;
            n/=k;
        }
        
        List<Long> list = new ArrayList<>();
        
        String tmp = "";
        for (int i = 0; i < str.length(); i++) {
        	char c = str.charAt(i);
			if(c=='0') {
				if(tmp == "") continue;
				list.add(Long.parseLong(tmp));
				tmp = "";
			}
			else tmp += c;
		}
        
        if(tmp != "") list.add(Long.parseLong(tmp));

        for(int i = 0; i<list.size(); i++) {
                   long num = list.get(i);

            if(num == 1) continue;
            
            boolean prime = true;
            
            for(int j = 2; j<=Math.sqrt(num); j++){
                if(num%j == 0){
                    prime = false;
                    break;
                }
            }
            
            if(prime) answer++;

        }

        return answer;
    }

}
