package com.sunbeaminfo.sh.sp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileLoggerImpl implements Logger {
	private String logFilePath;
	public FileLoggerImpl() {
		this.logFilePath = "log.txt";
	}
	
	public String getLogFilePath() {
		return logFilePath;
	}

	public void setLogFilePath(String logFilePath) {
		this.logFilePath = logFilePath;
	}

	@Override
	public void log(String message) {
		File file = new File(logFilePath);
		try(FileOutputStream fout = new FileOutputStream(file, true)) {
			try(PrintWriter wr = new PrintWriter(fout)) {
				wr.println("FILE : " + message);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
