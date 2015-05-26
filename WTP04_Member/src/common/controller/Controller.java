package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Controller로직을 처리할 모든 Controller들의 타입역할을 할 interface
public interface Controller {
	//service()(doXXX()) 역할을 할 메소드.
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
