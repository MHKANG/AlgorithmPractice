package Codility.Lesson5;

public class Cod_MinAvgTwoSlice {
	// Task: 60 Correctness : 100 Performance : 20
	public static void main(String[] args) {
		int[]A = {4, 2, 2, 5, 1, 5, 8};
		
		double avg_min = Double.MAX_VALUE;
        int answer = -1;
        for(int i = 0; i < A.length-1; i++){
            double sum = A[i];
            for(int j = i+1; j < A.length; j++){
                sum += A[j];
               
                double avg =(double)(sum/(j-i+1));
            
                if(avg < avg_min){
                    answer = i;
                    avg_min = avg;
                }
                
            }
            
        }
        System.out.println(answer);
	}
}
