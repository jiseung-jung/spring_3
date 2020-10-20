package com.jiseung.s3.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnAService {
	
	@Autowired
	private QnADAO qnaDAO;
	
	public List<QnADTO> qnaList() throws Exception {
		return qnaDAO.qnaList();
	}
	
	public QnADTO qnaSelect(long num) throws Exception{
		return qnaDAO.qnaSelect(num);
	}
	
	public int qnaWrite(QnADTO qnaDTO) throws Exception{
		return qnaDAO.qnaWrite(qnaDTO);
	}
	
	public int qnaDelete(long num) throws Exception{
		return qnaDAO.qnaDelete(num);
	}
	
	public int qnaUpdate(QnADTO qnaDTO) throws Exception {
		return qnaDAO.qnaUpdate(qnaDTO);
	}

}
