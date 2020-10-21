package com.jiseung.s3.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiseung.s3.util.Pager;

@Service
public class QnAService {
	
	@Autowired
	private QnADAO qnaDAO;
	
	public List<QnADTO> qnaList(Pager pager) throws Exception {
		//** rownum 계산 
		pager.makeRow();
		
		//** page 계산
		long totalCount = qnaDAO.qnaCount(pager);
		pager.setTotalCount(totalCount);
		pager.makePage();
		
		return qnaDAO.qnaList(pager);
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
	
	public int qnaReply(QnADTO qnaDTO) throws Exception{
		QnADTO parent = qnaDAO.qnaSelect(qnaDTO.getNum());
		int result = qnaDAO.qnaReplyUpdate(parent);
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		return qnaDAO.qnaReply(qnaDTO);
	}

}
