import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringTokenizer st = new StringTokenizer(Integer.toString(n,k),"0");
        
        long tmp;
        boolean flag;
        for(int i=0,size = st.countTokens();i<size;i++){
            tmp = Long.parseLong(st.nextToken());
            if(tmp<2) continue;
            flag = true;
            for(long num=2;num<=Math.sqrt(tmp);num++){
                if(tmp%num==0) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer ++;
        }
        return answer;
    }
    
//     public String change(int n, int k){
//         StringBuilder sb = new StringBuilder();
//         while(n>=k){
//             sb.append(n%k);
//             n/=k;
//         }
//         sb.append(n);
//         sb.reverse();
//         return sb.toString();
//     }
}