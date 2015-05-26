package member.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import member.vo.Member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.util.DatabaseUtil;
import common.util.PagingBean;

public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	private SqlSessionFactory factory;
	private String namespace = "membership.member.";
	
	private MemberDAO(){
		factory = DatabaseUtil.getInstance().getSqlSessionFactory();
	}
	
	public static MemberDAO getInstance(){
		return instance;
	}

	// 회원 등록
	public int insertMember(Member member) throws SQLException{
		SqlSession session = factory.openSession(true);
		try {
			return session.insert(namespace+"insertMember", member	);
		} finally {
			session.close();
		}
	}
	
	// 전체회원 조회
	public List<Member> selectAllMember() throws SQLException{
		SqlSession session = factory.openSession(true);
		try {
			return session.selectList(namespace+"selectAllMember");
		} finally {
			session.close();
		}
	}
	
	// 페이지 단위로 전체회원 조회
	public List<Member> selectAllMemberPaging(int pageNo) throws SQLException{
		Map map = new HashMap();
		map.put("pageNo", pageNo);
		map.put("perpage", PagingBean.CONTENTS_PER_PAGE);
		SqlSession session = factory.openSession(true);
		try {
			return session.selectList(namespace + "selectAllMemberPaging", map);
		} finally {
			session.close();
		}
	}
	
	// 전체회원 인원 수 조회
	public int selectTotalMemberCount() throws SQLException{
		SqlSession session = factory.openSession(true);
		try {
			
			return session.selectOne(namespace + "selectTotalMemberCount");
		} finally {
			session.close();
		}
	}
	
	// ID로 회원 조회
	public Member selectMemberById(String id) throws SQLException{
		SqlSession session = factory.openSession(true);
		try {
			return session.selectOne(namespace+"selectMemberById", id);
		} finally {
			session.close();
		}
	}

	// 회원 정보 수정
	public int updateMember(Member member) throws SQLException{
		SqlSession session = factory.openSession(true);
		try {
			return session.update(namespace+"updateMember", member);
		} finally {
			session.close();
		}
	}

	// 회원 탈퇴
	public int deleteMemberById(String id) throws SQLException{
		SqlSession session = factory.openSession(true);
		try {
			return session.delete(namespace+"deleteMemberById", id);
		} finally {
			session.close();
		}
	}
	
}
