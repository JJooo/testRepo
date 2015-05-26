package member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AttributeAndView;
import common.controller.Controller;
import member.model.service.MemberService;
import member.vo.Member;

public class RemoveMemberController implements Controller {
	
	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Member loginInfo = (Member)session.getAttribute("login_info");
		AttributeAndView av = null;
		if(loginInfo == null){//로그인 안된 경우
			av = new AttributeAndView("/WEB-INF/view/member/login_form.jsp", false, "error_message", "로그인 후 탈퇴가 가능합니다. 로그인 먼저 하세요");
		}else{
			try {
				MemberService ms = MemberService.getInstance();
				ms.removeMemberById(loginInfo.getId());
				av = new AttributeAndView("/WEB-INF/view/member/login_form.jsp", false);
//				세션 소멸시키기
				session.invalidate();
			}catch (SQLException e) {
				e.printStackTrace();
				av = new AttributeAndView("/WEB-INF/view/error.jsp", false, "error_message", e.getMessage());
			} 
		}
		return av;
	}

}
