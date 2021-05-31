package Programmers;

public class PR0_문자열압축 {
	//https://jellyinghead.tistory.com/34 <-자력으로 해결하지 못해서 풀이를 참고 했다.
	public static void main(String[] args) {
		String s = "aabbaccc";
		
		int min = s.length();
		// 자르는 크기가 절반을 넘어가면 의미가 없음 (어짜피 1번밖에 못하기 때문)
		for(int i = 1; i <= s.length()/2; i++) {
			// 압축된 결과물을 저장
			StringBuilder sb = new StringBuilder();
			// 자르는 단위에 맞게 저장하기 위한 문자열
			String temp = "";
			// 중복되는 문자열 반복수를 체크
			int count = 1;
			
			// 중복되는 문자열의 길이만큼 반복을 시켜서 압축을 시도한다.
			for(int j = 0; j < Math.ceil((double)s.length()/i); j++) {
				// now에 아래와 같은 조건문이 달린 이유는 전체 문자열의 길이가 자르는 단위의 배수가 아닌 경우 끝에서 나누어떨어지지 않아 문제가 생기는데 
				// 이를 해결하기 위해 만약 자르는 마지막 위치가 전체 문자열의 마지막 인덱스보다 크다면 그 위치를 문자열의 맨마지막으로 만들어서 이를 해결한다.
				// ex) s = aabbaccc 일때 이 문자열은 8개 임으로 3개 단위로 체크하면 마지막에 남는 문자열은 2개인데 조건식에서는 그 이상의 위치 값을
				// 갈려고 하기 때문에 이를 막기 위해 now에서 substring으로 자를 때 마지막 위치를 문자열의 맨 끝으로 바꿔준다.
				// 그 외에는 자르는 문자열의 배수만큼 계속 갈 수 있도록 한다.
				String now = s.substring(j*i, i*(j+1) >= s.length() ? s.length() : i*(j+1));
				System.out.println(j*i + " " + i*(j+1));
				System.out.println("i : " + i +" " + "j : "+ j + " " +  " now : " + now);
				if(!temp.equals(now)) {
					if(count != 1) {
						sb.append(count);
						count = 1;
					}
					sb.append(temp);
					temp = now;
				}
				else
					count++;
			}
			if(count != 1)
				sb.append(count);
			sb.append(temp);
			
			min = Math.min(min, sb.toString().length());
		}
	}
}
