package com.sunbeaminfo.sh.sp;

public class BoxImpl {
	private int length;
	private int breadth;
	private int height;
	public BoxImpl() {
		System.out.println("BoxImpl() called");
	}
	public BoxImpl(int length, int breadth, int height) {
		System.out.println("BoxImpl(int,int,int) called");
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}
	public void boxInit() {
		System.out.println("BoxImpl.boxInit() called.");
	}
	public void boxDestroy() {
		System.out.println("BoxImpl.boxDestroy() called.");
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		System.out.println("BoxImpl.setLength() called");
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		System.out.println("BoxImpl.setBreadth() called");
		this.breadth = breadth;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		System.out.println("BoxImpl.setHeight() called");
		this.height = height;
	}
	@Override
	public String toString() {
		return "BoxImpl [length=" + length + ", breadth=" + breadth + ", height=" + height + "]";
	}
	public int calcVolume() {
		return this.length * this.breadth * this.height;
	}
}
