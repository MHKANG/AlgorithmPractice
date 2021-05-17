package Review;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1431_시리얼번호 {
	
	static String[] s_ary;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		s_ary = new String[N];
		for(int i = 0; i < N; i++) {
			s_ary[i] = sc.next();
		}
		int count = 0;
		Arrays.sort(s_ary,new Comparator<String>(){
			
			@Override
			public int compare(String s1, String s2) {
				
				if(s1.length() > s2.length()) {
					return 1;
				}else if(s1.length() < s2.length()) {
					return -1;
				}else {
					int sum_s1 = 0;
					int sum_s2 = 0;
					for(int i = 0; i < s1.length(); i++) {
						 if(Character.isDigit(s1.charAt(i))) {
							 sum_s1 += (s1.charAt(i)-'0');
							 
						 }
					}
					
					for(int i = 0; i < s2.length(); i++) {
						 if(Character.isDigit(s2.charAt(i))) {
							 sum_s2 += (s2.charAt(i)-'0');
						 }
					}
					
					if(sum_s1 > sum_s2) {
						return 1;
					}else if(sum_s1 <sum_s2) {
						return -1;
					}else {
						return s1.compareTo(s2);
					}
				}
			}
			
		});
		for(String s : s_ary) {
			System.out.println(s);
		}	
	}
	
	
	
}
