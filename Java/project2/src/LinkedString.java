import java.util.*;

/*
* Project #2 LinkedLists 
* File: Node.java
*  Section 15037
* Programmer: Jacob Idolor
* Date: 3/2/15
* Description: This program is the main ADT for the program linkedlists holds all the methods
*/


public class LinkedString  {
   private int numCount; 
   private Node head; 
   private Node tail; 
   
   /*no arg constructor*/
   public LinkedString(){
      head = null; 
      numCount = 0;
   }

   
   
   public LinkedString(char[] value){
      head = new Node(value[0]);
      
      Node next;
      
      Node curr = head; 
      
      numCount ++; 
      
      for (int i = 1;  i < value.length ; i++) {
         next = new Node(value[i]); 
         curr.next = next; 
         curr = next; 
         numCount++ ;
      
      }//for loop
      if (curr.next == null){
         curr= tail;
      }
   
   }
   
   
   
   public  LinkedString(String original){
   
      char array[] = original.toCharArray();
   
      head = new Node(array[0]);
      
      Node next;
      
      Node curr = head; 
      
      numCount ++; 
      
      for (int i = 1;  i < array.length ; i++) {
         next = new Node(array[i]); 
         curr.next = next; 
         curr = next; 
         numCount++ ;
      }
              
      if (curr.next == null){
         curr= tail;
      }
   
   
   }  

   
   
   public char charAt(int index) {
      Node curr = head; 
      for ( int i=0 ; i <index; i++ ){ 
         
         
         curr = curr.next;
         
      }
      return curr.getChar();
   }
   
   
  
   
  
  
   public boolean isEmpty(){
   
      if (numCount == 0)
         return true; 
      else 
         return false; 
   }// boolean is empty 
 
  
  
  
  
  
   public LinkedString concat(LinkedString str){
      char[] concat = new char[(length() + str.length())];
      for ( int i = 0 ; i<length(); i++)
      {
       
         concat[i] = charAt(i);
         
      }// for loop
      
      
      
      int lengthcount = length(); 
      for ( int i = 0; i<str.length(); i++){ 
         concat[lengthcount] = str.charAt(i);
         lengthcount++; 
      }//for loop
      
      
      LinkedString concatLists = new LinkedString(concat); 
   
   
      return concatLists;
       
   
   }
  
 
  
  
   public int length(){
     
      return numCount; 
   
   }
 
 
 
 
 
   public LinkedString substring(int beginIndex, int endIndex){ 
      int sublength =  (endIndex - beginIndex) +1;
      
      char[]  Array = new char[sublength];
         
      int counterArray = 0; 
      for (int sublocation = beginIndex ; sublocation <= endIndex ; sublocation++){
         Array[counterArray] = charAt(sublocation);
         counterArray++;
      }
      LinkedString sub = new LinkedString(Array);
         
      return sub; 
         
   }



}//linked string class 
