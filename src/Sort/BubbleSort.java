package Sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] ary = {10, 9, 1, 3, 5, 2};
		
		System.out.println(Arrays.toString(bubbleSort(ary)));
	}
	
	public static int[] bubbleSort(int[]ary) {
		
		for(int i = 0; i < ary.length-1; i++) {
			for(int j = 1; j < ary.length-i; j++) {
				if(ary[j-1]>ary[j]) {
					int temp = ary[j];
					ary[j] = ary[j-1];
					ary[j-1] = temp;
				}
			}
		}
		
		return ary;
	}
}
