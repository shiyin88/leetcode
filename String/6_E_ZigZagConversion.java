/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
Hide Tags String

参考至：http://blog.csdn.net/linhuanmars/article/details/21145039
第一行和最后一行中每两个的相隔数为size = 2 * nRows - 2
第二行和倒数第二行之间的相隔数为 每个char的index + size - 2 * 行数的index，即j + size - 2*i

注意edge case：
比如，当nRows = 1，返回 s
由于在第二个for 循环中j+=0，即永远挑不出第二个loop
**/
public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows < 1){
            return s;
        }
        if (nRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();

        int size = 2 * nRows - 2;
        //scan every row
        for (int i = 0; i < nRows; i++){
            //scan chars in every row
            for (int j = i; j < s.length(); j += size){
                sb.append(s.charAt(j));
                if (i != 0 && i != nRows - 1 && j+size-2*i < s.length()){
                    sb.append(s.charAt(j+size-2*i));
                }
            }
        }
        return sb.toString();
    }
}
