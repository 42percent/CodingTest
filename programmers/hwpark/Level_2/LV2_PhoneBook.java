import java.util.List;
import java.util.Arrays;

class Solution {

		/**
	 *  https://programmers.co.kr/learn/courses/30/lessons/42577
	 * @author H.W.PARK
	 * @return  
	 */
	 
    public boolean solution(String[] phone_book) {
         boolean answer = true;
	        
	       Loop1:
	       for(int i = 0; i < phone_book.length-1; i++) {
	    	   Loop2:
	    	   for(int j = i+1; j < phone_book.length; j++) {
	    		   if(phone_book[j].startsWith(phone_book[i])){
	    			   answer = false; 
                       break Loop1;
	    		   }
                   if(phone_book[i].startsWith(phone_book[j])){
                       answer = false;
                       break Loop1;
                   }
                   
	    	   }
		        
	       }
	       
	        return answer;
    }
}
