package kr.ac.kopo.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.framework.Controller;

public class TransferMoneyProcessController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		 // 클라이언트로부터 전송된 파라미터 값들을 받아옴
        String senderAcNumber = request.getParameter("senderAcNumber");
        String senderName = request.getParameter("senderName");
        String receiverAcNumber = request.getParameter("receiverAcNumber");
        String receiverBank = request.getParameter("receiverBank");
        String receiverName = request.getParameter("receiverName");
        int sendMoney = Integer.parseInt(request.getParameter("sendMoney"));
        System.out.println(sendMoney);
        String message = request.getParameter("message");
        
        // AccountDAO 인스턴스 생성
        AccountDAO accountDAO = new AccountDAO();

        // 송금 기능 수행
        accountDAO.transferMoney(senderAcNumber, receiverAcNumber, sendMoney);

        // 송금한 정보를 request 속성에 저장
        request.setAttribute("senderName", senderName);
        request.setAttribute("senderAcNumber", senderAcNumber);
        request.setAttribute("sendMoney", sendMoney);
        System.out.println(sendMoney);
        request.setAttribute("receiverBank", receiverBank);
        request.setAttribute("receiverName", receiverName);
        request.setAttribute("receiverAcNumber", receiverAcNumber);
        request.setAttribute("message", message);

        
        // 송금 후 결과를 클라이언트에게 보여줄 화면(뷰)의 경로를 반환
        return "/jsp/myaccount/transferCheck.jsp";
	
	}
}
