package com.spring.sample4;

public class CalcImpl implements Calc {
	
	private int su1; //setter
	private int su2; //생성자 
	
	public void setSu1(int su1) {
		System.out.println("setSu1(int su1)");
		this.su1 = su1;
	}

	public CalcImpl(int su2) {
		System.out.println("CalcImpl(int su2)");
		this.su2 = su2;
	}

	@Override
	public void calculate() {
		System.out.println("덧셈 = " + (su1+su2));
		System.out.println("뺼셈 = " + (su1-su2));
		System.out.println("곱셈 = " + (su1*su2));
		System.out.println("나눗셈 = " + (su1/su2));
		System.out.println("나머지 = " + (su1%su2));
		
	}
}
