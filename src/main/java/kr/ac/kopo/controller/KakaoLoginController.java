package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.framework.Controller;

public class KakaoLoginController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		return "/jsp/login/kakao.jsp";
	}

}
