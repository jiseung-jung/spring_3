package com.jiseung.s3.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jiseung.s3.util.DBConnector;
import com.jiseung.s3.util.Pager;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String namespace="com.jiseung.s3.notice.NoticeDAO.";

//	@Autowired
//	private DBConnector dbConnector;
	
	public List<NoticeDTO> noticeList(Pager pager) throws Exception{
		return sqlSession.selectList(namespace+"noticeList", pager);
	}
	
	public long noticeCount(Pager pager) throws Exception{
		return sqlSession.selectOne(namespace+"noticeCount", pager);
	}
	
	public int noticeWrite(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(namespace+"noticeWrite", noticeDTO);
	}
	
	public NoticeDTO noticeSelect(long num) throws Exception {
		return sqlSession.selectOne(namespace+"noticeSelect", num);
	}
	
	public int noticeDelete(long num) throws Exception{
		return sqlSession.delete(namespace+"noticeDelete", num);
	}
	
	public int noticeUpdate(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(namespace+"noticeUpdate", noticeDTO);
	}
}
