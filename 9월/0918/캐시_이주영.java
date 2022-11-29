import java.io.*;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0)
            answer = (cities.length * 5);
        else{
            List<String> LRU = new LinkedList<>();

            for(int i=0;i<cities.length;i++){
                String now = cities[i].toUpperCase();

                if(LRU.contains(now)){ // 포함되어 있으면
                    LRU.remove(now);
                    LRU.add(now);

                    answer += 1;
                }
                else{
                    if(LRU.size() < cacheSize){
                        LRU.add(now);
                    }
                    else{
                        LRU.remove(LRU.get(0));
                        LRU.add(now);   
                    }
                    answer += 5;
                }
            }
        }
        return answer;
    }
}
