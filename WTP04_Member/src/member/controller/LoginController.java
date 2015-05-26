package member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AttributeAndView;
import common.controller.Controller;
import member.model.service.MemberService;
import member.vo.Member;

public class LoginController implements Controller{
	
	public AttributeAndView handle(HttpServletRequest request, 
										      HttpServletResponse response){
		AttributeAndView av = null;
//		1. 요청파라미터 조회
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		if(id==null||id.length()==0){
			av = new AttributeAndView("/WEB-INF/view/member/login_form.jsp", false, "error_message", "ID를 입력하세요");
			return av;//더이상 진행할 필요 없으므로 return 한다.
		}
		if(password==null||password.length()==0){//id는 입력받았지만 password는 입력이 안된 경우
			av = new AttributeAndView("/WEB-INF/view/member/login_form.jsp", false, "error_message", "Password를 입력하세요");
			return av;
		}
		
//		2. Business Logic 처리
		MemberService ms = MemberService.getInstance();
		try{
//			id로 회원 조회후 return 값이 null이면 ID가 없는 것 null이 아니면 ID가 있는 것으로 처리
			Member member = ms.getMemberById(id);
			
			if(member!=null){
				//패스 워드 비교
				if(password.equals(member.getPassword())){//ID/Password 모두 맞는 경우
					HttpSession session = request.getSession();
//					로그인 여부를 체크할 attribute로 로그인한 회원값(Member객체)를 넣는다.
					session.setAttribute("login_info", member);
					av = new AttributeAndView("/WEB-INF/view/member/main.jsp", false);
				}else{//패스워드가 틀린 경우
					av = new AttributeAndView("/WEB-INF/view/member/login_form.jsp", false, "error_message", "패스워드가 틀렸습니다. 확인 후 다시 로그인 하세요.");
				}
			}else{//id가 없는 경우
				av = new AttributeAndView("/WEB-INF/view/member/login_form.jsp", false, "error_message", id+"는 없는 ID입니다. 확인 후 다시 로그인 하세요.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			av = new AttributeAndView("/WEB-INF/view/error.jsp", false, "error_message", e.getMessage());
		}
		return av;
	}
}








