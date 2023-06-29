package kr.ac.kopo.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.framework.Controller;

public class OpenBankingAgreementController implements Controller {
	
		@Override
		public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

			return "/jsp/myaccount/openBankingAgreement.jsp";
		}
}
