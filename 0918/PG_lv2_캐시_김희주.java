import java.util.*;
 
class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 1. chcheSize만큼의 배열. 객체는 Item
        // 2. 입력받은 도시 전체 탐색.
        // 2-1. 캐시배열을 돌면서 null값 등장하면 바로 현재 도시 입력. (miss => 5 추가)
        // 2-2. 끝까지 돌았는데 현재 도시 안나오면 idx 가장 작은 자리에 덮어씌움 (miss => 5추가)
        // 2-3. 돌던 중 현재 도시가 나오면 idx만 덮어씌움(hit => 1추가)
        
        if(cacheSize==0) return cities.length * 5;
        
        int answer = 0;
        
        Item[] cache = new Item[cacheSize];
        for(int idx=0;idx<cities.length;idx++){
            boolean hit = false;
            int[] min = {Integer.MAX_VALUE,0};
            
            for(int i=0;i<cacheSize;i++){
                if(cache[i]==null){
                    answer += 5;
                    cache[i] = new Item(idx, cities[idx]);
                    hit = true;
                    break;
                } else if(cache[i].city.toLowerCase().equals(cities[idx].toLowerCase())){
                    cache[i].idx = idx;
                    answer += 1;
                    hit = true;
                    break;
                } else {
                    if(min[0] > cache[i].idx){
                        min[0] = cache[i].idx;
                        min[1] = i;
                    }
                }
            }
            if(!hit){
                answer += 5;
                cache[min[1]] = new Item(idx, cities[idx]);
            }
        }
        
        return answer;
    }
    
}
 
class Item {
    int idx;
    String city;
    public Item(int idx, String city){
        this.idx = idx;
        this.city = city;
    }
}
