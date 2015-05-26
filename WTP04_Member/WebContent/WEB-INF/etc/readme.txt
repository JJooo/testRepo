패키지 설명
common 패키지 - 공통처리를 담당하는 클래스들을 모아놓은 패키지
  	- 하위 패키지
    	- controller : MVC 패턴의 공통 Controller 관련 클래스들을 모아놓은 패키지. 
    	- util : 공통 기능을 제공하는 클래스들을 모아놓은 패키지
member 패키지 - 회원관리를 담당하는 클래스들을 모아놓은 패키지
	- 하위 패키지
 		- controller : MVC 패턴의 Controller클래스들을 모아놓은 패키지. 각 기능별 컨트롤러 클래스들의 패키지
 		- vo : Value Object 클래스들을 넣을 패키지
 		- model : MVC 패턴의 Model(Business Logic) 클래스들을 모아놓은 패키지
 			- 하위 패키지
 				- service : Business Service 클래스들을 넣을 패키지
 				- dao : DAO 클래스들을 넣을 패키지
 		- exception : 업무처리시 발생하는 예외클래스들을 모아놓은 패키지
 		
 		
JSP 
Root 하위
 - index.jsp : 메인페이지로 이동 (Application 시작 페이지)
WEB-INF/view 하위 - 공통 jsp를 모아 놓은 페이지
 
 - menu.jsp : 메뉴 링크(네비게이션)을 제공하는 jsp
 - error.jsp : 처리 중 오류 발생시 오류 메세지를 처리하는 jsp

 
WEB-INF/view/member- 회원관리 처리 jsp를 모아 놓은 페이지
  - join_form.jsp : 회원 가입 양식(폼)을 보여주는 페이지
  - join_success.jsp : 가입 성공 후 성공 메세지를 보여주는 페이지로 등록한 내용을 보여준다.
  - login_form.jsp : 로그인 양식(폼)을 보여주는 페이지
  - main.jsp : 회원관리 메인 페이지
  - member_info.jsp : 본인정보조회 처리후 조회된 회원의 정보를 보여주는 페이지
  - member_list.jsp : 전체 회원조회 처리 후 조회된 회원 목록(List)를 보여주는 페이지
  - modify_form.jsp : 회원 정보 수정 폼