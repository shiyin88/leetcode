/**Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
Hide Tags Stack String

 * 这道题主要是直到unix的操作，并且利用stack来取得路径。
 * ".." 意味着返回上一级。如果字符中出现".."则不保存当前对象。 ex. a/./b/..
 *      现阶段为路径b。出现".."返回b的上一级，则把b从stack中删除。
 * "." 意味着同级。即，保留路径，把字符加入stack中。
 * 用path.split("/"),把所有的字符生成一个String的数组，其中"/"的字符用""(空格)来替代
 * 即数组里面包含"..", ".","空格" 和字母。
 *
 * 1. 遍历String[] elements,判断当前对象为"..", ".", ""或是字母。把字母放入stack
 * 2. 遍历stack内的对象，并且创建新的路径。
 * 3. 由于在创建路径的时候，是把stack.pop() + "/"在最后都加个"/"，然后简化后的路径末尾是不加"/"
 *    所以通过result.substring去掉末尾的"/"**/
public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] elements = path.split("/");
        for (String str : elements){
            if (str.equals("..")){
                if (stack.size() > 0){
                    stack.pop();
                }
            }else if (!str.equals(".") && !str.equals("")){
                stack.push(str);
            }
        }
        //如果用stack.pop的话，是会先pop尾，即所得结果是相反的。
        //所以只能用for循环输出
        String result = "/";
        for (int i = 0; i < stack.size(); i++){
            result += stack.get(i) + "/";
        }

        if (result.length() > 1){
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}
