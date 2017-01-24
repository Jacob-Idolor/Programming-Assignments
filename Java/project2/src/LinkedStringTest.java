/*
* Project #2 LinkedLists 
* File: Node.java
*  Section 15037
* Programmer: Jacob Idolor
* Date: 3/2/15
* Description: This program is the main method for the linkedstring ADT 
*/




public class LinkedStringTest {
   public static void main(String[] args) {
   
      /********************** Test *********************
       * Test public LinkedString(char[] value) constructor
       * and public char charAt() methods
       */
      char[] array = {'H', 'e', 'l', 'l', 'o', ' ', 'T', 'h', 'e', 'r', 'e',
         ' ', 'W', 'o', 'r', 'l', 'd'};
      LinkedString s1 = new LinkedString(array);
      for(int i = 0 ; i < s1.length(); i++) {
         System.out.print(s1.charAt(i));
      }
      System.out.println();
             
      /********************** Test *********************
       * Test public LindedString(String str) constructor
       * and public char charAt() methods.
       */
      LinkedString s2 = new LinkedString("Welcome to Java!");
      for(int i = 0 ; i < s2.length(); i++) {
         System.out.print(s2.charAt(i));
      }
      System.out.println();
    
       // Test public LinkedString substring(int beginIndex, int endIndex)
      // where substring should return the entire string as a new 
      // LinkedString.
      System.out.print("The characters from index 0 to 16 in s1 are: ");
      LinkedString s3 = s1.substring(0, 16);
      for(int i = 0; i < s3.length(); i++) {
         System.out.print(s3.charAt(i));
      }
      System.out.println();
      // Test public LinkedString substring(int beginIndex, int endIndex)
      // where substring should return all characters from beginIndex 4 to
      // endIndex 10 (7 characters).  Should print "o There"
      System.out.print("The characters from index 4 to 10 in s1 are: ");
      s3 = s1.substring(4, 10);
      for(int i = 0; i < s3.length(); i++) {
         System.out.print(s3.charAt(i));
      }
      System.out.println();
      
      /********************** Test *********************
       * Test public LinkedString concat(String str)
       * Should print "Welcome to Java! And have a nice day!"
       */
   
      LinkedString s4 = s2.concat(new LinkedString(" And have a nice day!"));
      for(int i = 0; i < s4.length(); i++) {
         System.out.print(s4.charAt(i));
      }
      System.out.println();
      
     /*********Test for is empty*****/
   
      LinkedString s5 = new LinkedString();
      System.out.println( s5.isEmpty()); 
   }
}

