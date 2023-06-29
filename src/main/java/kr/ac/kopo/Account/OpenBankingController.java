package kr.ac.kopo.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.Member.MemberDAO;
import kr.ac.kopo.Member.MemberVO;
import kr.ac.kopo.framework.Controller;

public class OpenBankingController implements Controller {

		@Override
		public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

			 HttpSession session = request.getSession();
		     MemberVO user = (MemberVO) session.getAttribute("loginuser");

			
			MemberDAO memberDAO = new MemberDAO();
			
			// 회원이 약관에 동의한 여부를 확인합니다.
	//		boolean agreed = memberDAO.isAgreedToTerms(id);
			
			// 동의 여부를 요청 객체의 속성으로 설정합니다.
		//	request.setAttribute("agreed", agreed);
			
			return "/jsp/myaccount/openBanking.jsp";
		}
	
}
