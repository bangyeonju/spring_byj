package com.spring.sample3;

public class PointImpl implements Point{
	private double xpos;
	private double ypos;
	
	public PointImpl() {
			System.out.println("PointImpl생성자");
	}
	@Override
	public double getXpos() {
		// TODO Auto-generated method stub
		return  xpos;
	}

	@Override
	public void setXpos(double xpos) {
		this.xpos= xpos;
	}

	@Override
	public double getYpos() {
		// TODO Auto-generated method stub
		return ypos;
	}

	@Override
	public void setYpos(double ypos) {
		this.ypos = ypos;
	}

}
