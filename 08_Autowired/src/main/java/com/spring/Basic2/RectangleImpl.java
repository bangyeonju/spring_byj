package com.spring.Basic2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myRectangleImpl")
public class RectangleImpl implements Rectangle{
	@Autowired
	@Qualifier("PointY") //지금 적합한 참조변수를 넣는다?
	
	Shape pointy; //new PointY()
	int x;
	int y;
	int radius;
	
	
	public Shape getPointy() {
		return pointy;
	}

//	public void setPointy(Shape pointy) {
//		System.out.println("setPointy(Shape pointy)");
//		this.pointy = pointy;
//	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public String make() {
		// TODO Auto-generated method stub
		return pointy.make();
	}

}
