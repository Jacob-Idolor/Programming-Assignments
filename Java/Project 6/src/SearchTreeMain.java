/*
* Project #6  Binary Search tree
* File: SearchTreeMain.java 
*  Section 15037
* Programmer: Jacob Idolor
* Date: 5/12/15
* Description: This is the main method for the binary search tree it will ask the user to input values then sort them into 
an arraylist of nodes. once the user has finished entering the values the user will need to enter -1 in order in order to end the loop 
it will then display the post pre and inorder iterations of said binarytree
it will also ask the user if they would like to delete a value if so then it will delete the value and show the new iteration of the arrays. 

*/
import java.util.*;
public class SearchTreeMain {
public static void main (String [] arg) {
Scanner input = new Scanner(System.in);
BinarySearchTreeADT thug = new BinarySearchTreeADT(); 
System.out.println("Please enter the values of your tree the first one entered is your root");
int value = input.nextInt(); 
while (value!=-1) { 
thug.add(value);
value = input.nextInt(); 
}

System.out.println("Preorder array is equal to."); 
thug.Preorder();
System.out.println("Inorder array is equal to."); 
thug.Inorder();
System.out.println("Postorder array is equal to."); 
thug.PostOrder();

System.out.println("Would you like to delete a value? so please enter it now. If not then enter -1"); 
value = input.nextInt(); 
if (value == -1){
   System.out.println("End of Program "); 
   } 
thug.Remove(value);
System.out.println("Preorder array after remove is equal to."); 
thug.Preorder();
System.out.println("Inorder array after remove is equal to."); 
thug.Inorder();
System.out.println("Postorder array after remove is equal to."); 
thug.PostOrder();

}//main
}//class5

