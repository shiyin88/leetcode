public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] table = new boolean[s.length() + 1];
        table[0] = true;

        for (int i = 0; i < s.length(); i++){

            if (!table[i]) continue;

            for (String str: dict){
                int leng = str.length();
                int end = i + leng;

                if (end > s.length()) continue;//adding new word cause the length > String s.length()

                if (table[end]) continue;//indicates already having word with length = end found

                if (s.substring(i, end).equals(str)){
                    table[end] = true;
                }
            }
        }

        return table[s.length()];
    }

}
