import java.util.*; 
import java.lang.*; 

public class InfixMain { 

   public static void main (String [] args) {
   
      Scanner input = new Scanner(System.in);
   
      System.out.print("Please enter your postfix statement no spaces "); 
   
      String expression = input.nextLine();
   
      StackReferenceBased stack = new StackReferenceBased();
       
      for (int i = 0 ; i < expression.length(); i++) {
       
         char value = expression.charAt(i); 
         int operandOne = 0;
         int operandTwo = 0; 
         int result = 0; 
         
         if (Character.isDigit(expression.charAt(i))){
            int number = Character.getNumericValue(value);
            stack.push(number);
         }
         else 
            switch (value)
            {
               case('+'):
                  operandOne = stack.pop();
                  operandTwo = stack.pop();
                  result = operandOne+operandTwo; 
                  stack.push(result);
                  break; 
               
               case('-'): 
                  operandOne = stack.pop();
                  operandTwo = stack.pop();
                  result = operandOne-operandTwo; 
                  stack.push(result);
                  break;
            
               case('*'):
                  operandOne = stack.pop();
                  operandTwo = stack.pop();
                  result = operandOne*operandTwo; 
                  stack.push(result);
                  break;
            
               case('/'):
                  operandOne = stack.pop();
                  operandTwo = stack.pop();
                  result = operandOne/operandTwo; 
                  stack.push(result);
                  break;
               
               case('%'): 
                  operandOne = stack.pop();
                  operandTwo = stack.pop();
                  result = operandOne%operandTwo; 
                  stack.push(result);
                  break;
                
            }//switch 
         
      
      }//for loop 
      System.out.println(stack.peek());
   }//main 


}//InfixMain