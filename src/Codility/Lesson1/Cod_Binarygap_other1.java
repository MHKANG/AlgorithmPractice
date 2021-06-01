package Codility.Lesson1;

import java.util.ArrayList;
//Correctness : 100% , Task Score = 100% Performance : 100% 
public class Cod_Binarygap_other1 {
	// 코드 출처  : https://hidelookit.tistory.com/2
	// 인덱스의 위치를 array 배열에 넣어서 그 위치의 차이 만큼 0의 개수를 구한다.
	public int solution(int num) {
		
		String binaryString = Integer.toBinaryString(num);
		
		int count = 0;
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for(int i = 0; i < binaryString.length(); i++) {
			if(binaryString.charAt(i) == '1') {
				array.add(i);
				count++;
			}
		}
		
		int result = 0;
		
		if(count == 1) {
			result = 0;
		}else {
			for(int i = 0; i < count -1; i++) {
				String zeroString = binaryString.substring(array.get(i), array.get(i+1));
				if(result < zeroString.length()) {
					result = zeroString.length();
				}
			}
		}
		
		return result;
	}
}
