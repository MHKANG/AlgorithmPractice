package BOJ;

import java.util.Scanner;

public class BOJ_2305_자리배치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int F = sc.nextInt();
		
		
		
	}
	
	public static boolean check(int d_seat, int c_seat, int N) {
		boolean result = false;
		
		//일단 영화관 자리 범위 안에 있어야 하고
		if(c_seat >= 0 && c_seat<N) {
			// 본인의 지정석과 현재의 위치가 1이하일때만 옳바른 위치에 있음.
			if(Math.abs(d_seat-c_seat)<=1) {
				result = true;
			}
		}
		
		return result;
	}
}
