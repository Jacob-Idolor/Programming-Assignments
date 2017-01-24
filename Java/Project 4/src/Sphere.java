


import java.util.* ;

public class Sphere {
   private double radius; 
   private double DefaultRadius = 1.0; 

   public Sphere(){
      setRadius(DefaultRadius);
   }//no arg constructor

   public Sphere(double Radius) { 
      setRadius(Radius); 
   }//arg constructor

   public void setRadius(double newRadius){
      if (newRadius >= 0.0) { 
         radius = newRadius; 
      }//if
   
   }//setradius

   public double getRadius(){ 
      return radius; 
   } //getradius

   public double diameter(){
      return 2.0 * radius; 
   }//diameter

   public double area(){ 
      return 4.0 * Math.PI * radius * radius; 
   }//area 

   public double circumference(){
      return Math.PI * diameter(); 
   }//circumference 


   public void displayStatistics(){
   
      System.out.println("\nRadius = " + getRadius() +
         "\nDiameter = " + diameter() +
         "\nCircumference = " + circumference() + 
         "\nArea = " + area());
   }//display
}// sphere class