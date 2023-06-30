package kr.ac.kopo.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import kr.ac.kopo.framework.Controller;

public class AccountTransactionListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // 클라이언트로부터 전송된 파라미터 값들을 받아옴
        String acNumber = request.getParameter("acNumber");

        // AccountRecordDAO 인스턴스 생성
        AccountRecordDAO accountRecordDAO = new AccountRecordDAO();

        // 계좌번호에 해당하는 입출금 내역 조회
        List<AccountRecordVO> accountRecords = accountRecordDAO.getAccountRecords(acNumber);

        // 조회 결과를 request 속성에 저장
        request.setAttribute("accountRecords", accountRecords);

        // 입출금 내역 조회 화면으로 이동
        return "/jsp/myaccount/transactionList.jsp";
    }
}