/**
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

Hide Tags Math String
**/
public class Solution {
    public static String addBinary(String a, String b) {

        int la = a.length() - 1;
        int lb = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        //put carry >= 0 to avoid having an if statement outside of the while loop
        //see if carry is greater and equal to 1 or not
        while (la >= 0 || lb >= 0 || carry > 0){
        	//the condition is OR. To meet all the requirements, shall consider
        	//pointer moves to the end of one string
        	int na = la >= 0 ? a.charAt(la--) - '0' : 0;
        	int nb = lb >= 0 ? b.charAt(lb--) - '0' : 0;
        	int digit = (na + nb + carry) % 2;
        	carry = (na + nb + carry) / 2;

        	sb.insert(0, digit);
        }
        return sb.toString();
    }
}
