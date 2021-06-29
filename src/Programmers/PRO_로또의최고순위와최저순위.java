package Programmers;

public class PRO_로또의최고순위와최저순위 {
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int maxCount = 0;
        int rowCount = 6;
        int zeroCount = 0;
        int sameCount = 0;
        boolean[] check = new boolean[6];
        
        for(int i = 0; i < lottos.length; i ++){
            if(lottos[i] == 0){
                zeroCount++;
            }
        }
        for(int i = 0 ; i < lottos.length; i ++){
            for(int j = 0; j < win_nums.length; j++){
                if(!check[i] && lottos[i] == win_nums[j]){
                    
                    check[i] = true;
                }
            }
        }
        for(int i = 0; i < check.length; i++){
            if(check[i])
                sameCount++;
        }
        
        if(zeroCount == 6){
            rowCount = 6;
            maxCount = 1;
        }else if(sameCount == 0){
            rowCount = 6;
            maxCount = 6;
        }else{
            rowCount = 7-sameCount;
            maxCount = 7-(sameCount + zeroCount);
        }
        answer[0] = maxCount;
        answer[1] = rowCount;
        return answer;
    }
}
