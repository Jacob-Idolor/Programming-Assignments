
import java.util.*;
import java.lang.*;


public class StackReferenceBased 
               implements StackInterface  {
//adt for the stack it is a linked list
   private Node top;
   private int size;
   public StackReferenceBased(){
      top = null;
      
   }

  
   public int pop() throws StackException {
      if (!isEmpty()) {
         Node temp = top;  
         top = top.next; 
         size--;
         return temp.get(); 
      }
      else{ 
         throw new StackException("StackException on " + "pop: stack empty"); 
      } //end if 
   }//end pop
   public int peek() throws StackException{
      if (!isEmpty()){
         return top.get();
      }
      else {
         throw new StackException("StackException on " + "peek: stack empty"); 
      }
     
   } 
  
  
   public void push(int newItem){
      top = new Node(newItem , top );
      size++;
   }//push
  
  
   public boolean isEmpty(){
      return top == null; 
   }//isempty() 
  
  
  
   public void popAll(){
      top = null; 
   }// end popall 
  
  
   public int size(){
      return size; 
   }//size
}//class