package kr.ac.kopo.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.Member.MemberVO;
import kr.ac.kopo.framework.Controller;

public class TransferCheckController implements Controller {

		@Override
		public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			 // 클라이언트로부터 전송된 파라미터 값들을 받아옴
			HttpSession session = request.getSession();
		    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		    
		    String senderName = loginUser.getName();
	        String senderAcNumber = request.getParameter("senderAcNumber");
	        int sendMoney = Integer.parseInt(request.getParameter("sendMoney"));
	        String receiverBank = request.getParameter("receiverBank");
	        String receiverName = request.getParameter("receiverName");
	        String receiverAcNumber = request.getParameter("receiverAcNumber");
	        String message = request.getParameter("message");
	        String accountPassword = request.getParameter("accountPassword");
	        System.out.println(sendMoney);
	  
/*	        AccountDAO accountDAO = new AccountDAO();
	        AccountVO receiverAccount = accountDAO.getAccountByAccountNumber(receiverAcNumber);
	 //       receiverAccount.setName(receiverName);
	        String receiverName = receiverAccount.getName();
*/
	        AccountDAO accountDAO = new AccountDAO();
	        AccountVO senderAccount = accountDAO.getAccountByAccountNumber(senderAcNumber);
	        AccountVO receiverAccount = accountDAO.getAccountByAccountNumber(receiverAcNumber);

	        
	        // 송금 정보를 request 속성으로 설정
	        request.setAttribute("senderName", senderName);
	        request.setAttribute("accountPassword", accountPassword);
	        System.out.println(accountPassword);
	        request.setAttribute("senderName", senderName);
	        request.setAttribute("senderAcNumber", senderAcNumber);
	        request.setAttribute("sendMoney", sendMoney);
	        request.setAttribute("receiverBank", receiverBank);
	        request.setAttribute("receiverName", receiverName);
	        request.setAttribute("receiverAcNumber", receiverAcNumber);
	        request.setAttribute("message", message);
	        System.out.println(message);

	        // 송금 확인 화면(뷰)의 경로를 반환
	        return "/jsp/myaccount/transferCheck.jsp";
		}
}

