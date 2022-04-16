class Solution {
    public int solution(int[][] triangle) {		
		for (int depth = triangle.length-1; depth > 0; depth--) {
			for (int width = 0; width < depth; width++) {
				triangle[depth-1][width] += Math.max(triangle[depth][width], triangle[depth][width + 1]); 
			}
		}
		
		return triangle[0][0];
    }
}