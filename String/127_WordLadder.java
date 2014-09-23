/** Use BFS to search the shortest path to the destination. Use BFS to reach the shortest
* path when first get the destination word.
* two loops: the outer loop used to loop through each letter in the beginning word
*            inner loop used to loop through 26 letters and replace one to the start
*     letter. And if the new created word is in the dict, we store the new word in the
*     queue. Store the step numbers in the other queue.
* Return condition: when the poped word from the queue = the end word
**/
public class Solution {

    	public static int ladderLength(String start, String end, Set<String> dict) {

    		String curWord = null;
    		int curStep = 0;
        if (dict.size() == 0){
          return 0;
        }

        Queue<String> wordQueue = new LinkedList<String>();
        Queue<Integer> distanceQueue = new LinkedList<Integer>();

        wordQueue.add(start);
        distanceQueue.add(1);

        while(!wordQueue.isEmpty()){
	    	  curWord = wordQueue.remove();
	        curStep = distanceQueue.remove();

	         //ending condition: the first found end word has the shorthest
          //path to start word
  	      if (curWord.equals(end)){
                return curStep;
  	      }

          for (int i = 0; i < curWord.length(); i++){

            char[] letters = curWord.toCharArray();//convert to char array to
            //replace a letter to the new letter
            for (char k = 'a'; k <= 'z'; k++){
	              letters[i] = k;
	              String newWord = new String(letters);//convert char array to string

	              if (dict.contains(newWord) && !newWord.equals(curWord)){
	                wordQueue.add(newWord);
	                distanceQueue.add(curStep + 1);
	                dict.remove(newWord); //avoid repetitive
              }

            }
          }

        }
        return 0;

	}
}
