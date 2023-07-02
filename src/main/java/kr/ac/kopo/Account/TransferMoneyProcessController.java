package kr.ac.kopo.Account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.Member.MemberVO;
import kr.ac.kopo.framework.Controller;

public class TransferMoneyProcessController implements Controller{
	
		@Override
		public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			
			HttpSession session = request.getSession();
		    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		    
		    AccountVO accountVO = new AccountVO();
	    	accountVO.setId(loginUser.getId());
	    	
	    	 String acNumber = request.getParameter("acNumber");
	    	 System.out.println(acNumber);
			 // 클라이언트로부터 전송된 파라미터 값들을 받아옴
	        String senderAcNumber = request.getParameter("senderAcNumber");
	        String senderName = loginUser.getName();
	        String receiverAcNumber = request.getParameter("receiverAcNumber");
	        System.out.println("ra : " + receiverAcNumber);
	        String receiverBank = request.getParameter("receiverBank");
	        String receiverName = request.getParameter("receiverName");
	        
	        int sendMoney = Integer.parseInt(request.getParameter("sendMoney"));
	        System.out.println("sendmoney : " + sendMoney);
	        String message = request.getParameter("message");
	        
	        AccountRecordVO accountRecordVO = new AccountRecordVO();
	        // AC_NUMBER 값을 설정해줍니다.
	        accountRecordVO.setAcNumber(acNumber);

	        // AccountDAO 인스턴스 생성
	        AccountDAO accountDAO = new AccountDAO();
	        
	        // 송금 기능 수행
	        accountDAO.transferMoney(senderAcNumber, receiverAcNumber, sendMoney);
	        
	        List<AccountVO> accountList = accountDAO.getAccountList(accountVO);
	    	request.setAttribute("accountList", accountList);
	    	
	        // 송금한 정보를 request 속성에 저장
	        
	        request.setAttribute("senderName", senderName);
	        request.setAttribute("senderAcNumber", senderAcNumber);
	        request.setAttribute("sendMoney", sendMoney);
	        System.out.println(sendMoney);
	        request.setAttribute("receiverBank", receiverBank);
	        request.setAttribute("receiverName", receiverName);
	        request.setAttribute("receiverAcNumber", receiverAcNumber);
	        request.setAttribute("message", message);
	        
	        AccountRecordDAO dao = new  AccountRecordDAO();
	        dao.insertTransaction(accountRecordVO);
	        
	        AccountRecordVO accountRecord = new AccountRecordVO();
	        dao.insertTransaction(accountRecord);
	        
	        // 송금 후 결과를 클라이언트에게 보여줄 화면(뷰)의 경로를 반환
	        return "/jsp/myaccount/transactionList.jsp";
		
		}
	}
    