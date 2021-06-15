package Codility.Lesson10;


// Task 100 Correctness 100 Performance 100
public class Cod_CountFactors {
	public static void main(String[] args) {
		int N = 1;
		
		int answer = 0;
		
		for(long i = 1; i <=N; i++) {
			if(i*i>N)  // 약수의 대칭성 (하나의 약수를 찾으면 그 약수의 짝이 존재한다는 것을 이용)
				break;
			
			if(N%i == 0) {
				if(i*i==N)
					answer++;
				else {
					answer+=2;
				}
			}
		}
        
        System.out.println(answer);
  
	}
}
