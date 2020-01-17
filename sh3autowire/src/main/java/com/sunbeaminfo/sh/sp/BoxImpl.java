package com.sunbeaminfo.sh.sp;

import org.springframework.beans.factory.annotation.Autowired;

public class BoxImpl implements Box {
	private int length;
	private int breadth;
	private int height;
	
	private Logger logger;
	public BoxImpl() {

	}
	public BoxImpl(int length, int breadth, int height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}
	public BoxImpl(ConsoleLoggerImpl cl) {
		this.logger = cl;
	}
	
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	public void boxInit() {
		logger.log("BoxImpl.boxInit() called...");	
	}
	public void boxDestroy() {
		logger.log("BoxImpl.boxDestroy() called...");
	}	
	@Override
	public int getLength() {
		return length;
	}
	@Override
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public int getBreadth() {
		return breadth;
	}
	@Override
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	@Override
	public int getHeight() {
		return height;
	}
	@Override
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "BoxImpl [length=" + length + ", breadth=" + breadth + ", height=" + height + "]";
	}
	@Override
	public int calcVolume() {
		logger.log("BoxImpl.calcVolume() called...");
		return this.length * this.breadth * this.height;
	}
}
