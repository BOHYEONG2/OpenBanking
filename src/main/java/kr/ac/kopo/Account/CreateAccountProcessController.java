package kr.ac.kopo.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.Member.MemberVO;
import kr.ac.kopo.framework.Controller;

public class CreateAccountProcessController implements Controller {

		@Override
	    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

	        HttpSession session = request.getSession();
	        MemberVO user = (MemberVO) session.getAttribute("loginuser");

	        String accountNum = "111" + generateRandomNumber(9);
	        String userId = request.getParameter("id");
	        System.out.println(userId);
	        String accountName = request.getParameter("ac_name");
	        System.out.println(accountName);
	        String accountPW = request.getParameter("ac_pw");
	        System.out.println(accountPW);
	        int ac_money = Integer.parseInt(request.getParameter("ac_money"));
	     //   long ac_money = Long.parseLong(request.getParameter("ac_money"));
	        String bankCode = "111";
	        
	        AccountVO vo = new AccountVO();
	        vo.setAc_number(accountNum);
	        vo.setId(userId);
	        vo.setAC_PW(accountPW);
	        vo.setAC_NAME(accountName);
	        vo.setAC_MONEY(ac_money);
	        vo.setBankCode(bankCode);
	        vo.setSTATE("활성화");
	        vo.setPD_NUMBER(0);
	        vo.setBank_cd(bankCode);

	        AccountDAO dao = new AccountDAO();
	        dao.createAccount(vo);

	        return "/jsp/myaccount/myaccount.jsp";
	    }

	  private String generateRandomNumber(int length) {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            int digit = (int) (Math.random() * 10);
	            sb.append(digit);
	        }
	        return sb.toString();
	    }
}
		
