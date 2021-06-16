package Codility.Lesson10;

// Task 100 Correctness 100 Performance 100
public class Cod_MinPerimeterRectangle {
	
    public static int solution(int N) {
        
        int answer = Integer.MAX_VALUE;

        if(N==1)
            return 4;

        for(int i =1; i<=N; i++){
            if(i*i>N)
                break;
            if(N%i == 0){
                int div = N/i;
                answer = Math.min(answer, 2*(div+i));
            }
        }

        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(1));
	}
	
}
