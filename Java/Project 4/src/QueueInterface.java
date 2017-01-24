public interface QueueInterface {

   public class QueueException 
   extends java.lang.RuntimeException {
      public QueueException (String s) {
         super(s); 
      }
   }
   
   
   
   public int dequeue() throws QueueException;
   
   public int peek() throws QueueException; 
   
   public void enqueue(int item);
   
   public boolean isEmpty();

   
   public void dequeueAll();


}