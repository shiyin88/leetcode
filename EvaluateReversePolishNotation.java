/** author April L.
*
*
*/

public int evalReverse(String[] strInputs){

    Stack<Integer> stackInputs = new Stack<Integer>();
    for (int i = 0; i < strInputs.length(); i++){
      int sum = 0;
      if (strInputs[i] == '/' || strInputs[i] == '+' ||
          strInputs[i] == '-' || strInputs[i] == '*'){
            int num1 = stackInputs.pop();
            if(stackInputs.pop() != null){
              int num2 = stackInputs.pop();
              sum = num1 + strInputs[i] + num2;
            }else if (form != 0){
              form = form + strInputs[i] + num1;
            }
      }
    }

    return form;
}
