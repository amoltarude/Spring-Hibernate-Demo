package com.sunbeaminfo.sh.sp;

public class ConsoleLoggerImpl implements Logger {
	public void log(String message) {
		System.out.println("CONS : " + message);
	}
}
