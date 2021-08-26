package Sort;

import java.util.Arrays;

public class MergeSortBU {
private static int[] sorted;
	
	public static void main(String[] args) {
		
		int[] ary = {10, 9, 1, 3, 5, 2};
		sorted = new int[ary.length];
		System.out.println(Arrays.toString(ary));
		mergeSort(ary, 0, ary.length-1);
		System.out.println(Arrays.toString(ary));
		sorted = null;
		
	}
	
	public static void mergeSort(int[]ary, int left, int right) {
		
		
		for(int size = 1; size<=right; size+=size) {
			
			for(int l = 0; l <=right-size; l+=(2*size)) {
				int low = 1;
				int mid = l+size-1;
				int high = Math.min(1+(2*size)-1, right);
				merge(ary, low, mid, high);
			}
		}
	}
	
	public static void merge(int[]ary, int left, int mid, int right) {
		int l = left;
		int r = mid +1;
		int idx = left;
		
		while(l <=mid && r<=right) {
			
			if(ary[l] <=ary[r]) {
				sorted[idx] = ary[l];
				idx++;
				l++;
			}else {
				sorted[idx] = ary[r];
				idx++;
				r++;
			}
		}
		
		if(l > mid) {
			while(r<=right) {
				sorted[idx]= ary[r];
				idx++;
				r++;
			}
		}else {
			while(l<=mid) {
				sorted[idx] = ary[l];
				idx++;
				l++;
			}
		}
		for(int i =left; i<=right; i++) {
			ary[i] = sorted[i];
		}
	}
}
