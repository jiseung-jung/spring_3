package com.jiseung.s3.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnADAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String namespace="com.jiseung.s3.qna.QnADAO.";
	
	public List<QnADTO> qnaList() throws Exception {
		return sqlSession.selectList(namespace+"qnaList");
	}
	
	public QnADTO qnaSelect(long num) throws Exception{
		return sqlSession.selectOne(namespace+"qnaSelect", num);
	}
	
	public int qnaWrite(QnADTO qnaDTO) throws Exception{
		return sqlSession.insert(namespace+"qnaWrite", qnaDTO);
	}
	
	public int qnaDelete(long num) throws Exception{
		return sqlSession.delete(namespace+"qnaDelete", num);
	}
	
	public int qnaUpdate(QnADTO qnaDTO) throws Exception{
		return sqlSession.update(namespace+"qnaUpdate", qnaDTO);
	}
}
