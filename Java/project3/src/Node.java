
/*
* Project #2 LinkedLists 
* File: Node.java
*  Section 15037
* Programmer: Jacob Idolor
* Date: 3/2/15
* Description: This program establishes the Node class and will be used to create nodes and linked lists.
*/
public class Node {
   private int item; 
   public  Node next; 

   public Node ( int item ,  Node next ) {
      this.item = item; 
      this.next = next;
   }//node constructor
   public Node (int data ) {
      this.item = data; 
      this.next = null; 
   }


   public int get() {
      return item; }//getdata 
   public Node getNext() {
      return next;
   }//get node
   public void set(int c) {
      item = c;}// setobject
   public void setNext(Node n) {
      next = n;}// set next
 
}//node

