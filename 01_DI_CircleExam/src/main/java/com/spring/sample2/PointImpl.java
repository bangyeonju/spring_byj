package com.spring.sample2;

public class PointImpl implements Point{
	private double xpos;
	private double ypos;
	
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
