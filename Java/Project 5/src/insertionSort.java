public class insertionSort {

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




}//class 