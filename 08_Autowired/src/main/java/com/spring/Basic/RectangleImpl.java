package com.spring.Basic;

public class RectangleImpl implements Rectangle{
	
	Shape pointy;
	int x;
	int y;
	int radius;
	
	
	public Shape getPointy() {
		return pointy;
	}

	public void setPointy(Shape pointy) {
		System.out.println("setPointy(Shape pointy)");
		this.pointy = pointy;
	}

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
