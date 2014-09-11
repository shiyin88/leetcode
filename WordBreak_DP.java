public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {

      boolean[] table = new boolean[s.length() + 1];
      table[0] = true;//initial state

      for (int i = 0; i < s.length(); i++){

        if (!table[i]){
          continue;
        }

        for (String str: dict){
          int end = i + str.length();
          if (end > s.length()){
            continue;
          }

          if(tabke[end]) continue;

          if (s.substring(i, end).equals(str)){
            table[end] = true;
          }
        }
       }
       return table[s.length()];
    }

}
