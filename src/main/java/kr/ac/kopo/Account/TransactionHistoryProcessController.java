package kr.ac.kopo.Account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.Member.MemberVO;
import kr.ac.kopo.framework.Controller;

public class TransactionHistoryProcessController implements Controller{
	 
	   @Override
	   public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	/*
		  AccountVO accountVO = new AccountVO();
		  HttpSession session = request.getSession();
	      MemberVO user = (MemberVO) session.getAttribute("loginuser");
	  
	      AccountDAO dao = new AccountDAO();
	      List<AccountVO> accountList = dao.getAccountListById(accountVO);
	      request.setAttribute("accountList", accountList);
	      
	      
	      String accountNum = request.getParameter("accountNum");
	      
	      AccountRecordVO vo = new AccountRecordVO();
	      vo.setAccountNum1(accountNum);
	      AccountRecordDAO transaction = new AccountRecordDAO();
	      List<TransactionVO> transactionList = transaction.getTransactionHistoryByAccountNum(vo);
	      request.setAttribute("transactionList", transactionList);
	      
	      return "/jsp/transaction/TransactionHistoryProcess.jsp";
	   }

		   */
		   HttpSession session = request.getSession();
		   MemberVO login = (MemberVO) session.getAttribute("loginUser");
		    String userID = login.getId(); 
		    AccountDAO accountDAO = new AccountDAO();
	//	    List<AccountVO> accountList = accountDAO.getAccountListById(user.getId());
	//	    request.setAttribute("accountList", accountList);

		    String accountNum = request.getParameter("accountNum");

		    AccountRecordDAO accountRecordDAO = new AccountRecordDAO();
		    List<AccountRecordVO> accountRecords = accountRecordDAO.getAccountRecords(accountNum);
		    request.setAttribute("accountRecords", accountRecords);

		    return "/jsp/myaccount/transactionList.jsp";
		}
}