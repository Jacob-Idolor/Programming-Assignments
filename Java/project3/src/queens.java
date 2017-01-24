//note to self false means that there is a queen true means that there is no queen

public class queens{
   private int[][] board = new int[8][8] ;
   private int queen = 1 ;
   private int empty = 0 ;
   private int queenCount = 0; 
   private int begin = 0; 
  
 
   public queens(int[][] array){
      board = array;
      
      
     
      placeQueen(begin);
      printBoard();
   }//arg 

   public boolean placeQueen( int column){//placequeens this is the recursion method 
      if (column > 7   ) {
         return true;  // base case
      }
      else {
         boolean queenPlaced = false;
         int row =0;  // number of square in column
      
         while ( !queenPlaced && (row <= 7) )  {
         // if square can be attacked
            if (isUnderAttack(row, column)) {
               ++row;  // consider next square in column
            } // end if
            else { // place queen and consider next column
               setQueen(row, column);
               queenPlaced = placeQueen(column+1);
            // if no queen is possible in next column,
               if (!queenPlaced) {
               // backtrack: remove queen placed earlier
               // and try next square in column
                  removeQueen(row, column);
                  ++row;
               } // end if
            } // end if
         } // end while
         return queenPlaced;
      } // end if
   
   
   
   }//place queen 
  
   public boolean isUnderAttack(int row , int column){
      boolean result = false;
     
    //check row and column    
      if (result == false ) {
         for (int i = 0; i < 8; i++) {
            if (board[row][i]== queen) {
               return true;
            }
            if (board[i][column]== queen) {
               return true;
            }
         }
         result = false;
      }
   
   //check diag up left
      int i = row;
      int j = column; 
      if (result == false) {
         while((i!=-1 || j!=-1)&& j>=0 && i>= 0){
            if (board[i][j] == queen) {
               result = true;
               i= -1;
               j= -1; 
            }
            else{ 
               result = false; 
               i--;
               j--;
            }
         }
      }
      
      //check diag min
      i = row; 
      j = column; 
      if (result == false){
         while((i!=-1 || j!=-1)&& j>=0 && i<8){
            if (board[i][j] == queen) {
               result = true;
               i= -1;
               j= -1; 
            }
            else{ 
               result = false; 
               i++;
               j--;
            }
         }
      }
      row = i; 
      column = j;
      
      return result;
   
   }  // end isUnderAttack
   
      
      
   
   
   
   
   
   
   
   
   
   
   public void printBoard(){
      for(int i = 0; i < 8; i++)
      {
         for(int j = 0; j < 8; j++)
         {
            System.out.printf("%5d ", board[i][j]);
         }
         System.out.println();
      }      
   }//
   
   private void   setQueen(int i , int j ) {
   
   
      board[i][j]= queen; 
     
   
   }
   private void  removeQueen (int i , int j ) {
      board[i][j]= empty; 
   }
    
   
}//class