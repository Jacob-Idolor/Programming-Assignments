/*
* Project #6  Binary Search tree
* File: TreeNode.java 
*  Section 15037
* Programmer: Jacob Idolor
* Date: 5/12/15
* Description: This program contains the methods that makes nodes that will be out into the arraylist. they contain an pointer to the index of a nodes children
 
*/

public class TreeNode {
   public Integer item;
   public int leftchild;
   public int rightchild;
   
   public TreeNode(Integer newItem) {
   // Initializes tree node with item and no children.
      item = newItem;
      leftchild  = -1;
      rightchild = -1;
   }
   public TreeNode (){
      item = null;
      leftchild = -1;
      rightchild= -1;
   
   }
   public TreeNode(Integer newItem, int left, int right) {
      item = newItem;
      leftchild = left;
      rightchild = right;
   }
   
   public Integer get(){
      return item; 
   }// returns value 
   
   public int leftchild() {
      return leftchild;}
   public int rightchild() {
      return rightchild;}
}