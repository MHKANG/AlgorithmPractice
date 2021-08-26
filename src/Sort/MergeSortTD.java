package Sort;

import java.util.Arrays;

public class MergeSortTD {
	
	private static int[] sorted;
	
	public static void main(String[] args) {
		
		int[] ary = {10, 9, 1, 3, 5, 2};
		sorted = new int[ary.length];
		System.out.println(Arrays.toString(ary));
		mergeSort(ary, 0, ary.length-1);
		System.out.println(Arrays.toString(ary));
		sorted = null;
		
	}
	
	
	public static void mergeSort(int[] ary, int left, int right) {
		
		
		if(left == right)
			return;
		
		int mid = (left+right)/2;
		
		mergeSort(ary, left, mid);
		mergeSort(ary, mid+1, right);
		merge(ary,left, mid, right);
		
	}
	
	public static void merge(int[]ary, int left, int mid, int right) {
		int l = left; // 왼쪽 부분 리스트 시작점
		int r = mid+1; // 오른쪽 부분 리스트 시작점
		int idx = left; // 채워 넣을 배열의 인덱스
		
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
		
		if(l>mid) {
			while(r <=right) {
				sorted[idx] = ary[r];
				idx++;
				r++;
			}
		}else {
			while(l <=mid) {
				sorted[idx] = ary[l];
				idx++;
				l++;
			}
		}
		
		for(int i = left; i <=right; i++) {
			ary[i] = sorted[i];
		}
		
	}
	
	
	
	
	
}
