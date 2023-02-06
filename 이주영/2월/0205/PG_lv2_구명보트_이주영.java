import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int len = people.length;
        int idx = 0;
        for(int i=len-1;i>=idx;i--){
            if(people[idx] + people[i] <= limit){
                idx++;
                answer++;
            }
            else
                answer++;
        }
//         boolean[] visited = new boolean[len];
//         for(int i=0;i<len;i++){
//             if(visited[i])
//                 continue;
            
//             int x = limit;
//             x -= people[i];
//             visited[i] = true;
//             answer++;
//             for(int j=len-1;j>i;j--){
//                 if(!visited[j] && x-people[j]>=0){
//                     visited[j] = true;
//                     x -= people[j];
//                 }
//                 if(x<people[i])
//                     break;
//             }
//         }
    
        return answer;
    }
}
