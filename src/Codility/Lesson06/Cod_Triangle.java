package Codility.Lesson06;

// Task: 56 Correctness : 90 Performance : 0 
public class Cod_Triangle {
	static boolean check = false;
	public static void main(String[] args) {
		int[] A = {10, 50, 5, 1};
		int answer = 0;
		combi(A, new int[3], 0, 0);
		if(check)
			answer = 1;
		else
			answer = 0;
		
		System.out.println(answer);
	}
	
	// cur가 현재 input ary에서 어떤 값을 선택했는지 안했는지를 확인해주는 변수
	public static void combi(int[]ary,int[]result ,int cnt, int cur) {
		
		if(cnt == 3) {
			int P = result[0];
			int Q = result[1];
			int R = result[2];
			
			if(P+Q > R && P +R > Q && Q+R > P){
				check = true;
				
				return;
			}
		}else {
			for(int i = cur; i < ary.length; i++) {
				result[cnt] = ary[i];
				combi(ary, result, cnt+1, i+1);
			}
		}
	}
	
}
