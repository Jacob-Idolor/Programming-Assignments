/*
* Project #6  Binary Search tree
* File: BinarySearchTreeADT.java 
*  Section 15037
* Programmer: Jacob Idolor
* Date: 5/12/15
* Description: This contains alll the methods used to add and remove a value from an arraylist
 it also calls to the tree iterator method in order to perform the traversals
 */
import java.util.*;
public class BinarySearchTreeADT {
   private int counter; 
   private int height; 
   private int index; 
   boolean sucess = false; 
   public BinarySearchTreeADT(){
      treeArray = new ArrayList<TreeNode>();
      root = -1;
   }//no arg constructor 
 
   protected ArrayList<TreeNode> treeArray;
   protected ArrayList<TreeNode> TempArray;
   protected int root; // index of tree's root
   protected int free; // index of next unused array
                        // location


   public void add(int item){
   
      TreeNode NODE = new TreeNode(item); 
      
      if (treeArray.size()==0){
         root = 0; 
         treeArray.add(NODE);
         free = 0;
          
      }//if array is empty
      else 
      {
      
         while (!sucess)
         {
         
            if (treeArray.size()<index)
               index = free-2; 
         
            if (item<treeArray.get(index).get())
            {
               if (treeArray.get(index).leftchild==-1)  {  
                  treeArray.add(NODE);
                  treeArray.get(index).leftchild=treeArray.indexOf(NODE);
                 
                  sucess= true; 
               }
               else       
                  index = treeArray.get(index).leftchild; 
               
            }
               
            else            
               if (treeArray.get(index).rightchild==-1)
               {
                  treeArray.add(NODE);
                  treeArray.get(index).rightchild=treeArray.indexOf(NODE);
                  sucess = true; 
                  
               }        
               else 
                  index = treeArray.get(index).rightchild;
               
         }      
      }
      sucess = false; 
      index = 0; 
      free++;
   }//add
            
            
               
        
   
   public void Remove(int value){
      for (int i = 0 ; i < treeArray.size(); i++) {
         if (treeArray.get(i).get() == value ) 
            treeArray.remove(i);
      }
      TempArray = new ArrayList<TreeNode>(); 
      BinarySearchTreeADT Temp = new BinarySearchTreeADT();
      for (int i = 0; i < treeArray.size(); i++) {
      
         Temp.add((treeArray.get(i).get()));
      }
      treeArray = Temp.treeArray;  
   }//remove 
   

   public int TreeSize(){
   
      return treeArray.size(); 
   
   }//get size of tree aka how many values 



   public void PrintTree(){
      for (int i = 0; i< treeArray.size(); i++){
         TreeNode valuee =  treeArray.get(i);
         System.out.print(valuee.get());
      }   
   }
   public void Preorder(){
      treeIterator treePrint = new treeIterator(treeArray);
      treePrint.preorder(root);  
   }   
   public void PostOrder(){
      treeIterator treePrint = new treeIterator(treeArray);
      treePrint.postorder(root);  
   }
   public void Inorder(){
      treeIterator treePrint = new treeIterator(treeArray);
      treePrint.inorder(root);  
   }

}//ADTbinarytree

