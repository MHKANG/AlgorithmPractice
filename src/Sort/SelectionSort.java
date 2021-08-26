package Sort;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] ary = {10, 9, 1, 3, 5, 2};
		
		System.out.println(Arrays.toString(selectionSort(ary)));
	}
	
	public static int[]selectionSort(int[] ary){
		
		for(int i = 0; i < ary.length-1; i ++) {
			int index = i;
			for(int j = i+1; j <ary.length; j++) {
				if(ary[index]>=ary[j])
					index = j;
			}
			int temp = ary[index];
			ary[index] = ary[i];
			ary[i] = temp;
		}
		
		return ary;
	}
}
