class Solution {
    public int solution(int n, int[][] computers) {
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(computers[i][i]!=1) continue;
            dfs(i, computers);
            cnt++;
        }
        return cnt;
    }
    public void dfs(int x, int[][] computers){
        computers[x][x] = 2;
        
        for(int i=0;i<computers[x].length;i++){
            if(i==x || computers[i][i]!=1 || computers[x][i]!=1) continue;
            dfs(i,computers);
        }
        
    }
}
