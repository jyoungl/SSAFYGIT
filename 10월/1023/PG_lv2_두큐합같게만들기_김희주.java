class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int size = queue1.length;
        int[] queue = new int[size * 2];
        
        long sum = 0;
        long section = 0;
        for(int i=0;i<size;i++) {
            sum+=queue1[i]+queue2[i];
            queue[i] = queue1[i];
            queue[size+i] = queue2[i];
            section += queue1[i];
        }
        
        if(sum%2==1) return -1;

        sum /= 2;
        
        int p1=0, p2=size;
        while(p2 < queue.length){
            if(section == sum){
                return p1+p2-size;
            }
            else if(section < sum){
                section += queue[p2++];
            }else {
                section -= queue[p1++];
            }
        }
        
        return -1;
        
        
    }
}
