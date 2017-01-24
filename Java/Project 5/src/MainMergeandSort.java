import java.util.*;
import java.lang.*;
public class MainMergeandSort {

   public static void main (String args[]){
   //small array
      System.out.println("Small Array before it is sorted");
      Integer [] SmallArray = new Integer[10];
      for (int i = 0; i<SmallArray.length; i++){
         SmallArray [i] = (int)(Math.random()*101);
         System.out.print(SmallArray[i] + " ");
      }
      System.out.println();
      insertionSort(SmallArray , SmallArray.length); 
      mergesort(SmallArray);
      System.out.println();
      System.out.println("Medium Array before it is sorted");
   
   //medium array 
      Integer [] MedArray = new Integer[100];
      for (int i = 0; i<MedArray.length; i++){
         MedArray [i] = (int)(Math.random()*101);
         System.out.print(MedArray[i] + " " );
      }
      System.out.println();
      insertionSort(MedArray , MedArray.length);
      mergesort(MedArray);
      System.out.println("Large Array before it is sorted");
   
   //large array
      Integer [] LargeArray = new Integer[1000]; 
      for (int i = 0; i<LargeArray.length; i++){
         LargeArray [i] = (int)(Math.random()*101);
         System.out.print(LargeArray[i] + " " );
      }
      System.out.println();
      insertionSort(LargeArray , LargeArray.length);
      mergesort(LargeArray);
   }//main

   public static <T extends Comparable<? super T>>
       void insertionSort(Integer[] theArray, int n) {
  
      int comparisons = 0; 
      int exchanges =0;
      for (int unsorted = 1; unsorted < n; ++unsorted) {
     
         Integer nextItem = theArray[unsorted];
         int loc = unsorted;
      
         while ((loc > 0) &&
           (theArray[loc-1].compareTo(nextItem) > 0)) {
        
            theArray[loc] = theArray[loc-1];
            loc--;
            comparisons++;
         }          theArray[loc] = nextItem;
         exchanges++; 
      }  // end for
      System.out.println("Array Length " + theArray.length);
      System.out.println("Comparisons " + comparisons); 
      System.out.println("Exchanges " + exchanges); 
      System.out.print("The Sorted array with insertSort: ");
      for (int i = 0; i < theArray.length; i++) {
         System.out.print(theArray[i] + " ");
      }
      System.out.println();
      System.out.println();
   }  // end insertionSort



   public static<T extends Comparable<? super T>>
       int [] mergesort(Integer[ ] theArray) {
     int [] CompareAndExchange = {0, 0}; 
   Integer[] tempArray = (Integer[])new  Integer[theArray.length];
    CompareAndExchange = mergesort(theArray, tempArray, 0, theArray.length - 1 );
    
     System.out.println("Array Length " + theArray.length);
      System.out.println("Comparisons " + CompareAndExchange[0]); 
      System.out.println("Exchanges " + CompareAndExchange[1] ); 
      System.out.print("The Sorted array with MergeSort: ");
      for (int i = 0; i < theArray.length; i++) {
         System.out.print(theArray[i] + " ");
      }
      System.out.println();
      System.out.println();
 return CompareAndExchange;
     
     
   } // end mergesort

   private static<T extends Comparable<? super T>>
        int [] merge(Integer[] theArray, Integer[] tempArray,
                   int first, int mid, int last) {
      int [] CompareAndExchange = {0,0};
       int first1 = first;    // beginning of first subarray
      int last1  = mid;      // end of first subarray
      int first2 = mid + 1;  // beginning of second subarray
      int last2  = last;     // end of second subarray
        int index = first1;    // next available location in
                         // tempArray
   
      while ((first1 <= last1) && (first2 <= last2)) {
       CompareAndExchange[0]++;
              if (theArray[first1].compareTo(theArray[first2])<0) {
            tempArray[index] = theArray[first1];
            first1++;
           
         }
         else {
         CompareAndExchange[1]++;
            tempArray[index] = theArray[first2];
            first2++;
            
         }  // end if
         index++;
      }  // end while
   
         while (first1 <= last1) {
      // Invariant: tempArray[first1..index-1] is in order
         tempArray[index] = theArray[first1];
         first1++;
         index++;
         CompareAndExchange[1]++;
      }  // end while
        while (first2 <= last2) {
      // Invariant: tempArray[first1..index-1] is in order
         tempArray[index] = theArray[first2];
         first2++;
         index++;
         CompareAndExchange[1]++;
      }  // end while
   
   
      for (index = first; index <= last; ++index) {
         theArray[index] = tempArray[index];
      }  // end for
      return CompareAndExchange;
   }  // end merge

   public static <T extends Comparable<? super T>>
      int[]  mergesort(Integer[] theArray, Integer[] tempArray, int first, int last) {
        int [] CompareAndExchange = {0,0};
        if (first < last) {
        // sort each half
         int mid = (first + last)/2;   // index of midpoint
      // sort left half theArray[first..mid]
         mergesort(theArray, tempArray, first, mid);
      // sort right half theArray[mid+1..last]
         mergesort(theArray, tempArray, mid+1, last);
      
      // merge the two halves
        CompareAndExchange = merge(theArray, tempArray, first, mid, last);
      }  // end if
     return CompareAndExchange;

   }  // end mergesort
  


}//class

