package member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AttributeAndView;
import common.controller.Controller;
import member.model.service.MemberService;
import member.vo.Member;

public class ModifyMemberController implements Controller {
	
	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response){
		AttributeAndView av = null;
		
//		1. 로그인 여부 체크
		HttpSession session = request.getSession();
		Member loginInfo = (Member)session.getAttribute("login_info");
		if(loginInfo == null){//로그인 안된 경우
			av = new AttributeAndView("/WEB-INF/view/member/login_form.jsp", false, "error_message", "로그인 후 회원정보 수정이 가능합니다. 로그인 먼저 하세요");
			return av;
		}

//		2. 요청파라미터 조회
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email= request.getParameter("email");

		if(password==null||password.length()==0){
			av = new AttributeAndView("/WEB-INF/view/member/modify_form.jsp", false, "error_message", "Password는 필수 입력사항입니다.");
			return av;//더이상 진행할 필요 없으므로 return 한다.
		}
		if(name==null||name.length()==0){
			av = new AttributeAndView("/WEB-INF/view/member/modify_form.jsp", false, "error_message", "이름은 필수 입력사항입니다.");
			return av;//더이상 진행할 필요 없으므로 return 한다.
		}
		if(email==null||email.length()==0){
			av = new AttributeAndView("/WEB-INF/view/member/modify_form.jsp", false, "error_message", "이메일은 필수 입력사항입니다.");
			return av;//더이상 진행할 필요 없으므로 return 한다.
		}
		
		Member member = new Member(id, password, name, email);

//		3. 비지니스 로직 처리
		MemberService ms = MemberService.getInstance();

		try {
			ms.modifyMember(member);
			av = new AttributeAndView("/WEB-INF/view/member/member_info.jsp", false);
//			Session의 회원 정보를 수정된 값으로 변경
			loginInfo.setPassword(member.getPassword());
			loginInfo.setName(member.getName());
			loginInfo.setEmail(member.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
			av = new AttributeAndView("/WEB-INF/view/error.jsp", false, "error_message", e.getMessage());
		}
		
		return av;
	}

}
