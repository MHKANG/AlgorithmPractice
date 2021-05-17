package BOJ;

import java.util.Scanner;

// 문자열의 범위가 10만자이기 때문에 유사회문을 검증하는 과정에서 10만번을 계속해서 돌리다보니 시간 초과가 나는 것으로 보임

public class BOJ_17609_회문_시간초과 {
	
	static String[] ary;
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		ary = new String[T];
		result = new int[T];
		
		for(int i = 0; i < T; i++) {
			ary[i]  = sc.next();
		}
		for(int i = 0; i < T; i++) {
			result[i] = 0;
		}
		
		for(int i = 0; i < ary.length; i++) {
			if(!check_palindrome(ary[i])) {
				result[i]++;
			}
			
		}
		for(int i = 0; i < ary.length; i++) {
			if(!check_pseudo_palindrome(ary[i])) {
				result[i]++;
			}
			
		}
		
		for(int v : result) {
			System.out.println(v);
		}
		
		
	}
	// 회문 체크
	static boolean check_palindrome(String s) {
		boolean check = true;
		
		for(int j = 0; j < s.length()/2; j++) {
			if(s.charAt(j) != s.charAt(s.length()-j-1)) {
				check = false;
				break;
			}
		}
		
		return check;
	}
	// 유사 회문 체크
	static boolean check_pseudo_palindrome(String s) {
		boolean check = false;
		
		for(int i = 0; i <s.length(); i++) {
			StringBuffer sb = new StringBuffer(s);
			String temp = sb.deleteCharAt(i).toString();
			if(check_palindrome(temp)) {
				check = true;
				break;
			}
		}
		
		return check;
	}
}
