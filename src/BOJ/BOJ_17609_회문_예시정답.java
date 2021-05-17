package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17609_회문_예시정답 {
	
	static int T;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		String word = "";
		int result = 0;
		
		for(int i = 0; i < T; i++) {
			word = br.readLine();
			result = palindrom(word);
			System.out.println(result);
			
		}
	}
	
	public static int palindrom(String word) {
		int result = 0;
		int left = 0;
		int right = word.length()-1;
		
		while(left<=right) {
			// 문자열이 같은 경우 좌우를 한칸씩 줄여서 다음 위치를 찾음
			if(word.charAt(left) == word.charAt(right)) {
				left++;
				right--;
			// 다르다면 좌측 또는 우측을 하나씩 줄여서 회문인지 검사를 시작
			}else {
				int l = left;
				int r = right;
				l++;
				while(l<=r) {
					if(word.charAt(l) == word.charAt(r)) {
						l++;
						r--;
					}else {
						result++;
						break;
					}
				}
				// 만약 좌축에서 줄였는데 회문이 아니라면 우측도 줄여서 이를 확인 해본다 그럼에도 회문이 없다면 일반 문자열
				// 우측에서도 줄여봐야 하기 때문에 값을 원래의 left와 right를 넣어서 시작한다.
				l = left;
				r = right;
				r--;
				while(l<=r) {
					if(word.charAt(l) == word.charAt(r)) {
						l++;
						r--;
					}else {
						result++;
						break;
					}
				}
				return result;
			}
		}
		return result;
	}
}
