class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];
        StringBuilder sb;
        for(int i=0;i<n;i++){
            char[] result = Integer.toBinaryString(arr1[i] | arr2[i]).toCharArray();
            sb = new StringBuilder();
            
            for(int j=result.length;j<n;j++) sb.append(' ');
            
            for(char x:result){
                if(x=='1') sb.append('#');
                else sb.append(' ');
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
