package lv21_이분탐색;

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
		
		Arrays.sort(times);
		
		long max = (long)times[times.length-1]*n;
		long min = 1;
		
		while(min<=max) {
			long mid = (max+min)/2;
			
			long sum = 0;
			
			for(int i = 0; i<times.length; i++) {
				sum += mid/times[i];
			}
			
			if(sum >= n) {
                max = mid-1;
                answer = mid;
            }
			else min = mid+1;
			
		}
		
		return answer;
    }
}