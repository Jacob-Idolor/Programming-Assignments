public class QueueTest {

   public static void main (String [] args) {
      QueueReferenceBased queue = new QueueReferenceBased();
      
      System.out.println(queue.isEmpty());// should return true 
      queue.enqueue(1); //[1]
      queue.enqueue(2);//[1,2]
      queue.enqueue(3);//[1,2,3]
      queue.dequeue();//[2,3]
      System.out.println(queue.isEmpty());//should return false 
      System.out.println(queue.peek());// should show two 
      queue.dequeueAll();//should delete list 
      System.out.println(queue.isEmpty());// should return true if dequeue all worked
   }
}