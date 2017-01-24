public class TestPen {
   public static void main (String [] args) {
   
      Pen pen = new Pen("blue" , 100); 
      pen.open();//opens the cap sets pencap to false 
      pen.write(); //lowers the ink and check for ink and cap 
      System.out.println(pen.CheckInk());//seperate method to check ink level
      System.out.println(pen.isEmpty());// checks if the pen is empty 
      System.out.println(pen.CheckCap());// checks to see if the cap is on 
   
   //for loop uses the pen until it is out of ink 
      for (int i = 0 ; i<100; i++) {
         pen.write();
      }
      System.out.println(pen.CheckInk());// should return 0 now that pen is empty 
      System.out.println(pen.isEmpty());// should return true
   }//main 
}//testpen