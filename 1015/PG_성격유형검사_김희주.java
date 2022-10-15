import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        char[][] type = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        
        Map<Character, Integer> map = new HashMap<>();
        
        //점수초기화
        for(int i=0;i<4;i++){
            map.put(type[i][0],0);
        }
        
        for(int i=0;i<survey.length;i++){
            int score = Math.abs(4-choices[i]);
            if(choices[i] > 4) score *= -1;             //4초과라면 마이너스
            if(!map.containsKey(survey[i].charAt(0))){//사전순인지 체크
                //사전순 아니라면 마이너스
                score *= -1;
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1))+score);
            } else{
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0))+score);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<4;i++){
            if(map.get(type[i][0])<0) answer.append(type[i][1]);
            else answer.append(type[i][0]);
        }
        
        return answer.toString();
    }
}
