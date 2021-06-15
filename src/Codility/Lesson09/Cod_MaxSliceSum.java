package Codility.Lesson09;

public class Cod_MaxSliceSum {
	// Task 30 Correctness 37 Performance 20
	public static void main(String[] args) {
		int A[] = {3, 2, -6, 4, 0};
		
		int answer = 0;
        if(A.length==1){
            answer = A[0];
        }else if(A.length ==2) {
        	answer = Math.max(Math.max(A[0], A[0]+A[1]), A[1]);
        }
        else{
            int start_idx = 0;
            int max = A[start_idx];
            int sum = A[start_idx];

            int cur_idx =  start_idx+1;

            while(true){
                sum = sum + A[cur_idx];
                if(max < sum){
                    max = sum;
                    cur_idx++;
                }else{
                    start_idx++;
                    sum = A[start_idx];
                    cur_idx = start_idx++;
                }

                if(cur_idx == A.length-1){
                    start_idx++;
                    cur_idx = start_idx+1;
                }
                if(start_idx == A.length-1) {
                	break;
                }

            }
            
            answer = max;
            
        }
        System.out.println(answer);
		
	}
}
