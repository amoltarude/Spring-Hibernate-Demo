package com.sunbeaminfo.sh.sp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BoxImpl implements Box {
	private int length;
	private int breadth;
	private int height;
	
	@Autowired
	@Qualifier("fl")
	private Logger logger;
	public BoxImpl() {

	}
	public BoxImpl(int length, int breadth, int height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}
	
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	@PostConstruct
	public void boxInit() {
		logger.log("BoxImpl.boxInit() called...");	
	}
	
	@PreDestroy
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
