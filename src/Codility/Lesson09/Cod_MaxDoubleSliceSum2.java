package Codility.Lesson09;

import java.util.Arrays;

// Task : 53 Correctness : 83 Performance : 28
public class Cod_MaxDoubleSliceSum2 {
	public static void main(String[] args) {
		int[]A = {3, 2, 6, -1, 4, 5, -1, 2};
		
		int answer = Integer.MIN_VALUE;

        
        int[] temp = Arrays.copyOfRange(A, 1, A.length-1);
        System.out.println(Arrays.toString(temp));
        Arrays.sort(temp);
        int sum = 0;
        for(int i = 1; i < temp.length; i++){
            if(temp[i] > 0)
                sum += temp[i];
        }

        answer = sum;
        System.out.println(answer);
	}
}
