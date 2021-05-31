package Algorithm;

public class 소수판별하기 {
	public static void main(String[] args) {
		int num = 13;
		
		if(num < 2) {
			System.out.println("소수가 아닙니다.");
		}
		if(num == 2) {
			System.out.println("주어진 숫자는 소수 입니다");
		}
		for(int i = 2; i < num ; i++) {
			if(num % i == 0) {
				System.out.println("주어진 숫자는 소수가 아닙니다.");
			}
		}
		System.out.println("소수입니다.");
	}
}
