package Programmers;

import java.util.Arrays;

// Reference : https://wellbell.tistory.com/157
public class PRO_행렬테두리회전하기 {
	static int[][] matrix;
	static int min;
	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][]queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[]answer = new int[queries.length];
		
		matrix = new int[rows+1][columns+1];
		int value = 1;
		for(int i = 1; i < rows+1; i ++) {
			for(int j = 1; j < columns+1; j ++) {
				matrix[i][j] = value++;		
			}
			
		}
		for(int i = 0; i < queries.length; i++) {
			answer[i] = roatate(queries[i]);
		}
		
		System.out.println(Arrays.toString(answer));
        
		
	}
	public static int roatate(int[]query) {
		
		 int rowRange = query[2]- query[0];
		 int colRange = query[3]- query[1]; 
		 
		 
		 int nr = query[0];
		 int nc = query[1];
		 int now = matrix[nr][nc];
		 
		 min = now;
		 
		 for(int i = 0; i < colRange; i++) {
			 nc +=1;
			 now = moveValue(nr, nc, now);
		 }
		 for(int i = 0; i < rowRange; i++) {
			 nr +=1;
			 now = moveValue(nr, nc, now);
		 }
		 for(int i = 0; i < colRange; i++) {
			 nc -=1;
			 now = moveValue(nr, nc, now);
		 }
		 for(int i = 0; i < rowRange; i++) {
			 nr -=1;
			 now = moveValue(nr, nc, now);
		 }
		
		return min;
	}
	
	public static int moveValue(int r, int c, int pre) {
		int temp = matrix[r][c];
		
		min = Math.min(min, temp);
		matrix[r][c] = pre;
		
		return temp;
	}
}
