package Codility.Lesson04;

public class Cod_FrogRiverOne {
	// Correctness : 100% , Task Score = 63% Performance : 20% 
	// Time out occur
	// Time Complexity : O(N^2)
	public static void main(String[] args) {
		int answer = -1;
		int X = 5;
		int[] A = {0, 3, 1, 4, 2, 3, 5, 4};
        boolean[] check = new boolean[X+1];

        for(int i = 0; i < A.length; i++){
            check[A[i]] = true;
            if(checkStop(check)){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
	}
	public static boolean checkStop(boolean[] input){
        boolean result = true;

        for(int i = 1; i < input.length; i++){
            if(!input[i]){
                result = false;
                break;
            }
        }

        return result;
    }
}
