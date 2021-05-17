package Review;

import java.util.Scanner;

public class BOJ_1120_문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		
		int answer = A.length();
		
		// 현재 A와 B글자의 차이만 알면 그 이후에는 A의 양쪽에같은 걸로 붙히면 된다.
		// 따라서 현재 A와 B글자 차이수 만큼 A의 위치를 B에 빗대어 옮기면 된다.
		// ex A = abc  B = abcbba 라면
		// A의 위치를 B에서 옮겨서 최소로 차이나는 지점을 찾으면 그 이후로는 B와 같은 글자를 양 옆으로 붙히면 된다.
		// 위의 예시는 B가 A를 포함하고 있기때문에 0이지면 다른 글자에서는 자리를 한칸씩 이동시켜 비교하면 된다.
		
		// 이동 비교를 위한 포문
		for(int i = 0; i <= B.length()-A.length(); i++) {
		
			// 차이를 체크하는 변수
			int cnt = 0;
			
			// 얼마나 차이가 나는지 카운팅
			for(int j = 0; j < A.length();j++) {
				if(A.charAt(j)!= B.charAt(i+j)) {
					cnt++;
				}
			}
			answer = Math.min(cnt, answer);
		}
		System.out.println(answer);
	}
}
