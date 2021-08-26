package Sort;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] ary = {10, 9, 1, 3, 5, 2};
		
		System.out.println(Arrays.toString(insertionSort(ary)));
	}
	
	public static int[] insertionSort(int[] ary) {
		
		for(int i = 1; i < ary.length; i ++) {
			int j = i-1;
			int key = ary[i];
			while(j>=0 && ary[j] > key) {
				ary[j+1] = ary[j];
				j--;
			}
			ary[j+1] = key;
		}
		
		return ary;
		
	}
}
