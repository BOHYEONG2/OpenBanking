package kr.ac.kopo.Account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.Member.MemberVO;
import kr.ac.kopo.framework.Controller;

public class TransferMoneyController implements Controller {
	
/*	   private AccountDAO accountDAO;

	    public TransferMoneyController() {
	        // AccountDAO 객체를 생성하여 주입받음
	        this.accountDAO = new AccountDAO();
	    }
	*/
	@Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        
		HttpSession session = request.getSession();
    	MemberVO user = (MemberVO) session.getAttribute("loginUser");
    	
    	AccountVO accountVO = new AccountVO();
    	accountVO.setId(user.getId());
    	
    	AccountDAO accountDAO = new AccountDAO();
    	List<AccountVO> accountList = accountDAO.getAccountList(accountVO);
    	request.setAttribute("accountList", accountList);
    	
    
        // 계좌 이체 화면으로 이동
        return "/jsp/myaccount/transferMoney.jsp";
    }
}