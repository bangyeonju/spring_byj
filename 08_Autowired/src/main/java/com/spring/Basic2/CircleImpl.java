package com.spring.Basic2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myCircleImpl")//객체만드는작업.
public class CircleImpl implements Circle{

   
	@Autowired
	@Qualifier("PointX")//참조변수ㅡ를넣는다..?
   Shape pointx;
   int x;
   int y;
   int radius;
   
   public CircleImpl() {
      System.out.println("CircleImpl() 생성자");
      
   }//생성자
   
   public Shape getPointx() {
      return pointx;
   }

//   public void setPointx(Shape pointx) {
//      this.pointx = pointx;
//      System.out.println("setPointx(Shape pointx) ");
//   }

   
   
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