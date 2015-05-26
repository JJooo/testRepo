package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkController implements Controller{

	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getParameter("href");
		return new AttributeAndView("/WEB-INF/view"+url, false); 
	}
	

}
