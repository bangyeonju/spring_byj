package com.spring.Basic;

public class Main {
	public static void main(String[] args) {
		Shape px = new PointX(); //Shape�� PointX�� �θ𿩼� ��밡��
		Shape py = new PointY(); //Shape�� PointY�� �θ𿩼� ��밡��
		
		CircleImpl circle = new CircleImpl();
		circle.setPointx(px);
		System.out.println(circle.make());
		RectangleImpl rec = new RectangleImpl();
		rec.setPointy(py);
		System.out.println(rec.make());
	}
}
