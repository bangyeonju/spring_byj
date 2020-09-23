package com.spring.Basic;

public class CircleImpl implements Circle{

   
   Shape pointx;
   int x;
   int y;
   int radius;
   
   public CircleImpl() {
      
      System.out.println("CircleImpl() 持失切");
      
   }//持失切
   
   public Shape getPointx() {
      return pointx;
   }

   public void setPointx(Shape pointx) {
      this.pointx = pointx;
      System.out.println("setPointx(Shape pointx) ");
   }

   
   
   @Override
   public int getX() {
      return x;
   }

   @Override
   public int getY() {
      return y;
   }

   @Override
   public String make() {
      return pointx.make();
   }

   
   
   
   
   
   
   
}