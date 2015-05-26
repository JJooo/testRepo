package member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.vo.Member;

import common.controller.AttributeAndView;
import common.controller.Controller;

public class MemberListController implements Controller {

	 
	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response){
		AttributeAndView av = null;
		try {
			MemberService ms = MemberService.getInstance();
			List<Member> list = ms.getMemberList();
			av = new AttributeAndView("/WEB-INF/view/member/member_list.jsp", false, "member_list", list);
		} catch (Exception e) {
			e.printStackTrace();
			av = new AttributeAndView("/WEB-INF/view/error.jsp", false, "error_message", e.getMessage());
		}
		return av;
	}

}
