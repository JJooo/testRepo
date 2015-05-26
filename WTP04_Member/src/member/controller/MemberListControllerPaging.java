package member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import common.controller.AttributeAndView;
import common.controller.Controller;
import common.util.PagingBean;

public class MemberListControllerPaging implements Controller{

	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AttributeAndView av = null;
		int pageNo = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		try{
		MemberService ms = MemberService.getInstance();
		Map map = ms.getMemberListPaging(pageNo);
		
		
		int totalpage = (int) map.get("count");
		PagingBean pb = new PagingBean(totalpage, pageNo);
		map.put("pb", pb);
		return new AttributeAndView("/WEB-INF/view/member/member_list_paging.jsp",false, map);
		
		}catch(Exception o){
			o.printStackTrace();
			return new AttributeAndView("WEB-INF/view/error.jsp", false, "error_message" , o.getMessage());
		}
	}
}
