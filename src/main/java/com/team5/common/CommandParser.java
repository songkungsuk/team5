package com.team5.common;

import javax.servlet.http.HttpServletRequest;

public class CommandParser {

	public static String getCmd(HttpServletRequest request) {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/")+1;
		return uri.substring(idx);
	}
}
