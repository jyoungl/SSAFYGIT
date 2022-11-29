import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        char[] mbti = {'R','T','C','F','J','M','A','N'};
        //각 유형마다 번호 설정
        HashMap<Character,Integer> res = new HashMap<>();
        //인덱스 = 각 유형 번호, 유형별 점수 계산
        int score[] = new int[8];
        
        for(int i=0; i<8; i++)
            res.put(mbti[i],i);
            
        for(int i=0; i<survey.length; i++){
            char[] arr = survey[i].toCharArray();
            
            switch (choices[i]){
                case 1 : score[res.get(arr[0])]+=3;
                         break;
                case 2 : score[res.get(arr[0])]+=2;
                         break;
                case 3 : score[res.get(arr[0])]+=1;
                         break;
                case 4 : break;
                case 5 : score[res.get(arr[1])]+=1;
                         break;
                case 6 : score[res.get(arr[1])]+=2;
                         break;
                case 7 : score[res.get(arr[1])]+=3;
                         break;
                default : break;
            }      
        }
        
        String answer = "";
        for(int i=0;i<8;i+=2){
            if(score[i]>score[i+1])
                answer+=mbti[i];
            
            else if(score[i]==score[i+1]){
                answer += (mbti[i] < mbti[i+1] ? mbti[i] : mbti[i+1]);
            }
            
            else
                answer+=mbti[i+1];
        }
        return answer;
    }
}
