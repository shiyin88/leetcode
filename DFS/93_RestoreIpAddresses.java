public class Solution {
    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<String>();
        List<String> path = new ArrayList<String>();
        /**
         * 提前规范输入的长度符合IP规范，即[4,12]**/
        if (s.length() > 12 || s.length() < 4) return result;

        helper(s, result, path, 0);
        return result;
    }

    public void helper(String s, List<String> result, List<String> path, int pos){
        //when path has four parts (IP consists of 4 parts)
        if (path.size() == 4 && pos == s.length()){//position point to the last digit in the string, and after pos + 1, pos = 6
            result.add(convertToIP(path));
            return;
        }

        for (int i = pos; i < s.length(); i++){
            String prefix = s.substring(pos, i + 1);//the input string can be larger than Integer.
            if (Long.parseLong(prefix) < 0 || Long.parseLong(prefix) > 255 ||
                prefix.charAt(0) == '0' && prefix.length() != 1){
                    continue;
            }
            path.add(prefix);
            helper(s, result, path, i + 1);
            path.remove(path.size() - 1);
        }

    }

    public String convertToIP(List<String> path){
        String ip = "";
        for (String str : path){
            ip += str + ".";
        }
        return ip.substring(0, ip.length() - 1);
    }





}
