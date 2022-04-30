import java.io.*;
import java.util.*;

class Solution {
    public long solution(long n, int[] times) {
        Arrays.sort(times);
        long min=0,max=times[times.length-1]*n;
        long mid = 0;
        long cnt;
        while(min<=max){
            mid = (min+max)/2;
            cnt = 0;
            
            for(int i=0;i<times.length;i++){
                cnt+=mid/times[i];
            }
            
            if(cnt>=n) max = mid-1;
            else min = mid+1;
        }
        
        return min;
    }
}
