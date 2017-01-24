public class Ball extends Sphere { 
   private String name; // ball name for example ball point
   
   
   public Ball(){
      setName("unknown"); 
   }//default constructor
   
   
   public Ball(double Radius, String BallName){ 
      super(Radius); 
      setName(BallName); 
   }//constructor
   
   public String getName(){
   
      return name; 
   }//getname 
   
   public void setName(String newName){
      name = newName;
   } //setName
   
   public void resetBall(double newRadius, String newName) {
      setRadius(newRadius); 
      setName(newName);
   }//reset
   
   public void displayStatistics() {
      System.out.println("\nStatisitcs = " + name); 
      super.displayStatistics();
   }//displaystats
}//ball class
   
   
   
   
