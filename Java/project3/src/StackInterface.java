public interface StackInterface {

   public class StackException 
   extends java.lang.RuntimeException {
      public StackException (String s) {
         super(s); 
      }
   }
   
   
   
   public int pop() throws StackException;
   
   public int peek() throws StackException; 
   
   public void push(int item);
   
   public boolean isEmpty();

   
   public void popAll();


}