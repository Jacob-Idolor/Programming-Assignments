
/*
* Project #2 LinkedLists 
* File: Node.java
*  Section 15037
* Programmer: Jacob Idolor
* Date: 3/2/15
* Description: This program establishes the Node class and will be used to create nodes and linked lists.
*/
public class Node {
   private char data; 
   public  Node next; 

   public Node ( char data ,  Node next ) {
      this.data = data; 
      this.next = next;
   }//node constructor
   public Node (char data ) {
      this.data = data; 
      this.next = null; 
   }


   public char getChar() {
      return data; }//getdata 
   public Node getNext() {
      return next;
   }//get node
   public void setChar(char c) {
      data = c;}// setChar
   public void setNext(Node n) {
      next = n;}// set next
 
}//node

