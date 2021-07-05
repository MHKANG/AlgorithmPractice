package Programmers;

import java.util.*;

public class PRO_오픈채팅방 {
	public static String[] solution(String[] record) {
        
        HashMap<String, String>uMap = new HashMap<>();
        
        List<String> temp = new ArrayList<>();
        
        for(int i = 0; i < record.length; i++){
            String[] rec = record[i].split(" ");
            if(rec[0].equals("Enter") ||rec[0].equals("Change")){
                uMap.put(rec[1], rec[2]);
            }
        }
        for(int i = 0; i < record.length; i++){
            String[] rec = record[i].split(" ");
            
            if(rec[0].equals("Enter")){
                temp.add(uMap.get(rec[1])+"님이 들어왔습니다.");
            }else if(rec[0].equals("Leave")){
                temp.add(uMap.get(rec[1])+"님이 나갔습니다.");
            }
        }
        String[]answer = temp.toArray(new String[temp.size()]);
        
        return answer;
    }
	public static void main(String[] args) {
		String[]record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}
}
