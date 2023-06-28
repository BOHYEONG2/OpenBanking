package kr.ac.kopo.Account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.Member.MemberDAO;
import kr.ac.kopo.Member.MemberVO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.Account.AccountDAO;

public class myAccountController implements Controller {

	
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	
    	HttpSession session = request.getSession();
    	MemberVO user = (MemberVO) session.getAttribute("loginUser");
    	
    	AccountVO accountVO = new AccountVO();
    	accountVO.setId(user.getId());
    	
    	AccountDAO accountDAO = new AccountDAO();
    	List<AccountVO> accountList = accountDAO.getAccountList(accountVO);
    	request.setAttribute("accountList", accountList);
    	
    	return "/jsp/myaccount/myaccount.jsp";
    }
}