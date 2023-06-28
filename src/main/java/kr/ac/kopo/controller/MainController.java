package kr.ac.kopo.controller;

import kr.ac.kopo.framework.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 필요한 작업 수행
		
		// JSP 파일 경로 반환
		return "/index.jsp";
	}
}

	

