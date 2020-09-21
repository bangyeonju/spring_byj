package com.spring.sample1;

public class CircleMain {
   public static void main(String[] args) {
      double radius = 10.0;
      Point point = new Point();
      point.setXpos(3.0);
      point.setYpos(4.0);
      
      Circle circle = new Circle(radius,point);
      circle.display();
   }
   
}