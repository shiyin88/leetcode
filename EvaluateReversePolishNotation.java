
public class Solution {
  public int evalRPN(String[] tokens){
      int returnedValue = 0;
      String operators = "+-*/";
      Stack<String> stackInputs = new Stack<String>();
      for (int i = 0; i < tokens.length; i++){
        if (!operators.contains(tokens[i])){
             stackInputs.push (tokens[i]);
        }else{
              int num1 = Integer.valueOf(stackInputs.pop());
              int num2 = Integer.valueOf(stackInputs.pop());
              int index = operators.indexOf(tokens[i]);
              switch (index){
                  case 0:
                      stackInputs.push(String.valueOf(num1 + num2));
                      break;
                  case 1:
                      stackInputs.push(String.valueOf(num2 - num1));
                      break;
                  case 2:
                      stackInputs.push(String.valueOf(num2 * num1));
                      break;
                  case 3:
                      stackInputs.push(String.valueOf(num2 / num1));
                      break;
              }
        }
      }

      returnedValue = Integer.valueOf(stackInputs.pop());
      return returnedValue;
  }
}
