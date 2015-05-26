package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.vo.Member;
import common.controller.AttributeAndView;
import common.controller.Controller;

public class JoinSuccessController implements Controller {

	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		MemberService ms = MemberService.getInstance();
		Member member = ms.getMemberById(id);
		return new AttributeAndView("/WEB-INF/view/member/join_success.jsp", false, "member", member);
	}

}
