package Codility.Lesson04;

public class Cod_FrogRiverOne2 {
	// Correctness : 100% , Task Score = 100% Performance : 100% 
	// Time Complexity : O(N)
	public static void main(String[] args) {
		int answer = -1;
		int X = 5;
		int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
		
        boolean[] check = new boolean[X+1];
        int check_count = X;
        for(int i = 0; i < A.length; i++){
          if(!check[A[i]] && check_count!=0) {
        	  check[A[i]] = true;
        	  check_count--;
          }
          if(check_count == 0) {
        	  answer = i;
        	  break;
          }
        }
        System.out.println(answer);
	}
	
}
