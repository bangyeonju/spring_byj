package com.spring.Basic;

public class Main {
	public static void main(String[] args) {
		Shape px = new PointX(); //Shape이 PointX의 부모여서 사용가능
		Shape py = new PointY(); //Shape이 PointY의 부모여서 사용가능
		
		CircleImpl circle = new CircleImpl();
		circle.setPointx(px);
		System.out.println(circle.make());
		RectangleImpl rec = new RectangleImpl();
		rec.setPointy(py);
		System.out.println(rec.make());
	}
}
