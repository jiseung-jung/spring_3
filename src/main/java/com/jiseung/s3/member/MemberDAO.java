package com.jiseung.s3.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jiseung.s3.notice.NoticeDTO;
import com.jiseung.s3.util.Pager;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.jiseung.s3.member.MemberDAO.";
	
	public List<MemberDTO> memberList(Pager pager) {
		return sqlSession.selectList(namespace+"memberList", pager);
	}
	
	public long memberCount() throws Exception{
		return sqlSession.selectOne(namespace+"memberCount");
	}
	
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(namespace+"memberJoin", memberDTO);
	}
	
	public MemberDTO memberSelect(long num) throws Exception{
		return sqlSession.selectOne(namespace+"memberSelect", num);
	}
	
	public int memberDelete(long num) throws Exception{
		return sqlSession.delete(namespace+"memberDelete", num);
	}
	
	

}
