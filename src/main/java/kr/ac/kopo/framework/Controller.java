package kr.ac.kopo.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
	
}
