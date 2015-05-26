package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AttributeAndView;
import common.controller.Controller;
import member.vo.Member;

public class LogoutController implements Controller {
	
	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("login_info");
		if(member==null){
			request.setAttribute("error_message", "로그인 후 로그아웃 할 수 있습니다. 로그아웃 먼저 하세요");
		}else{
			session.invalidate();
		}
		return new AttributeAndView("/WEB-INF/view/member/login_form.jsp", false);
	}

}









