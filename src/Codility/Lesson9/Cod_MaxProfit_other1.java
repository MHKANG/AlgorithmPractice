package Codility.Lesson9;

// task 44 correctness 80 performance 0
public class Cod_MaxProfit_other1 {
	
	public static void main(String[] args) {
//		int[]A = {23171, 21011, 21123, 21013, 21367};
		int[]A = {8,9,3,6,1,2};
		
        
		int min = (A.length>0) ? A[0] : 0;
		int answer = 0;
		for(int num : A) {
			if(num <= min) {
				min = num;
			}
			if(answer < num -min) {
				answer = num -min;
			}
		}
		
		
	    System.out.println("answer : "+ answer);

	}
	
}
