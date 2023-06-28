package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.Member.MemberDAO;
import kr.ac.kopo.Member.MemberVO;
import kr.ac.kopo.framework.Controller;

public class InsertUserProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response ) {
		
			
		String id = request.getParameter("id");
		String password = request.getParameter("password"); 
		String name = request.getParameter("name"); 
		String email = request.getParameter("email");
		String usercode = request.getParameter("usercode");
		String phone = request.getParameter("phone");
		String postcode = request.getParameter("postcode");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setEmail(email);
		vo.setUsercode(usercode);
		vo.setPhone(phone);
		vo.setPostcode(postcode);
		vo.setAddress(address);
		
		MemberDAO dao = new MemberDAO();
		dao.insertUser(vo);
		
		
		return "/jsp/login/loginForm.jsp";

	}
	
}
