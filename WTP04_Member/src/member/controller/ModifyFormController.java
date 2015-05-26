package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AttributeAndView;
import common.controller.Controller;

public class ModifyFormController implements Controller {
	
	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response){
		AttributeAndView av = null;
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("login_info");
		if(obj==null){
			av = new AttributeAndView("/WEB-INF/view/member/login_form.jsp", false, "error_message", "로그인 후 회원정보 수정하십시요");
		}else{
			av = new AttributeAndView("/WEB-INF/view/member/modify_form.jsp", false);;
		}
		return av;
	}

}
