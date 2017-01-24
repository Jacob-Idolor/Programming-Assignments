/*
* Project #6  Binary Search tree
* File: treeIterator.java 
*  Section 15037
* Programmer: Jacob Idolor
* Date: 5/12/15
* Description: This is the methods that are used to navigate the arryalist in certain order depending on what is called. postorder preorder and inorder methods are all contained in here 
*/

import java.util.*;
public class treeIterator {
   private int index = 0; 
   private boolean Printed= false; 
   protected  ArrayList<TreeNode> PrintTreeArray;
   public treeIterator(ArrayList<TreeNode> treeArray){
      index = 0;
      Printed = false; 
   
      PrintTreeArray = treeArray; 
   }

  
   public void preorder(int root){
      if (root == -1) 
         return;
         
      PrintNode(root);
      
      preorder(PrintTreeArray.get(root).leftchild);
      
      preorder(PrintTreeArray.get(root).rightchild); 
   }//pre order 
   public void inorder(int root){
   
      if (root == -1) 
         return;
   
      inorder(PrintTreeArray.get(root).leftchild);
      
      
      PrintNode(root);
      
      inorder(PrintTreeArray.get(root).rightchild); 
   }//inorder
   public void postorder(int root){
   
      if (root == -1) 
         return;
   
      postorder(PrintTreeArray.get(root).leftchild);
   
      postorder(PrintTreeArray.get(root).rightchild);
   
      PrintNode(root); 
   }//postorder 



   public void PrintNode(int nodePrint){
   
      TreeNode ItemPrint = PrintTreeArray.get(nodePrint); 
      System.out.println(ItemPrint.get()); 
   
   
   }










}//treeiterator