 package kr.ac.kopo.Account;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.Member.MemberVO;
import kr.ac.kopo.framework.Controller;



public class CreateAccountController implements Controller {

	 @Override
	    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		 
		 return "/jsp/myaccount/createAccount.jsp";
	 }
}
		
