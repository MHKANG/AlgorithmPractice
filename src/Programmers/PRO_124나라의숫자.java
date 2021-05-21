package Programmers;

public class PRO_124나라의숫자 {
	public String solution(int n) {
        String[] nums = {"4","1","2"}; // 나머지의 값을 기준으로  0 : 4 , 1: 1, 2: 2
        
        String answer = "";
        
        int number = n;
        
        while(number>0){
            int r = number%3; // 나머지 값
            number/=3; // 계속해서 3을 나누어서 자리 수 정하기
            
            if(r == 0)
                number--; // 3으로 나누었을 때 몫이 생기기 때문에 -1을 해주어야 한다. ex) 3/3 = 1 나머지는 0 이때 몫을 제거
                        // 이 같은 방법을 이후 3의 배수에서도 반복 해주어야 하기 때문
            answer = nums[r] + answer; // 이전에 나온 결과 값을 오른쪽에 붙인다.(나머지의 순서)
        }
        
        return answer;
    }
}
