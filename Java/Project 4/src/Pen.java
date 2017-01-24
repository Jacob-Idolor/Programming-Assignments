public class Pen {
   private String color;// user enter the pen color 
   private int inkLeft;// out of 100 each time the method write is invoked inkleft minus 1
   private boolean PenCap;//if it is true then pen cap is on false means pen cap off 

   public Pen(){
      color = "black"; 
      inkLeft = 100;
      PenCap = true;
      Ball ballpoint = new Ball( 1.0, "black");// pen has a ball called ballpoint with radius equal to one  
   
   }//no arg 

   public Pen(String Pencolor ,  int inkInPen ){
      color = Pencolor; 
      inkLeft = inkInPen; 
      PenCap = true; 
      Ball ballpoint = new Ball( 1.0 , Pencolor); //pen has a ball called ballpoint with radius  equal to one (small ball point pen) 
   }//arg constructor

   public void write(){
      if (isEmpty() == true){
         System.out.println("Pen is out of ink");
      }
      else if (CheckCap() == true){
         System.out.println("The pen cap is closed"); 
      } 
      else {
         PenCap = false;
         inkLeft--;
      }
   }//write method uses ink check the pen cap also how much ink is left if either one is invlaid print what has happened 

   public boolean CheckCap() {
      if (PenCap == true)
         return true; 
      else
         return false; 
   }//checkcap
   
   
   public boolean isEmpty(){
      if (inkLeft != 0) 
         return false;
      else
         return true;  
   }//isempty
   
   public int CheckInk() {
      return inkLeft;
   
   }//check ink
   
   public void open(){
   
   PenCap = false; 
   
   
   }//opens cap
   
}//pen class