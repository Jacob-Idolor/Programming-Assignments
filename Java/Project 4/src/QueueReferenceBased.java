/*
* Project #4 Queue
* File: QueueReferenceBased.java
*  Section 15037
* Programmer: Jacob Idolor
* Date: 3/30/15
* Description: This class establishes a refrence based queue providing the ADT methods that the user will use.
*/


import java.util.*;
import java.lang.*;


public class QueueReferenceBased 
               implements QueueInterface  {
//adt for the stack it is a linked list
   private Node first; 
   private Node last;
   private Node temp;
   private int size;
   public QueueReferenceBased(){
      first = null;
      last = null;
   }

  
   public int dequeue() throws QueueException {
      if (!isEmpty()) {
         Node temp = first;  
         first = first.next;
         first = first ; 
         size--;
         return temp.get(); 
      }
      else{ 
         throw new QueueException("QueueException on " + "enqueue: queue empty"); 
      } //end if 
   }//end dequeue
   public int peek() throws QueueException{
      if (!isEmpty()){
         return first.get();
      }
      else {
         throw new QueueException("QueueException on " + "peek: queue empty"); 
      }
     
   } 
  
  
   public void enqueue(int newItem){
      if(isEmpty()){
         first = new Node(newItem , last);
         last = first;
         size++;
      }
      else {
         temp = new Node(newItem);
         last.next = temp;
         last = temp;
         size++;
      }
      
   }//dequeue
  
  
   public boolean isEmpty(){
      return first == null; 
   }//isempty() 
  
  
  
   public void dequeueAll(){
      first = null; 
   }// end dequeueall 
  
  
   public int size(){
      return size; 
   }//size
}//class