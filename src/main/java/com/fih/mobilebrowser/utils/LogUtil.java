package com.fih.mobilebrowser.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LogUtil {
	public static String getStackTraceString(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String sStackTrace = sw.toString(); // stack trace as a string
		return sStackTrace;
	}
}