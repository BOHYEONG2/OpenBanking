package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.Member.MemberDAO;
import kr.ac.kopo.Member.MemberVO;
import kr.ac.kopo.framework.Controller;

public class LoginProcessController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        MemberVO login = new MemberVO();
        login.setId(id);
        login.setPassword(password);

        MemberDAO dao = new MemberDAO();
        try {
            MemberVO user = dao.login(login);
            HttpSession session = request.getSession();

            if (user != null) {
                request.setAttribute("loginUser", user);
                session.setAttribute("loginUser", user);
                return "redirect:/MyBanking/main.do";
            } else {
                request.setAttribute("msg", "입력하신 ID 또는 패스워드가 잘못되었습니다.");
                return "/jsp/login/loginForm.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "로그인 과정에서 오류가 발생하였습니다.");
            return "/jsp/login/error.jsp";
        }
    }
}