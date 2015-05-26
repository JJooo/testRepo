package member.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.util.PagingBean;

import member.exception.DuplicatedIdException;
import member.model.dao.MemberDAO;
import member.vo.Member;

public class MemberService {
	
	private static MemberService instance = new MemberService();
	private MemberDAO dao;
	
	private MemberService(){
		dao = MemberDAO.getInstance();
	}
	
	public static MemberService getInstance(){
		return instance;
	}

	public void joinMember(Member member) throws SQLException, DuplicatedIdException{
		if(dao.selectMemberById(member.getId())!=null){
			throw new DuplicatedIdException(member.getId()+"는 이미 등록된 아이디입니다. ID를 변경하세요");
		}
		dao.insertMember(member);
	}

	public List<Member> getMemberList() throws SQLException{
		List<Member> list = dao.selectAllMember();
		return list;
	}
	
	public Map<String, Object> getMemberListPaging(int pageNo) throws SQLException{
		Map map = new HashMap();
		List list = dao.selectAllMemberPaging(pageNo);
		int count = dao.selectTotalMemberCount();
		map.put("member_list", list);
		map.put("count",count);
		return map;
	}

	public Member getMemberById(String id) throws SQLException{
		Member member = dao.selectMemberById(id);
		return member;
	}

	public void modifyMember(Member member) throws SQLException{
		dao.updateMember(member);
	}

	public void removeMemberById(String id) throws SQLException {
		dao.deleteMemberById(id);
	}
}
