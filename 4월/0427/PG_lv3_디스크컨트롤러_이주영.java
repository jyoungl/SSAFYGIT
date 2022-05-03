import java.util.*;

class Solution {       
       public int solution(int[][] jobs) {
           Arrays.sort(jobs, new Comparator<int[]>(){
               
               @Override
               public int compare(int[] o1, int[] o2){
                   if(o1[0] == o2[0])
                       return o1[1] - o2[1];
                   else
                       return o1[0] - o2[0];
               }
           });
           
           PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
              
              @Override
              public int compare(int[] o1, int[] o2){
                    return o1[1] - o2[1];
                }
           });
           
           
           heap.add(jobs[0]); 
           
           int end = jobs[0][0];
           int sum = 0;
           int idx = 1;
           
           while(!heap.isEmpty()){
               int[] s = heap.poll();
               end += s[1];
               sum += end - s[0];
               
               while(idx < jobs.length && jobs[idx][0] <= end){
                   heap.add(jobs[idx++]);
               }
               
               if(idx < jobs.length && heap.isEmpty()){
                   end = jobs[idx][0];
                   heap.add(jobs[idx++]);
               }
           }
           
           int answer = sum / jobs.length;
           return answer;
       }
   }
