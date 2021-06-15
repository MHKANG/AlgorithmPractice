package Codility.Lesson10;

import java.util.ArrayList;
import java.util.List;

// Reference : https://datacodingschool.tistory.com/71
// Reference : https://www.youtube.com/watch?v=8DvYb9lVcRM

/* Write comment which I understand reference Code with Korean
   Unfortunately I use over 30 minutes for understand this Question.
   I can't solve myself so reference other Code with Googling
   I find two type of Code below code another Code which use BiSection Algorithm
   I read BiSection Code but can't understand it. So use below Code
   The reference Code use python so I convert it Java
 */
public class Cod_Flags_other {
	public static void main(String[] args) {
		 int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
		 
		 int answer = -1;
		 
		 List<Integer>plist = new ArrayList<>();

		// 봉우리가 될 수 있는 index를 저장하는 배열을 만든다.
        for(int i = 1; i < A.length-1; i++){
            if(A[i] >A[i-1] && A[i] > A[i+1]){
                plist.add(i);
            }
        }
        // 만약 봉우리가 0개 또는 1개라면 flag의 수는 각 봉우리의 개수일 수 밖에 없다.
        if(plist.size()<=0){
            answer = 0;
        }
        else if(plist.size()==1){
           answer = 1;;
        }
        else {
        	//peak_ary는 이제 봉우리 근처에서 가장 높은 봉우리의 index 값을 저장한 배열이다. 
        	//flag를 세우는 조건이 각 봉우리의 간격이 flag의 절대 값 보다 큰 값이 존재 할 때만 이를 세울 수 있는 것을 이용
    
        	//ex)
        	/*
        	 주어진  A를 기준으로 이를 써보면 
        	 먼저 맨 양 끝 index는  봉우리가 절 대로 될 수 없기 때문에 -1로 채워 준다.
        	[-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1];
        	 현재 주어진 A를 기준으로 봉우리가 있는 index 는 [1, 3, 5, 10]이다
        	 봉우리가 있는 영역을 ^ 표시하고 이를 나타내면 
        	[-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1];
        	     ^     ^     ^              ^
        	 그 다음 후열 부터 새로운 봉우리를 만나기 전의 봉우리가 있는 index로 이를 채워준다.
        	[-1, 1, 1, 3, 3, 5, 5, 10, 10, 10, 10, 10, -1]
        	 만약 전열 부터 새로운 봉우리를 만나는 것으로 채우게 되어도 상관은 없다.
        	[-1, 1, 1, 3, 3, 5, 5, 5, 5, 5, 10, -1]
        	
        	*/
        	int[] peak_ary = new int[A.length];
	        int peak_idx = -1;
	        peak_ary[0] = -1;
	        peak_ary[A.length-1] = -1;
	        
	        // [-1, 1, 1, 3, 3, 5, 5, 10, 10, 10, 10, 10, -1]
	        // 봉우리 사이 거리 카운팅을 위해서 생성
	        for(int i = A.length-2; i>0 ;  i--){
	            if(A[i] >A[i-1] && A[i] > A[i+1]){
	                peak_idx = i;
	            }
	            peak_ary[i] = peak_idx;
	        }
	        
	        int max_flag = -1;
	        // flag는 최대 봉우리의 수 만큼 까지만 나올 수 있기 때문에 봉우리의 수 만큼 for문을 돌려 준다.
	        for(int i = 1; i < plist.size()+1; i++){
	            // 시작 index는 항상 1로 해준다. 왜냐하면 0에서는 어짜피 봉우리가 생성 될 수 없기 때문
	        	int index = 1;
	            // flag가 몇개 꽃힐 수 있는지를 세는 변수
	            int flag_count = 0;
	            
	            //깃발을 세울 수 있는 최대 개수는 봉우리 개수에 한정 되기 때문에 다음 과 같이 while문을 돌린다.
	            //주어진 peak_ary의 개수 안에서 i만큼 거리를 벌리는 작업을 계속해서 끝까지 확인하여 flag의 최대 개수를 확인한다.
	            while(flag_count <i){
	            	//만약에 봉우리가 있다면 peak_ary[index]의 값은 -1이 아닐 것이다.
	                if(peak_ary[index] != -1){
	                	// 다음 봉우리가 존재하기 때문에 개수를 증가 시킨다.
	                    flag_count+=1;
	                    // 그리고 flag의 크기(i)만큼 지금 현재 봉우리 index에 더해 준다.
	                    // 왜냐하면 flag가 세워지는 조건이 두 봉우리의 사이의 index 차이 절대 값이 flag보다 크거나 같아야 하기 때문
	                    index = peak_ary[index] + i;
	                    // 이때 새로 초기화된 index 값이 주어진 배열의 최대 index 값보다 커지게 되면 조건을 만족 할 수 없기 때문에 while break시킨다.
	               
	                    if(index > A.length-1)
	                        break;
	                }else{
	                	// 만약 봉우리가 더이상 존재 할 수 없다면 현재까지 구한 값 중 가장 큰 값으로 answer를 갱신한다.
	                    answer=  max_flag;
	                    break;
	                }
	            }
	            max_flag = Math.max(flag_count, max_flag);
	        }
	        answer = max_flag;
        }
        System.out.println(answer);
	        
	}
}
