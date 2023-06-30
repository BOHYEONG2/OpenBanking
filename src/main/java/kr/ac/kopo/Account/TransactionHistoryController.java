package kr.ac.kopo.Account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.Member.MemberVO;
import kr.ac.kopo.framework.Controller;

public class TransactionHistoryController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
/*		
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("loginuser");

		AccountVO accountVO = new AccountVO();
		accountVO.setId(user.getId());

		AccountDAO dao = new AccountDAO();
		List<AccountVO> accountList = dao.getAccountListById(accountVO);

		request.setAttribute("accountList", accountList);

		return "/jsp/myaccount/transactionList.jsp";
	}
}
*/		
	
	
		// 세션에서 로그인된 사용자 정보 가져오기
		HttpSession session = request.getSession();
        MemberVO user = (MemberVO) session.getAttribute("loginuser");
        
        // 클라이언트로부터 전송된 파라미터 값들을 받아옴
        String acNumber = request.getParameter("acNumber");

        // AccountRecordDAO 인스턴스 생성
        AccountRecordDAO accountRecordDAO = new AccountRecordDAO();

        // 입출금 내역 조회
        List<AccountRecordVO> accountRecords = accountRecordDAO.getAccountRecords(acNumber);
        System.out.println("acNumber : " + acNumber);
        for(AccountRecordVO vo : accountRecords)
        	System.out.println(vo);
        // 조회된 내역을 request 속성에 저장
        request.setAttribute("accountRecords", accountRecords);

        // 입출금 내역 조회 페이지로 이동
        return "/jsp/myaccount/transactionList.jsp";
    }
}