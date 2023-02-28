import java.io.*;
import java.util.*;

class Solution {
    //장르별 재생 횟수 저장 위한 클래스
    public static class Music {
        String gen;
        int count;
        
        public Music(String gen, int count){
            this.gen = gen;
            this.count = count;
        }
    }
    //정답 계산 위한 (고유 번호, 횟수) 클래스
    public static class CountM implements Comparable<CountM>{
        int index;
        int count;
        
        public CountM(int index, int count){
            this.index = index;
            this.count = count;
        }
        
        @Override
        public int compareTo(CountM c) {
            return c.count - this.count;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Music> list = new ArrayList<>();

        //1. hashMap으로 장르별 재생횟수 카운트해 저장
        for(int i=0;i<genres.length;i++){
            String s = genres[i];
            int cnt = plays[i];
            
            if(map.containsKey(s)){
                int x = map.get(s);
                map.put(s, x+cnt);
            }
            else{
                map.put(s, cnt);
            }
        }
        //2. 장르별 재생 횟수 arrayList에 넣어서
        for(String key : map.keySet()){
            int cnt = map.get(key);
            list.add(new Music(key,cnt));
        }
        //3. 재생횟수 따라 내림차순으로 정렬해줌
        list.sort(new Comparator<Music>(){
            @Override
           public int compare(Music m1, Music m2){
               return m2.count - m1.count;
           } 
        });
        //4. 정답 저장 위한 arrayList
        ArrayList<Integer> ans = new ArrayList<>();
        //5. 장르 종류만큼 반복문 돌려서 장르별 베스트 곡 2개 선정
        for(int j=0;j<list.size();j++){
            String g = list.get(j).gen;
            //5-1. 장르 g에 속하는 노래들을 재생 횟수 따라 정렬해줄 우선순위 큐
            PriorityQueue<CountM> que = new PriorityQueue<>();
            //5-2. 노래 갯수만큼 반복문 돌려서 장르 g에 속하면 큐에 저장
            for(int i=0;i<plays.length;i++){
                if(g.equals(genres[i])){
                    que.add(new CountM(i,plays[i]));
                }
            }
            //5-3. 베스트곡 2개의 고유번호 arraylist에 저장. 이때 우선순위 큐에 값 있는지 확인
            for(int i=0;i<2;i++){
                if(!que.isEmpty()){
                    ans.add(que.poll().index);
                }
            }
        }
        //6. 정답 저장할 배열에 arraylist값 차례대로 넣어주기
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            answer[i] = ans.get(i);
        return answer;
    }
}
